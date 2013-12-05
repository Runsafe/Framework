package no.runsafe.framework.internal.database.jdbc;

import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.database.ITransaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;

public final class Transaction extends QueryExecutor implements ITransaction
{
	Transaction(IDebug output, Connection conn)
	{
		super(output);
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
			output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
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
			output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
		}
	}

	@Override
	protected Connection getConnection()
	{
		return conn;
	}

	private final Connection conn;
}
