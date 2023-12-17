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
	public Iterable<Integer> getRevisions()
	{
		return queries.keySet();
	}

	@Override
	public Iterable<String> getStatements(int revision)
	{
		return queries.get(revision);
	}

	private int currentRevision = 1;
	private final HashMap<Integer, List<String>> queries = new LinkedHashMap<Integer, List<String>>(0);
}
