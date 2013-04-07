package no.runsafe.framework.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

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

	List<Map<String, Object>> Query(String query, Object... params);

	boolean Execute(String query, Object... params);

	int Update(String query, Object... params);
}