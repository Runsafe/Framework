package me.Kruithne.RMPF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class RMPFDatabase {
	
	private String databaseURL;
	private String databaseUsername;
	private String databasePassword;
	
	private RMPFOutput pluginOutput;
	
	private Connection databaseConnection;

	public RMPFDatabase(String dbURL, String dbUsername, String dbPassword)
	{
		this.databaseURL = dbURL;
		this.databaseUsername = dbUsername;
		this.databasePassword = dbPassword;
	}
	
	public RMPFDatabase(String dbURL, String dbUsername, String dbPassword, RMPFOutput output)
	{
		this.databaseURL = dbURL;
		this.databaseUsername = dbUsername;
		this.databasePassword = dbPassword;
		
		this.pluginOutput = output;
	}
	
	private void establishConnection()
	{
		try
		{
			this.databaseConnection = DriverManager.getConnection(this.databaseURL, this.databaseUsername, this.databasePassword);
		}
		catch (SQLException e)
		{
			this.output(e.getMessage(), Level.SEVERE);
		}
	}
	
	public void closeConnection()
	{
		try
		{
			this.databaseConnection.close();
		}
		catch (SQLException e)
		{
			this.output(e.getMessage(), Level.SEVERE);
		}
	}
	
	public ResultSet getQuery(String query)
	{
		this.checkConnection();

		ResultSet result = null;

		try
		{
			Statement newStatement = databaseConnection.createStatement();
			result = newStatement.executeQuery(query);
		}
		catch (SQLException e)
		{
			this.output(e.getMessage(), Level.SEVERE);
		}

		return result;
	}
    
    public boolean query(String query)
    {
    	this.checkConnection();

    	try
    	{
    		Statement statement = this.databaseConnection.createStatement();

    		statement.executeUpdate(query);
    		return true;

    	}
    	catch (SQLException e)
    	{
    		this.output(e.getMessage(), Level.SEVERE);
    	}
    	
    	return false;
    }
    
    private void checkConnection()
    {
    	try
    	{
    		if (this.databaseConnection != null)
    		{
	    		if (this.databaseConnection.isClosed())
	    		{
	    			this.establishConnection();
	    		}
    		}
    		else
    		{
    			this.establishConnection();
    		}
    	}
    	catch (SQLException e)
    	{
    		this.output(e.getMessage(), Level.SEVERE);
    	}
    }
	
	private void output(String message, Level level)
	{
		if (this.pluginOutput != null)
		{
			this.pluginOutput.outputToConsole(message, level);
		}
	}
	
}
