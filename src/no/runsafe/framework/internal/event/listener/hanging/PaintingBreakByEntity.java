package no.runsafe.framework.internal.event.listener.hanging;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.hanging.IPaintingBreakByEntity;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;

public class PaintingBreakByEntity extends EventRouterBase<IPaintingBreakByEntity, HangingBreakByEntityEvent>
{
	PaintingBreakByEntity(IConsole output, IScheduler scheduler, IPaintingBreakByEntity handler)
	{
		super(output, scheduler, handler);
	}
	@EventHandler
	@Override
	public void acceptEvent(HangingBreakByEntityEvent event)
	{
		if (event.getEntity().getType() == EntityType.PAINTING)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(HangingBreakByEntityEvent event)
	{
		return !handler
			.OnPaintingBreak(
			ObjectWrapper.convert((OfflinePlayer) event.getRemover()),
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
				return IPaintingBreakByEntity.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PaintingBreakByEntity(output, scheduler, (IPaintingBreakByEntity) subscriber);
			}
		};
	}
}
