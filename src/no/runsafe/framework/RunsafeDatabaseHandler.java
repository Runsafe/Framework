package no.runsafe.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

public class RunsafeDatabaseHandler implements IDatabase 
{
	private String databaseURL;
	private String databaseUsername;
	private String databasePassword;

	private IOutput output;

	public RunsafeDatabaseHandler(IConfiguration config, IOutput output)
	{
		this.databaseURL = config.getConfigValueAsString("database.url");
		this.databaseUsername = config.getConfigValueAsString("database.username");
		this.databasePassword = config.getConfigValueAsString("database.password");
		this.output = output;
	}
	
	@Override
	public Connection beginTransaction()
	{
		try 
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			return conn;
		} 
		catch (SQLException e) 
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);
			return null;
		}
	}
	
	@Override
	public void commitTransaction(Connection conn)
	{
		try
		{
			conn.commit();
			conn.close();
		}
		catch(SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		}
	}
	
	@Override
	public void rollbackTransaction(Connection conn)
	{
		try
		{
			conn.rollback();
			conn.close();
		}
		catch(SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		}
	}
	
	@Override
	public PreparedStatement prepare(String sql) 
	{
		try
		{
			Connection conn = getConnection();
			return conn.prepareStatement(sql);
		}
		catch(SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);
			return null;
		}
	}
	
	protected Connection getConnection()
	{
		try
		{
			return DriverManager.getConnection(this.databaseURL, this.databaseUsername, this.databasePassword);
		}
		catch (SQLException e)
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);
		}
		return null;
	}
}
