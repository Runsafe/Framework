package no.runsafe.framework.database;

import no.runsafe.framework.server.RunsafeServer;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class DataConverter
{
	public String String(Object value)
	{
		if (value == null)
			return null;

		return value.toString();
	}

	public Integer Integer(Object value)
	{
		if (value == null)
			return null;

		RunsafeServer.Instance.getLogger().info(value.getClass().getName());

		if (value instanceof BigDecimal)
			return ((BigDecimal) value).intValue();

		if (value instanceof String)
			return Integer.valueOf((String) value);

		if (value instanceof Integer)
			return (Integer) value;

		if (value instanceof Long)
			return ((Long) value).intValue();

		if (value instanceof BigInteger)
			return ((BigInteger) value).intValue();

		return null;
	}

	public Long Long(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof BigDecimal)
			return ((BigDecimal) value).longValue();

		if (value instanceof String)
			return Long.valueOf((String) value);

		if (value instanceof Long)
			return (Long) value;

		if (value instanceof Integer)
			return Long.valueOf((Integer) value);

		if (value instanceof BigInteger)
			return ((BigInteger) value).longValue();

		return null;
	}

	public Double Double(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof Float)
			return ((Float) value).doubleValue();

		if (value instanceof Double)
			return (Double) value;

		if (value instanceof String)
			return Double.valueOf((String) value);

		if (value instanceof Long)
			return ((Long) value).doubleValue();

		if (value instanceof Integer)
			return ((Integer) value).doubleValue();

		if (value instanceof BigInteger)
			return ((BigInteger) value).doubleValue();

		return null;
	}

	public Float Float(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof Float)
			return (Float) value;

		if (value instanceof Double)
			return ((Double) value).floatValue();

		if (value instanceof String)
			return Float.valueOf((String) value);

		if (value instanceof Long)
			return ((Long) value).floatValue();

		if (value instanceof Integer)
			return ((Integer) value).floatValue();

		if (value instanceof BigInteger)
			return ((BigInteger) value).floatValue();

		return null;
	}

	public DateTime DateTime(Object value)
	{
		if (value == null)
			return null;
		return new DateTime(value);
	}
}
