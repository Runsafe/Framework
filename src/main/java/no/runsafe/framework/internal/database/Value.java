package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.api.player.IPlayer;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.time.Instant;

public final class Value implements IValue
{
	public static final IValue Empty = new EmptyValue();

	public Value(Object data)
	{
		raw = data;
	}

	@Override
	public String String()
	{
		return DataConverter.String(raw);
	}

	@Override
	public Integer Integer()
	{
		return DataConverter.Integer(raw);
	}

	@Override
	public Long Long()
	{
		return DataConverter.Long(raw);
	}

	@Override
	public Double Double()
	{
		return DataConverter.Double(raw);
	}

	@Override
	public Float Float()
	{
		return DataConverter.Float(raw);
	}

	@Override
	@Deprecated // Use Instant Instead
	public DateTime DateTime()
	{
		return DataConverter.DateTime(raw);
	}

	@Override
	public Instant Instant()
	{
		return DataConverter.Instant(raw);
	}

	@Override
	public IPlayer Player()
	{
		return DataConverter.Player(raw);
	}

	@Override
	public IWorld World()
	{
		return DataConverter.World(raw);
	}

	@Override
	public boolean isEmpty()
	{
		return raw == null;
	}

	private final Object raw;

	private static class EmptyValue implements IValue
	{
		EmptyValue()
		{
		}

		@Override
		@Nullable
		public String String()
		{
			return null;
		}

		@Override
		@Nullable
		public Integer Integer()
		{
			return null;
		}

		@Override
		@Nullable
		public Long Long()
		{
			return null;
		}

		@Override
		@Nullable
		public Double Double()
		{
			return null;
		}

		@Override
		@Nullable
		public Float Float()
		{
			return null;
		}

		@Override
		@Nullable
		@Deprecated // Use Instant Instead
		public DateTime DateTime()
		{
			return null;
		}

		@Override
		@Nullable
		public Instant Instant()
		{
			return null;
		}

		@Override
		@Nullable
		public IPlayer Player()
		{
			return null;
		}

		@Override
		@Nullable
		public IWorld World()
		{
			return null;
		}

		@Override
		public boolean isEmpty()
		{
			return true;
		}
	}
}
