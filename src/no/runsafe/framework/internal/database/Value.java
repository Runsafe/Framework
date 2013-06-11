package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

public final class Value extends DataConverter implements IValue
{
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

	private final Object raw;
}
