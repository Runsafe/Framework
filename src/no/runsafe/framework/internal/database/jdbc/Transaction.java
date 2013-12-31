package no.runsafe.framework.internal.database.jdbc;

import no.runsafe.framework.api.database.ITransaction;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Transaction extends QueryExecutor implements ITransaction
{
	Transaction(IConsole output, IDebug debug, Connection conn)
	{
		super(output, debug);
		this.conn = conn;
	}

	@Override
	public void Commit()
	{
		try
		{
			conn.commit();
			conn.close();
		}
		catch (SQLException e)
		{
			output.logException(e);
		}
	}

	@Override
	public void Rollback()
	{
		try
		{
			conn.rollback();
			conn.close();
		}
		catch (SQLException e)
		{
			output.logException(e);
		}
	}

	@Override
	void close(PreparedStatement statement)
	{
		if (statement == null)
			return;
		try
		{
			statement.close();
		}
		catch (SQLException e)
		{
			output.logException(e);
		}
	}

	@Override
	protected Connection getConnection()
	{
		return conn;
	}

	private final Connection conn;
}
