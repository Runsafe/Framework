package no.runsafe.framework.event.listener.hanging;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.hanging.IPaintingPlaced;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;

public class PaintingPlace extends EventRouterBase<IPaintingPlaced, HangingPlaceEvent>
{
	protected PaintingPlace(IOutput output, IScheduler scheduler, IPaintingPlaced handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(HangingPlaceEvent event)
	{
		if (event.getEntity().getType() == EntityType.PAINTING)
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(HangingPlaceEvent event)
	{
		return handler.OnPaintingPlaced(
			ObjectWrapper.convert(event.getPlayer()),
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
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PaintingPlace(output, scheduler, (IPaintingPlaced) subscriber);
			}
		};
	}
}

