package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IAsyncEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerRespawn;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public final class PlayerRespawn extends EventRouterBase<IPlayerRespawn, PlayerRespawnEvent>
{
	PlayerRespawn(IOutput output, IScheduler scheduler, IPlayerRespawn subscriber)
	{
		super(output, scheduler, subscriber);
	}

	// We have to put this here to get the annotation onto the method.
	@EventHandler
	@Override
	public void acceptEvent(PlayerRespawnEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerRespawnEvent event)
	{
		RunsafeLocation redirect = handler.OnPlayerRespawn(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
			ObjectWrapper.convert(event.getRespawnLocation()),
			event.isBedSpawn()
		);
		if (redirect != null && !(handler instanceof IAsyncEvent))
			event.setRespawnLocation(redirect.getRaw());

		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerRespawn.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerRespawn(output, scheduler, (IPlayerRespawn) subscriber);
			}
		};
	}
}
