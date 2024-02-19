package no.runsafe.framework.api.database;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import java.time.Instant;

public interface IValue extends IResult
{
	String String();
	Integer Integer();
	Long Long();
	Double Double();
	Float Float();
	Instant Instant();
	IPlayer Player();
	IWorld World();
}
