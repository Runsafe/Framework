package no.runsafe.framework.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Database access wrapper
 */
public interface IDatabase
{
	/**
	 * Prepares an SQL statement for execution
	 *
	 * @param sql The SQL statement to be prepared for execution
	 * @return The prepared SQL statement
	 */
	PreparedStatement prepare(String sql);

	/**
	 * Rolls back a failed transaction
	 *
	 * @param conn The transaction connection
	 */
	void rollbackTransaction(Connection conn);

	/**
	 * Commits a successful transaction
	 *
	 * @param conn The transaction connection
	 */
	void commitTransaction(Connection conn);

	/**
	 * Starts a new transaction
	 *
	 * @return The transaction connection
	 */
	Connection beginTransaction();
}