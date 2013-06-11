package no.runsafe.framework.api.database;

import java.util.List;

public interface IQueryExecutor
{
	ISet Query(String query, Object... params);
	IRow QueryRow(String query, Object... params);
	List<IValue> QueryColumn(String query, Object... params);
	boolean Execute(String query, Object... params);
	int Update(String query, Object... params);
}
