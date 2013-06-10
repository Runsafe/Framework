package no.runsafe.framework.database;

import org.joda.time.DateTime;

public class Value extends DataConverter
{
	public Value(Object data)
	{
		raw = data;
	}

	public String String()
	{
		return super.String(raw);
	}

	public Integer Integer()
	{
		return super.Integer(raw);
	}

	public Long Long()
	{
		return super.Long(raw);
	}

	public Double Double()
	{
		return super.Double(raw);
	}

	public Float Float()
	{
		return super.Float(raw);
	}

	public DateTime DateTime()
	{
		return super.DateTime(raw);
	}

	private final Object raw;
}
