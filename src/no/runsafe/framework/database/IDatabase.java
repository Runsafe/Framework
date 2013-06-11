package no.runsafe.framework.database;

import java.sql.Connection;

/**
 * Database access wrapper
 */
public interface IDatabase extends IQueryExecutor
{

	/**
	 * Rolls back a failed transaction
	 *
	 * @param conn The transaction connection
	 */
	@Deprecated
	void rollbackTransaction(Connection conn);

	/**
	 * Commits a successful transaction
	 *
	 * @param conn The transaction connection
	 */
	@Deprecated
	void commitTransaction(Connection conn);

	/**
	 * Starts a new transaction
	 *
	 * @return The transaction connection
	 */
	@Deprecated
	Connection beginTransaction();

	RunsafeTransaction Isolate();
}
