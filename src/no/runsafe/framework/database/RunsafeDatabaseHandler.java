package no.runsafe.framework.database;

import no.runsafe.framework.output.ConsoleColors;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.RunsafeServer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.joda.time.DateTime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

/**
 * Framework for handling database access
 */
public class RunsafeDatabaseHandler implements IDatabase
{
	public RunsafeDatabaseHandler(IOutput output)
	{
		this(output, true);
	}

	protected RunsafeDatabaseHandler(IOutput output, boolean configure)
	{
		this.output = output;
		if (!configure)
		{
			databasePassword = null;
			databaseUsername = null;
			databaseURL = null;
			return;
		}
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
			System.exit(1);
		}
		catch (IOException e)
		{
			output.logException(e);
			output.write("\n" +
				"\n" +
				ConsoleColors.RED +
				"=====================================================\n" +
				"Unable to read runsafe/db.yml - you need to fix this!\n" +
				"=====================================================" +
				ConsoleColors.RESET
			);
			RunsafeServer.Instance.stop();
			System.exit(1);
		}
		catch (InvalidConfigurationException e)
		{
			output.logException(e);
			output.write("\n" +
				"\n" +
				ConsoleColors.RED +
				"=================================================================\n" +
				"Invalid configuration file runsafe/db.yml - you need to fix this!\n" +
				"=================================================================" +
				ConsoleColors.RESET
			);
			System.exit(1);
		}
		this.databaseURL = config.getString("database.url");
		this.databaseUsername = config.getString("database.username");
		this.databasePassword = config.getString("database.password");

		try
		{
			if (QueryRow("SELECT VERSION()") == null)
				throw new Exception("No database!");
		}
		catch (Exception e)
		{
			output.write("\n" +
				"\n" +
				ConsoleColors.RED +
				"====================================================================\n" +
				"Unable to connect to MySQL - Edit configuration file runsafe/db.yml!\n" +
				"====================================================================" +
				ConsoleColors.RESET
			);
			System.exit(1);
		}
	}

	@Override
	@Deprecated
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
	@Deprecated
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
	@Deprecated
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
	public RunsafeTransaction Isolate()
	{
		try
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			return new RunsafeTransaction(output, conn);
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage(), Level.SEVERE);
			return null;
		}
	}

	@Override
	public Set Query(String query, Object... params)
	{
		try
		{
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++)
				statement.setObject(i + 1, params[i]);
			return getSet(statement);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return null;
		}
	}

	@Override
	public Row QueryRow(String query, Object... params)
	{
		try
		{
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++)
				statement.setObject(i + 1, params[i]);
			Set set = getSet(statement);
			if (set == null || set.isEmpty())
				return null;
			return set.get(0);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return null;
		}
	}

	@Override
	public List<Value> QueryColumn(String query, Object... params)
	{
		try
		{
			PreparedStatement statement = prepare(query);
			setParams(statement, params);
			return getValues(statement);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return null;
		}
	}

	@Override
	public boolean Execute(String query, Object... params)
	{
		try
		{
			PreparedStatement statement = prepare(query);
			setParams(statement, params);
			output.finer("Running SQL: %s", statement);
			statement.execute();
			return true;
		}
		catch (SQLException e)
		{
			output.logException(e);
			return false;
		}
	}

	@Override
	public int Update(String query, Object... params)
	{
		try
		{
			PreparedStatement statement = prepare(query);
			setParams(statement, params);
			output.finer("Running SQL: %s", statement);
			return statement.executeUpdate();
		}
		catch (SQLException e)
		{
			output.logException(e);
			return -1;
		}
	}

	protected Set getSet(PreparedStatement statement) throws SQLException
	{
		output.finer("Running SQL: %s", statement);
		ResultSet result = statement.executeQuery();
		if (!result.first())
			return null;
		ResultSetMetaData meta = result.getMetaData();
		int cols = meta.getColumnCount();
		if (cols == 0)
			return null;
		ArrayList<Row> results = new ArrayList<Row>();
		while (!result.isAfterLast())
		{
			HashMap<String, Object> row = new HashMap<String, Object>();
			for (int i = 0; i < cols; ++i)
				row.put(meta.getColumnName(i + 1), result.getObject(i + 1));
			results.add(new Row(row));
			result.next();
		}
		return new Set(results);
	}

	protected ArrayList<Value> getValues(PreparedStatement statement) throws SQLException
	{
		output.finer("Running SQL: %s", statement);
		ResultSet result = statement.executeQuery();
		if (!result.first())
			return null;
		ResultSetMetaData meta = result.getMetaData();
		int cols = meta.getColumnCount();
		if (cols == 0)
			return null;
		ArrayList<Value> results = new ArrayList<Value>();
		while (!result.isAfterLast())
		{
			results.add(new Value(result.getObject(1)));
			result.next();
		}
		return results;
	}

	protected PreparedStatement prepare(String query) throws SQLException
	{
		Connection conn = getConnection();
		return conn.prepareStatement(query);
	}

	protected void setParams(PreparedStatement statement, Object... params) throws SQLException
	{
		for (int i = 0; i < params.length; i++)
		{
			if (params[i] instanceof DateTime)
				statement.setObject(i + 1, new Timestamp(((DateTime) params[i]).getMillis()));
			else
				statement.setObject(i + 1, params[i]);
		}
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

	private final String databaseURL;
	private final String databaseUsername;
	private final String databasePassword;
	protected final IOutput output;
	protected Connection conn;
}
