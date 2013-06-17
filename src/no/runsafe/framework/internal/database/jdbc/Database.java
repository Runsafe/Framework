package no.runsafe.framework.internal.database.jdbc;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.ITransaction;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Framework for handling database access
 */
public final class Database extends QueryExecutor implements IDatabase
{
	public Database(IOutput output)
	{
		super(output);
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
				output.logFatal("Unable to create runsafe/db.yml configuration file - Check permissions!");
			}
			output.logFatal("Created new default runsafe/db.yml - You need to change this now!");
			System.exit(1);
		}
		catch (IOException e)
		{
			output.logException(e);
			output.logFatal("Unable to read runsafe/db.yml - You need to fix this!");
		}
		catch (InvalidConfigurationException e)
		{
			output.logException(e);
			output.logFatal("Invalid configuration file runsafe/db.yml - You need to fix this!");
		}
		this.databaseURL = config.getString("database.url");
		this.databaseUsername = config.getString("database.username");
		this.databasePassword = config.getString("database.password");

		try
		{
			if (QueryRow("SELECT VERSION()") == null)
				throw new Exception("No database!"); // In case query returned null without an exception
		}
		catch (Exception e)
		{
			output.logFatal("Unable to connect to MySQL - Check configuration file runsafe/db.yml!");
		}
	}

	@Override
	public ITransaction Isolate()
	{
		try
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			return new Transaction(output, conn);
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage(), Level.SEVERE);
			return null;
		}
	}

	@Override
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
	protected Connection conn;
}
