package no.runsafe.framework;

import java.sql.ResultSet;

public interface Converter<T> 
{
	public T convert(ResultSet set);
}
