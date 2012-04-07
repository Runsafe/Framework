package no.runsafe.framework.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface IDatabase 
{
	public abstract PreparedStatement prepare(String sql);

	public abstract void rollbackTransaction(Connection conn);

	public abstract void commitTransaction(Connection conn);

	public abstract Connection beginTransaction();
}