package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

public final class Value extends DataConverter implements IValue
{
	public static final IValue Empty = new IValue()
	{
		@Override
		public String String()
		{
			return null;
		}

		@Override
		public Integer Integer()
		{
			return null;
		}

		@Override
		public Long Long()
		{
			return null;
		}

		@Override
		public Double Double()
		{
			return null;
		}

		@Override
		public Float Float()
		{
			return null;
		}

		@Override
		public DateTime DateTime()
		{
			return null;
		}

		@Override
		public RunsafePlayer Player()
		{
			return null;
		}

		@Override
		public RunsafeWorld World()
		{
			return null;
		}

		@Override
		public boolean isEmpty()
		{
			return true;
		}
	};

	public Value(Object data)
	{
		raw = data;
	}

	@Override
	public String String()
	{
		return super.String(raw);
	}

	@Override
	public Integer Integer()
	{
		return super.Integer(raw);
	}

	@Override
	public Long Long()
	{
		return super.Long(raw);
	}

	@Override
	public Double Double()
	{
		return super.Double(raw);
	}

	@Override
	public Float Float()
	{
		return super.Float(raw);
	}

	@Override
	public DateTime DateTime()
	{
		return super.DateTime(raw);
	}

	@Override
	public RunsafePlayer Player()
	{
		return super.Player(raw);
	}

	@Override
	public RunsafeWorld World()
	{
		return super.World(raw);
	}

	@Override
	public boolean isEmpty()
	{
		return raw == null;
	}

	private final Object raw;
}
