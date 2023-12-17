package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class RunsafePlayerChangedWorldEvent extends RunsafePlayerEvent
{
	public RunsafePlayerChangedWorldEvent(PlayerChangedWorldEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IWorld getSourceWorld()
	{
		return ObjectWrapper.convert(event.getFrom());
	}

	private final PlayerChangedWorldEvent event;
}
