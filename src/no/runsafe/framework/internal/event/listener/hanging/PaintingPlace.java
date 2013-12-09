package no.runsafe.framework.internal.event.listener.hanging;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.hanging.IPaintingPlaced;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;

public final class PaintingPlace extends EventRouterBase<IPaintingPlaced, HangingPlaceEvent>
{
	PaintingPlace(IDebug output, IScheduler scheduler, IPaintingPlaced handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(HangingPlaceEvent event)
	{
		if (event.getEntity().getType() == EntityType.PAINTING)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(HangingPlaceEvent event)
	{
		return !handler.OnPaintingPlaced(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
			ObjectWrapper.convert((Painting) event.getEntity())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPaintingPlaced.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PaintingPlace(output, scheduler, (IPaintingPlaced) subscriber);
			}
		};
	}
}

