package no.runsafe.framework.api.database;

import java.util.*;

public class SchemaUpdate implements ISchemaUpdate
{
	@Override
	public void addQueries(Integer revision, String... queries)
	{
		this.queries.put(revision, Arrays.asList(queries));
	}

	@Override
	public HashMap<Integer, List<String>> getQueries()
	{
		return queries;
	}

	private HashMap<Integer, List<String>> queries = new LinkedHashMap<Integer, List<String>>(0);
}
