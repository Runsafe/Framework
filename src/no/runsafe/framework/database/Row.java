package no.runsafe.framework.database;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Map;

public class Row extends DataConverter
{
	public Row(Map<String, Object> data)
	{
		raw = data;
	}

	public String String(String column)
	{
		return super.String(get(column));
	}

	public Integer Integer(String column)
	{
		return super.Integer(get(column));
	}

	public Long Long(String column)
	{
		return super.Long(get(column));
	}

	public Double Double(String column)
	{
		return super.Double(get(column));
	}

	public Float Float(String column)
	{
		return super.Float(get(column));
	}

	public DateTime DateTime(String column)
	{
		return super.DateTime(get(column));
	}

	private Object get(String column)
	{
		if (!raw.containsKey(column))
			return null;
		return raw.get(column);
	}

	private final Map<String, Object> raw;
}
