package no.runsafe.framework.api.database;

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
	ISchemaUpdate getSchemaUpdateQueries();
}
