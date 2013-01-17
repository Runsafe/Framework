package no.runsafe.framework.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface IDatabase
{
	PreparedStatement prepare(String sql);

	void rollbackTransaction(Connection conn);

	void commitTransaction(Connection conn);

	Connection beginTransaction();
}