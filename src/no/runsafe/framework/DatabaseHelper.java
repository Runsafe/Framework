package no.runsafe.framework;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;

public class DatabaseHelper 
{
	public DatabaseHelper(IOutput output)
	{
		this.output = output;
	}
	
	public <T extends RunsafeEntity> Collection<T> getResults(Statement statement, Converter<T> converter)
	{
		ArrayList<T> result = new ArrayList<T>();
		
		try
		{
			ResultSet set = statement.getResultSet();
			while(set.next())
			{
				result.add(converter.convert(set));
			}
		} 
		catch (SQLException e) 
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		} 
		catch (IllegalArgumentException e) 
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		} 
		
		return result;
	}
	
	public <T extends RunsafeEntity> Collection<T> getResults(Statement statement, Factory<T> factory)
	{
		ArrayList<T> result = new ArrayList<T>();
		
		try 
		{
			ResultSet set = statement.getResultSet();
			while(set.next())
			{
				T object = factory.create();
				for(Field field : object.getClass().getFields())
				{
					EntityField ef = field.getAnnotation(EntityField.class);
					if(ef != null)
						field.set(object, set.getObject(ef.name()));
				}
				result.add(object);
			}
		} 
		catch (SQLException e) 
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		} 
		catch (IllegalArgumentException e) 
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		} 
		catch (IllegalAccessException e) 
		{
			this.output.outputToConsole(e.getMessage() + e.getStackTrace(), Level.SEVERE);			
		}
		
		return result;
	}
	
	private IOutput output;
}
