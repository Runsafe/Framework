package no.runsafe.framework.internal.database;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;

final class DataConverter
{
	private DataConverter()
	{
	}

	@Nullable
	static String String(Object value)
	{
		if (value == null)
			return null;

		return value.toString();
	}

	@Nullable
	static Integer Integer(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof BigDecimal)
			return ((Number) value).intValue();

		if (value instanceof String)
			return Integer.valueOf((String) value);

		if (value instanceof Integer)
			return (Integer) value;

		if (value instanceof Long)
			return ((Long) value).intValue();

		if (value instanceof BigInteger)
			return ((Number) value).intValue();

		return null;
	}

	@Nullable
	static Long Long(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof BigDecimal)
			return ((Number) value).longValue();

		if (value instanceof String)
			return Long.valueOf((String) value);

		if (value instanceof Long)
			return (Long) value;

		if (value instanceof Integer)
			return Long.valueOf((Integer) value);

		if (value instanceof BigInteger)
			return ((Number) value).longValue();

		return null;
	}

	@Nullable
	static Double Double(Object value)
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
			return ((Number) value).doubleValue();

		return null;
	}

	@Nullable
	static Float Float(Object value)
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
			return ((Number) value).floatValue();

		return null;
	}

	@Nullable
	static DateTime DateTime(Object value)
	{
		if (value == null)
			return null;
		return new DateTime(value);
	}

	@SuppressWarnings({"MethodWithTooManyParameters", "ConstantConditions"})
	@Nullable
	static RunsafeLocation Location(Object world, Object x, Object y, Object z, Object yaw, Object pitch)
	{
		RunsafeWorld targetWorld = World(world);
		if (targetWorld == null)
			return null;

		if (x == null || y == null || z == null)
			return new RunsafeLocation(targetWorld, 0.0D, 0.0D, 0.0D);

		if (yaw != null && pitch != null)
			return new RunsafeLocation(targetWorld, Double(x), Double(y), Double(z), Float(yaw), Float(pitch));

		return new RunsafeLocation(targetWorld, Double(x), Double(y), Double(z));
	}

	@Nullable
	static RunsafeWorld World(Object value)
	{
		if (value == null)
			return null;
		return RunsafeServer.Instance.getWorld(value.toString());
	}

	@Nullable
	static RunsafePlayer Player(Object value)
	{
		return value == null ? null : RunsafeServer.Instance.getOfflinePlayerExact(value.toString());
	}
}
