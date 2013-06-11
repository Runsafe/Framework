package no.runsafe.framework.database;

import no.runsafe.framework.output.IOutput;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;

public class RunsafeTransaction extends RunsafeDatabaseHandler implements ITransaction
{
	RunsafeTransaction(IOutput output, Connection conn)
	{
		super(output, false);
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
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
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
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
		}
	}
}
