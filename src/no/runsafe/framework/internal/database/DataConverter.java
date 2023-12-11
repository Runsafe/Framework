package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.internal.brane.Multiverse;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.UUID;

@SuppressWarnings("ChainOfInstanceofChecks")
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
	@Deprecated // Use Instant instead
	static DateTime DateTime(Object value)
	{
		if (value == null)
			return null;
		return new DateTime(value);
	}

	@Nullable
	static Instant Instant(Object value)
	{
		if (value == null)
			return null;
		return Instant.parse(value.toString());
	}

	@SuppressWarnings("MethodWithTooManyParameters")
	@Nullable
	static ILocation Location(Object world, Object x, Object y, Object z, Object yaw, Object pitch)
	{
		IWorld targetWorld = World(world);
		if (targetWorld == null)
			return null;

		if (x == null || y == null || z == null)
			return targetWorld.getLocation(0.0D, 0.0D, 0.0D);

		if (yaw != null && pitch != null)
			return targetWorld.getLocation(Double(x), Double(y), Double(z), Float(yaw), Float(pitch));

		return targetWorld.getLocation(Double(x), Double(y), Double(z));
	}

	@Nullable
	static IWorld World(Object value)
	{
		if (value == null)
			return null;
		return Multiverse.getInstance().getWorld(value.toString());
	}

	@Nullable
	static IPlayer Player(Object value)
	{
		if (value == null)
			return null;

		String valueString = value.toString();

		//Check if value is a UUID.
		if (valueString.length() == 36)
			return Player.Get().getExact(UUID.fromString(valueString));

		return Player.Get().getExact(valueString);
	}
}
