package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IAsyncEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerRespawn;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeLocation;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public final class PlayerRespawn extends EventRouterBase<IPlayerRespawn, PlayerRespawnEvent>
{
	PlayerRespawn(IDebug output, IScheduler scheduler, IPlayerRespawn subscriber)
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

	@SuppressWarnings("LocalVariableOfConcreteClass")
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
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerRespawn(output, scheduler, (IPlayerRespawn) subscriber);
			}
		};
	}
}
