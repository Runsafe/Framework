package no.runsafe.framework.internal.database;

import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

public final class Value extends DataConverter
{
	public Value(Object data)
	{
		raw = data;
	}

	public String String()
	{
		return super.String(raw);
	}

	public Integer Integer()
	{
		return super.Integer(raw);
	}

	public Long Long()
	{
		return super.Long(raw);
	}

	public Double Double()
	{
		return super.Double(raw);
	}

	public Float Float()
	{
		return super.Float(raw);
	}

	public DateTime DateTime()
	{
		return super.DateTime(raw);
	}

	public RunsafePlayer Player()
	{
		return super.Player(raw);
	}

	public RunsafeWorld World()
	{
		return super.World(raw);
	}

	private final Object raw;
}
