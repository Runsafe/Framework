package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeFish;
import org.bukkit.event.player.PlayerFishEvent;

public class RunsafePlayerFishEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerFishEvent(PlayerFishEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getCaught()
	{
		return ObjectWrapper.convert(event.getCaught());
	}

	public RunsafeFish getFish()
	{
		return ObjectWrapper.convert(event.getHook());
	}

	public int getExpToDrop()
	{
		return event.getExpToDrop();
	}

	public void setExpToDrop(int exp)
	{
		event.setExpToDrop(exp);
	}

	public State getState()
	{
		return State.valueOf(event.getState().name());
	}

	public enum State
	{
		FISHING,
		CAUGHT_FISH,
		CAUGHT_ENTITY,
		IN_GROUND,
		FAILED_ATTEMPT
	}

	private final PlayerFishEvent event;
}
