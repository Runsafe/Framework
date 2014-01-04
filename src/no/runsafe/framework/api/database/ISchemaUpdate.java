package no.runsafe.framework.api.database;

import java.util.HashMap;
import java.util.List;

public interface ISchemaUpdate
{
	void addQueries(String... queries);
	HashMap<Integer, List<String>> getQueries();
}
