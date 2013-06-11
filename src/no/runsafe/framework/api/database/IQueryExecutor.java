package no.runsafe.framework.api.database;

import no.runsafe.framework.internal.database.Row;
import no.runsafe.framework.internal.database.Set;
import no.runsafe.framework.internal.database.Value;

import java.util.List;

public interface IQueryExecutor
{
	Set Query(String query, Object... params);
	Row QueryRow(String query, Object... params);
	List<Value> QueryColumn(String query, Object... params);
	boolean Execute(String query, Object... params);
	int Update(String query, Object... params);
}
