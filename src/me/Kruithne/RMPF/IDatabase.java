package me.Kruithne.RMPF;

import java.sql.ResultSet;

public interface IDatabase {

	public abstract void closeConnection();

	public abstract ResultSet getQuery(String query);

	public abstract boolean query(String query);

}