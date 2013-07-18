package no.runsafe.framework.internal.database.jdbc;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.ITransaction;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.io.File;
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
	public Database(IOutput output, RunsafePlugin plugin)
	{
		super(output);
		YamlConfiguration config = new YamlConfiguration();
		boolean local = false;
		try
		{
			File localConfig = new File(String.format("plugins/%s/db.yml", plugin.getName()));
			if (localConfig.exists())
			{
				local = true;
				config.load(localConfig.getPath());
			}
			else
				config.load("runsafe/db.yml");
		}
		catch (FileNotFoundException e)
		{
			if (local) // This should not happen..
			{
				output.logException(e);
				output.logFatal("Error loading local config..");
			}
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
		}
		catch (IOException e)
		{
			if (local)
			{
				output.logException(e);
				output.logFatal("Unable to read plugin database config!");
			}
			output.logException(e);
			output.logFatal("Unable to read runsafe/db.yml - You need to fix this!");
		}
		catch (InvalidConfigurationException e)
		{
			if (local)
			{
				output.logException(e);
				output.logFatal("Plugin database config is invalid!");
			}
			output.logException(e);
			output.logFatal("Invalid configuration file runsafe/db.yml - You need to fix this!");
		}
		databaseURL = config.getString("database.url");
		databaseUsername = config.getString("database.username");
		databasePassword = config.getString("database.password");

		try
		{
			if (QueryRow("SELECT VERSION()") == null)
				throw new Exception("No database!"); // In case query returned null without an exception
		}
		catch (Exception e)
		{
			if (local)
			{
				output.logFatal("Unable to connect to plugins database!");
			}
			output.logFatal("Unable to connect to MySQL - Check configuration file runsafe/db.yml!");
		}
	}

	@Override
	@Nullable
	public ITransaction Isolate()
	{
		try
		{
			Connection connection = getConnection();
			connection.setAutoCommit(false);
			return new Transaction(output, connection);
		}
		catch (SQLException e)
		{
			output.outputToConsole(e.getMessage(), Level.SEVERE);
			return null;
		}
	}

	@Nullable
	@Override
	protected Connection getConnection()
	{
		try
		{
			if (conn == null || accessTime == null || accessTime.isBefore(DateTime.now().minusMinutes(5)) || conn.isClosed())
			{
				if (conn != null)
				{
					try
					{
						conn.close();
					}
					catch (Exception e)
					{
						// Just ignore.
					}
				}
				accessTime = DateTime.now();

				conn = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
				output.fine(String.format("Opening connection to %s by %s", databaseURL, databaseUsername));
			}
			if (conn != null)
				return conn;
			output.fine("Connection is null");
		}
		catch (SQLException e)
		{
			output.write(e.getMessage());
		}
		return null;
	}

	private final String databaseURL;
	private final String databaseUsername;
	private final String databasePassword;
	private Connection conn;
	private DateTime accessTime;
}
