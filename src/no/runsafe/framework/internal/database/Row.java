package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.util.Map;

public final class Row extends DataConverter implements IRow
{
	public Row(Map<String, Object> data)
	{
		raw = data;
	}

	@Override
	public String String(String column)
	{
		return super.String(get(column));
	}

	@Override
	public Integer Integer(String column)
	{
		return super.Integer(get(column));
	}

	@Override
	public Long Long(String column)
	{
		return super.Long(get(column));
	}

	@Override
	public Double Double(String column)
	{
		return super.Double(get(column));
	}

	@Override
	public Float Float(String column)
	{
		return super.Float(get(column));
	}

	@Override
	public DateTime DateTime(String column)
	{
		return super.DateTime(get(column));
	}

	@Override
	public RunsafeLocation Location()
	{
		return Location("world", "x", "y", "z", "yaw", "pitch");
	}

	@Override
	public RunsafeLocation Location(String world, String x, String y, String z)
	{
		return Location(world, x, y, z, "yaw", "pitch");
	}

	@Override
	public RunsafeLocation Location(String world, String x, String y, String z, String yaw, String pitch)
	{
		return super.Location(get(world), get(x), get(y), get(z), get(yaw), get(pitch));
	}

	@Override
	public RunsafeWorld World(String column)
	{
		return super.World(get(column));
	}

	@Override
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
