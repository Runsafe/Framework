package no.runsafe.framework.api.player;

public interface IAmbiguousPlayer extends IPlayer
{
	Iterable<String> getAmbiguity();
}
