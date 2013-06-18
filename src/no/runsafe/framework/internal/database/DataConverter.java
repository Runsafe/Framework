package no.runsafe.framework.internal.database;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.BigInteger;

abstract class DataConverter
{
	String String(Object value)
	{
		if (value == null)
			return null;

		return value.toString();
	}

	Integer Integer(Object value)
	{
		if (value == null)
			return null;

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

	Long Long(Object value)
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

	Double Double(Object value)
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

	Float Float(Object value)
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

	DateTime DateTime(Object value)
	{
		if (value == null)
			return null;
		return new DateTime(value);
	}

	RunsafeLocation Location(Object world, Object x, Object y, Object z, Object yaw, Object pitch)
	{
		RunsafeWorld targetWorld = World(world);
		if (targetWorld == null)
			return null;

		if (yaw != null && pitch != null)
			return new RunsafeLocation(targetWorld, Double(x), Double(y), Double(z), Float(yaw), Float(pitch));

		return new RunsafeLocation(targetWorld, Double(x), Double(y), Double(z));
	}

	RunsafeWorld World(Object value)
	{
		if (value == null)
			return null;
		return RunsafeServer.Instance.getWorld(value.toString());
	}

	RunsafePlayer Player(Object value)
	{
		return value == null ? null : RunsafeServer.Instance.getOfflinePlayerExact(value.toString());
	}
}
