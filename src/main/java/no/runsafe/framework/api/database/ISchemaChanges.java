package no.runsafe.framework.api.database;

import javax.annotation.Nonnull;

/**
 * Interface for automated database upgrades
 */
public interface ISchemaChanges
{
	/**
	 * @return The name of the database table this instance handles updates of
	 */
	@Nonnull
	String getTableName();

	/**
	 * The keys are incrementing revision numbers, the values are lists of SQL statements to be executed for each revision.
	 *
	 * @return The SQL statements for upgrading the database table
	 */
	@Nonnull
	ISchemaUpdate getSchemaUpdateQueries();

	void connect(IDatabase database);
}
