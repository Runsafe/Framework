package no.runsafe.framework.database;

import java.util.HashMap;
import java.util.List;

/**
 * Interface for automated database upgrades
 */
public interface ISchemaChanges
{
	/**
	 * @return The name of the database table this instance handles updates of
	 */
	String getTableName();

	/**
	 * The keys are incrementing revision numbers, the values are lists of SQL statements to be executed for each revision.
	 *
	 * @return The SQL statements for upgrading the database table
	 */
	HashMap<Integer, List<String>> getSchemaUpdateQueries();
}
