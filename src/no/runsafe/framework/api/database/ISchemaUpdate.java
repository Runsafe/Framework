package no.runsafe.framework.api.database;

import java.util.HashMap;
import java.util.List;

public interface ISchemaUpdate
{
	// ToDo: Implement this to be used by the SchemaUpdater and clean all plug-ins.

	void addQueries(Integer revision, String... queries);
	HashMap<Integer, List<String>> getQueries();
}
