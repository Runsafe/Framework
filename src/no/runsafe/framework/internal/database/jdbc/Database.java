package no.runsafe.framework.internal.database.jdbc;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.log.IDebug;
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
	public Database(IDebug output, RunsafePlugin plugin)
	{
		super(output);
		YamlConfiguration config = new YamlConfiguration();
		File location = configure(config, plugin);

		databaseURL = config.getString("database.url");
		databaseUsername = config.getString("database.username");
		databasePassword = config.getString("database.password");

		try
		{
			if (QueryRow("SELECT VERSION()") == null)
				output.logFatal("Unable to connect to MySQL - Verify %s!", location);
		}
		catch (Exception e)
		{
			output.logException(e);
			output.logFatal("An error occurred while testing the MySQL connection - Verify %s!", location);
		}
	}

	@Override
	@Nullable
	public ITransaction Isolate()
	{
		try
		{
			Connection connection = getConnection();
			if (connection == null)
				return null;
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
			if (conn == null || connectionIsStale() || conn.isClosed())
				open();

			if (conn != null)
				return conn;

			output.logError("Unable to get database connection!");
		}
		catch (SQLException e)
		{
			output.logException(e);
		}
		return null;
	}

	private boolean connectionIsStale()
	{
		return accessTime == null || accessTime.isBefore(DateTime.now().minusMinutes(5));
	}

	private File configure(YamlConfiguration config, RunsafePlugin plugin)
	{
		boolean local = false;
		File configFile = new File(plugin.getDataFolder(), "db.yml");
		if (configFile.exists())
			local = true;
		else
			configFile = new File("runsafe", "db.yml");

		try
		{
			config.load(configFile.getPath());
		}
		catch (FileNotFoundException e)
		{
			if (local) // This should not happen..
			{
				output.logException(e);
				output.logFatal("Error loading local debugConfig..");
			}
			config.createSection("database");
			config.set("database.url", "jdbc:mysql://localhost:3306/minecraft");
			config.set("database.username", "minecraftuser");
			config.set("database.password", "p4ssw0rd");
			try
			{
				config.save(configFile.getPath());
			}
			catch (IOException e1)
			{
				output.logException(e1);
				output.logFatal("Unable to create %s configuration file - Check permissions!", configFile);
			}
			output.logFatal("Created new default %s - You need to change this now!", configFile);
		}
		catch (IOException e)
		{
			output.logException(e);
			output.logFatal("Unable to read %s - You need to fix this!", configFile);
		}
		catch (InvalidConfigurationException e)
		{
			output.logException(e);
			output.logFatal("Invalid configuration file %s - You need to fix this!", configFile);
		}
		return configFile;
	}

	private void open() throws SQLException
	{
		close();
		accessTime = DateTime.now();
		conn = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
		output.debugFine(String.format("Opening connection to %s by %s", databaseURL, databaseUsername));
	}

	private void close()
	{
		//noinspection OverlyBroadCatchBlock
		try
		{
			if (conn != null)
				conn.close();
		}
		catch (Exception ignored)
		{
			// Just ignore.
		}
	}

	private final String databaseURL;
	private final String databaseUsername;
	private final String databasePassword;
	private Connection conn;
	private DateTime accessTime;
}
