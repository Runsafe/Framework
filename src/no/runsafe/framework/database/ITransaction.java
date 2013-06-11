package no.runsafe.framework.database;

public interface ITransaction extends IQueryExecutor
{
	void Commit();
	void Rollback();
}
