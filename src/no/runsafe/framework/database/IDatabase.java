package no.runsafe.framework.database;

public interface IDatabase extends IQueryExecutor
{
	ITransaction Isolate();
}
