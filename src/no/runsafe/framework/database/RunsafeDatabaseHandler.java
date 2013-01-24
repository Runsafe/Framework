package no.runsafe.framework.database;

import no.runsafe.framework.output.ConsoleColors;
import no.runsafe.framework.output.IOutput;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.picocontainer.Startable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public final class RunsafeDatabaseHandler implements IDatabase, Startable
{
	private final String databaseURL;
	private final String databaseUsername;
	private final String databasePassword;

	private final IOutput output;
	private final List<ISchemaChanges> schemaUpdaters;
	private final SchemaRevisionRepository revisionRepository;

	public RunsafeDatabaseHandler(
		IOutput output, List<ISchemaChanges> schemaUpdaters, SchemaRevisionRepository revisionRepository
	)
	{
		YamlConfiguration config = new YamlConfiguration();
		try
		{
			config.load("runsafe/db.yml");
		}
		catch (FileNotFoundException e)
		{
			config.createSection("database");
			config.set("database.url", "jdbc:mysql://localhost:3306/minecraft");
			config.set("database.username", "minecraftuser");
			config.set("database.password", "p4ssw0rd");
			try
			{
				config.save("runsafe/db.yml");
			}
			catch (IOException e1)
			{
				output.logException(e1);
			}
			output.write("\n" +
				"\n" +
				ConsoleColors.RED +
				"================================================================\n" +
				"Created new default runsafe/db.yml - you should change this now!\n" +
				"================================================================" +
				ConsoleColors.RESET
			);
		}
		catch (IOException e)
		{
			output.logException(e);
		}
		catch (InvalidConfigurationException e)
		{
			output.logException(e);
		}
		this.databaseURL = config.getString("database.url");
		this.databaseUsername = config.getString("database.username");
		this.databasePassword = config.getString("database.password");
		this.output = output;
		this.schemaUpdaters = schemaUpdaters;
		this.revisionRepository = revisionRepository;
	}

	@Override
	public Connection beginTransaction()
	{
		try
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			return conn;
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage(), Level.SEVERE);
			return null;
		}
	}

	@Override
	public void commitTransaction(Connection conn)
	{
		try
		{
			conn.commit();
			conn.close();
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
		}
	}

	@Override
	public void rollbackTransaction(Connection conn)
	{
		try
		{
			conn.rollback();
			conn.close();
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
		}
	}

	@Override
	public PreparedStatement prepare(String sql)
	{
		try
		{
			Connection conn = getConnection();
			if (conn == null)
				return null;
			return conn.prepareStatement(sql);
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
			return null;
		}
	}

	@Override
	public void start()
	{
		if (schemaUpdaters != null && !schemaUpdaters.isEmpty())
			executeSchemaChanges();
	}

	@Override
	public void stop()
	{
	}

	protected Connection getConnection()
	{
		try
		{
			if (conn == null || conn.isClosed())
			{
				conn = DriverManager.getConnection(this.databaseURL, this.databaseUsername, this.databasePassword);
				output.fine(String.format("Opening connection to %s by %s", databaseURL, databaseUsername));
			}
			else
				output.fine(String.format("Reusing connection to %s", databaseURL));
			if (conn == null)
				output.fine("Connection is null");
			return conn;
		}
		catch (SQLException e)
		{
			this.output.write(e.getMessage());
			return null;
		}
	}

	private void executeSchemaChanges()
	{
		for (ISchemaChanges changes : schemaUpdaters)
		{
			int revision = revisionRepository.getRevision(changes.getTableName());
			HashMap<Integer, List<String>> queries = changes.getSchemaUpdateQueries();
			for (Integer rev : queries.keySet())
			{
				if (rev > revision)
				{
					revision = executeSchemaChanges(changes.getTableName(), revision, rev, queries.get(rev));

					// Update failed, abort now
					if (revision < rev)
						break;
				}
			}
			revisionRepository.setRevision(changes.getTableName(), revision);
		}
	}

	private int executeSchemaChanges(String tableName, int oldRevision, int newRevision, List<String> queries)
	{
		String sqlQuery = null;
		Connection transaction = beginTransaction();
		try
		{
			output.write(String.format("Updating table %s from revision %d to revision %d", tableName, oldRevision, newRevision));
			for (String sql : queries)
			{
				sqlQuery = sql;
				PreparedStatement query = transaction.prepareStatement(sql);
				query.execute();
			}
			commitTransaction(transaction);
			return newRevision;
		}
		catch (SQLException e)
		{
			output.logException(e);
			output.writeColoured("Failed executing query:\n%s", sqlQuery);
			output.writeColoured("&cRolling back transaction..");
			try
			{
				transaction.rollback();
			}
			catch (SQLException e1)
			{
				output.writeColoured("&4Failed rolling back transaction!");
				output.logException(e1);
			}
		}
		return oldRevision;
	}

	private Connection conn;
}
