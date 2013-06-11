package no.runsafe.framework.api.database;

import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

public interface IValue
{
	String String();
	Integer Integer();
	Long Long();
	Double Double();
	Float Float();
	DateTime DateTime();
	RunsafePlayer Player();
	RunsafeWorld World();
}
