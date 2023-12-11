package no.runsafe.framework.api.database;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import org.joda.time.DateTime;

import java.time.Instant;

public interface IValue extends IResult
{
	String String();
	Integer Integer();
	Long Long();
	Double Double();
	Float Float();
	@Deprecated // Use Instant Instead
	DateTime DateTime();
	Instant Instant();
	IPlayer Player();
	IWorld World();
}
