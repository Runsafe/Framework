package no.runsafe.framework.api.database;

public interface ITransaction extends IQueryExecutor
{
	void Commit();
	void Rollback();
}
