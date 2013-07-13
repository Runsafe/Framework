package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.util.Map;

public final class Row extends DataConverter implements IRow
{
	public static final IRow Empty = new IRow()
	{
		@Override
		public String String(String column)
		{
			return null;
		}

		@Override
		public Integer Integer(String column)
		{
			return null;
		}

		@Override
		public Long Long(String column)
		{
			return null;
		}

		@Override
		public Double Double(String column)
		{
			return null;
		}

		@Override
		public Float Float(String column)
		{
			return null;
		}

		@Override
		public DateTime DateTime(String column)
		{
			return null;
		}

		@Override
		public RunsafeLocation Location()
		{
			return null;
		}

		@Override
		public RunsafeLocation Location(String world, String x, String y, String z)
		{
			return null;
		}

		@Override
		public RunsafeLocation Location(String world, String x, String y, String z, String yaw, String pitch)
		{
			return null;
		}

		@Override
		public RunsafeWorld World(String column)
		{
			return null;
		}

		@Override
		public RunsafePlayer Player(String column)
		{
			return null;
		}

		@Override
		public boolean isEmpty()
		{
			return true;
		}
	};

	public Row(Map<String, Object> data)
	{
		raw = data;
	}

	@Override
	public String String(String column)
	{
		return super.String(getValue(column));
	}

	@Override
	public Integer Integer(String column)
	{
		return super.Integer(getValue(column));
	}

	@Override
	public Long Long(String column)
	{
		return super.Long(getValue(column));
	}

	@Override
	public Double Double(String column)
	{
		return super.Double(getValue(column));
	}

	@Override
	public Float Float(String column)
	{
		return super.Float(getValue(column));
	}

	@Override
	public DateTime DateTime(String column)
	{
		return super.DateTime(getValue(column));
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
		return super.Location(getValue(world), getValue(x), getValue(y), getValue(z), getValue(yaw), getValue(pitch));
	}

	@Override
	public RunsafeWorld World(String column)
	{
		return super.World(getValue(column));
	}

	@Override
	public RunsafePlayer Player(String column)
	{
		return super.Player(getValue(column));
	}

	@Override
	public boolean isEmpty()
	{
		return raw == null;
	}

	private Object getValue(String column)
	{
		if (!raw.containsKey(column))
			return null;
		return raw.get(column);
	}

	private final Map<String, Object> raw;
}
