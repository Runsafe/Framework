package no.runsafe.framework.database;

import java.util.HashMap;
import java.util.List;

public interface ISchemaChanges {
	public String getTableName();

	HashMap<Integer, List<String>> getSchemaUpdateQueries();
}
