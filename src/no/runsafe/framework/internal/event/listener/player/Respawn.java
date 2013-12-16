package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IAsyncEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerRespawn;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public final class Respawn extends EventRouterBase<IPlayerRespawn, PlayerRespawnEvent>
{
	Respawn(IConsole output, IScheduler scheduler, IPlayerRespawn subscriber)
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
		ILocation redirect = handler.OnPlayerRespawn(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
			ObjectWrapper.convert(event.getRespawnLocation()),
			event.isBedSpawn()
		);
		if (redirect != null && !(handler instanceof IAsyncEvent))
			event.setRespawnLocation((Location) ObjectUnwrapper.convert(redirect));

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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Respawn(output, scheduler, (IPlayerRespawn) subscriber);
			}
		};
	}
}
