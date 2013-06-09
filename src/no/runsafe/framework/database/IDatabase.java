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

	Map<String, Object> QueryRow(String query, Object... params);

	List<Object> QueryColumn(String query, Object... params);
}