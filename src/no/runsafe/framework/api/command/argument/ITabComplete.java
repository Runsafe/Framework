package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public interface ITabComplete
{
	List<String> getAlternatives(RunsafePlayer executor, String partial);
}
