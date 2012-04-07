package no.runsafe.framework.database;

import java.sql.ResultSet;

public interface Converter<T> 
{
	public T convert(ResultSet set);
}
