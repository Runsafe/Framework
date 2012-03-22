package me.Kruithne.RMPF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class RMPFDatabase implements IDatabase {
	
	private String databaseURL;
	private String databaseUsername;
	private String databasePassword;
	
	private IOutput pluginOutput;
	
	private Connection databaseConnection;

	public RMPFDatabase(IConfiguration config, IOutput output)
	{
		this.pluginOutput = output;
		this.databaseURL = config.getConfigValueAsString("database.url");
		this.databaseUsername = config.getConfigValueAsString("database.username");
		this.databasePassword = config.getConfigValueAsString("database.password");
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
	
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IDatabase#closeConnection()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IDatabase#getQuery(java.lang.String)
	 */
	@Override
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
    
    /* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IDatabase#query(java.lang.String)
	 */
    @Override
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
