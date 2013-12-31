package no.runsafe.framework.internal.database.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.ITransaction;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.configuration.FrameworkConfiguration;

import javax.annotation.Nullable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Framework for handling database access
 */
public final class Database extends QueryExecutor implements IDatabase
{
	public Database(IDebug output, IConsole console, FrameworkConfiguration config)
	{
		super(console, output);
		String url = config.getConfigValueAsString("database.url");
		String user = config.getConfigValueAsString("database.username");
		String password = config.getConfigValueAsString("database.password");

		source = new MysqlConnectionPoolDataSource();
		source.setUrl(url);
		source.setUser(user);
		source.setPassword(password);
		source.setAutoReconnectForConnectionPools(true);
		Connection local = null;
		try
		{
			local = source.getConnection();
		}
		catch (SQLException e)
		{
			console.logException(e);
			console.logFatal("Unable to connect to SQL server, aborting startup!");
		}
		connection = local;

		transactionSource = new MysqlDataSource();
		transactionSource.setUrl(url);
		transactionSource.setUser(user);
		transactionSource.setPassword(password);
		transactionSource.setAutoReconnect(true);

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
			Connection transaction = transactionSource.getConnection();
			if (transaction == null)
				return null;
			transaction.setAutoCommit(false);
			return new Transaction(output, debugger, transaction);
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
		return connection;
	}

	private final MysqlConnectionPoolDataSource source;
	private final Connection connection;
	private final MysqlDataSource transactionSource;
}
