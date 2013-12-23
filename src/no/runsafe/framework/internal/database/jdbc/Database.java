package no.runsafe.framework.internal.database.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.ITransaction;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.configuration.FrameworkConfiguration;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Framework for handling database access
 */
public final class Database extends QueryExecutor implements IDatabase
{
	public Database(IDebug output, IConsole console, RunsafePlugin plugin, FrameworkConfiguration config)
	{
		super(console, output);

		databaseURL = config.getConfigValueAsString("database.url");
		databaseUsername = config.getConfigValueAsString("database.username");
		databasePassword = config.getConfigValueAsString("database.password");

		try
		{
			if (QueryRow("SELECT VERSION()") == null)
				console.logFatal("Unable to connect to MySQL - Verify framework configuration!");
		}
		catch (Exception e)
		{
			console.logException(e);
			console.logFatal("An error occurred while testing the MySQL connection - Verify framework configuration!");
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
			return new Transaction(output, debugger, connection);
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
			if (source == null)
				open();
			return source.getConnection();
		}
		catch (SQLException e)
		{
			output.logException(e);
		}
		return null;
	}

	public void open()
	{
		close();
		accessTime = DateTime.now();
		MysqlDataSource mysqlDataSource = new MysqlDataSource();
		mysqlDataSource.setUrl(databaseURL);
		mysqlDataSource.setUser(databaseUsername);
		mysqlDataSource.setPassword(databasePassword);
		source = mysqlDataSource;
		debugger.debugFine(String.format("Opening connection to %s by %s", databaseURL, databaseUsername));
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
	private DataSource source;
	private Connection conn;
	private DateTime accessTime;
}
