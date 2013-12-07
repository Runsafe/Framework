package no.runsafe.framework.api.database;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import org.joda.time.DateTime;

public interface IValue extends IResult
{
	String String();
	Integer Integer();
	Long Long();
	Double Double();
	Float Float();
	DateTime DateTime();
	IPlayer Player();
	RunsafeWorld World();
}
