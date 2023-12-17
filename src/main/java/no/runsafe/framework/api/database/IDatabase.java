package no.runsafe.framework.api.database;

public interface IDatabase extends IQueryExecutor
{
	ITransaction isolate();
}
