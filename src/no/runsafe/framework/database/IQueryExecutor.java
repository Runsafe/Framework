package no.runsafe.framework.database;

import java.util.List;

public interface IQueryExecutor
{
	Set Query(String query, Object... params);
	Row QueryRow(String query, Object... params);
	List<Value> QueryColumn(String query, Object... params);
	boolean Execute(String query, Object... params);
	int Update(String query, Object... params);
}
