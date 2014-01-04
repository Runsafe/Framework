package no.runsafe.framework.api.database;

import java.util.*;

public class SchemaUpdate implements ISchemaUpdate
{
	@Override
	public void addQueries(String... queries)
	{
		this.queries.put(currentRevision, Arrays.asList(queries));
		currentRevision++;
	}

	@Override
	public HashMap<Integer, List<String>> getQueries()
	{
		return queries;
	}

	private int currentRevision = 1;
	private final HashMap<Integer, List<String>> queries = new LinkedHashMap<Integer, List<String>>(0);
}
