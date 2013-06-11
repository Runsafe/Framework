package no.runsafe.framework.database;

import java.sql.Connection;

public interface ITransaction extends IQueryExecutor
{
	void Commit();

	void Rollback();
}
