package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.internal.brane.Multiverse;

import javax.annotation.Nullable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

		if (value instanceof Number)
			return ((Number) value).intValue();

		if (value instanceof String)
			return Integer.valueOf((String) value);

		throw new DataConversionException(value, Integer.class);
	}

	@Nullable
	static Long Long(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof Number)
			return ((Number) value).longValue();

		if (value instanceof String)
			return Long.valueOf((String) value);

		throw new DataConversionException(value, Long.class);
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

		if (value instanceof Number)
			return ((Number) value).doubleValue();

		throw new DataConversionException(value, Double.class);
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

		if (value instanceof Number)
			return ((Number) value).floatValue();

		throw new DataConversionException(value, Float.class);
	}

	@Nullable
	static Instant Instant(Object value)
	{
		if (value == null)
			return null;

		// Example of date format needed: 2024-12-19T15:35:25
		// Example of date format given: 2024-12-19 15:35:25

		// Input value was recorded in the server's time zone, convert it before turning it into an Instant
		return ZonedDateTime.of(
			LocalDateTime.parse(value.toString().replace(" ", "T")),
			ZoneId.systemDefault()
		).toInstant();
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

	public static Boolean Boolean(Object value)
	{
		if (value == null)
			return null;

		if (value instanceof Boolean)
			return (Boolean)value;

		if (value instanceof Number)
			return ((Number)value).intValue() != 0;

		throw new DataConversionException(value, Boolean.class);
	}
}