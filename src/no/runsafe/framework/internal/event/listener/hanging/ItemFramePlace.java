package no.runsafe.framework.internal.event.listener.hanging;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.hanging.IItemFramePlaced;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;

public final class ItemFramePlace extends EventRouterBase<IItemFramePlaced, HangingPlaceEvent>
{
	ItemFramePlace(IConsole output, IScheduler scheduler, IItemFramePlaced handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(HangingPlaceEvent event)
	{
		if (event.getEntity().getType() == EntityType.ITEM_FRAME)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(HangingPlaceEvent event)
	{
		return !handler.OnItemFramePlaced(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
			ObjectWrapper.convert((ItemFrame) event.getEntity())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IItemFramePlaced.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ItemFramePlace(output, scheduler, (IItemFramePlaced) subscriber);
			}
		};
	}
}
