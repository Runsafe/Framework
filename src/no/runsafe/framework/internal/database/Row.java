package no.runsafe.framework.internal.database;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.util.Map;

public final class Row extends DataConverter
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

	public RunsafeLocation Location()
	{
		return Location("world", "x", "y", "z", "yaw", "pitch");
	}

	public RunsafeLocation Location(String world, String x, String y, String z)
	{
		return Location(world, x, y, z, "yaw", "pitch");
	}

	public RunsafeLocation Location(String world, String x, String y, String z, String yaw, String pitch)
	{
		return super.Location(get(world), get(x), get(y), get(z), get(yaw), get(pitch));
	}

	public RunsafeWorld World(String column)
	{
		return super.World(get(column));
	}

	public RunsafePlayer Player(String column)
	{
		return super.Player(get(column));
	}

	private Object get(String column)
	{
		if (!raw.containsKey(column))
			return null;
		return raw.get(column);
	}

	private final Map<String, Object> raw;
}
