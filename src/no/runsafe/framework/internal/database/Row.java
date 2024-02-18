package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.player.IPlayer;

import javax.activation.UnsupportedDataTypeException;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Map;

public final class Row implements IRow
{
	public static final IRow Empty = new EmptyRow();

	public Row(Map<String, Object> data)
	{
		raw = data;
	}

	@Override
	public String String(String column)
	{
		return DataConverter.String(getValue(column));
	}

	@Override
	public Integer Integer(String column) throws UnsupportedDataTypeException
	{
		return DataConverter.Integer(getValue(column));
	}

	@Override
	public Long Long(String column) throws UnsupportedDataTypeException
	{
		return DataConverter.Long(getValue(column));
	}

	@Override
	public Double Double(String column) throws UnsupportedDataTypeException
	{
		return DataConverter.Double(getValue(column));
	}

	@Override
	public Float Float(String column) throws UnsupportedDataTypeException
	{
		return DataConverter.Float(getValue(column));
	}

	@Override
	public Instant Instant(String column)
	{
		return DataConverter.Instant(getValue(column));
	}

	@Override
	public ILocation Location() throws UnsupportedDataTypeException
	{
		return Location("world", "x", "y", "z", "yaw", "pitch");
	}

	@Override
	public ILocation Location(String world, String x, String y, String z) throws UnsupportedDataTypeException
	{
		return Location(world, x, y, z, "yaw", "pitch");
	}

	@Override
	public ILocation Location(String world, String x, String y, String z, String yaw, String pitch) throws UnsupportedDataTypeException
	{
		return DataConverter.Location(getValue(world), getValue(x), getValue(y), getValue(z), getValue(yaw), getValue(pitch));
	}

	@Override
	public IWorld World(String column)
	{
		return DataConverter.World(getValue(column));
	}

	@Override
	public IPlayer Player(String column)
	{
		return DataConverter.Player(getValue(column));
	}

	@Override
	public Boolean Boolean(String column) throws UnsupportedDataTypeException
	{
		return DataConverter.Boolean(getValue(column));
	}

	@Override
	public boolean isEmpty()
	{
		return raw == null;
	}

	@Nullable
	private Object getValue(String column)
	{
		if (!raw.containsKey(column))
			return null;
		return raw.get(column);
	}

	private final Map<String, Object> raw;

	private static class EmptyRow implements IRow
	{
		EmptyRow()
		{
		}

		@Override
		@Nullable
		public String String(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public Integer Integer(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public Long Long(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public Double Double(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public Float Float(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public Instant Instant(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public ILocation Location()
		{
			return null;
		}

		@Override
		@Nullable
		public ILocation Location(String world, String x, String y, String z)
		{
			return null;
		}

		@Override
		@Nullable
		public ILocation Location(String world, String x, String y, String z, String yaw, String pitch)
		{
			return null;
		}

		@Override
		@Nullable
		public IWorld World(String column)
		{
			return null;
		}

		@Override
		@Nullable
		public IPlayer Player(String column)
		{
			return null;
		}

		@Override
		public Boolean Boolean(String column) { return null; }

		@Override
		public boolean isEmpty()
		{
			return true;
		}
	}
}
