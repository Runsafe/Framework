package no.runsafe.framework.internal.event.listener.enchantment;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.enchantment.IPrepareItemEnchantEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.enchantment.RunsafePrepareItemEnchantEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public final class PrepareItemEnchant extends EventRouterBase<IPrepareItemEnchantEvent, PrepareItemEnchantEvent>
{
	protected PrepareItemEnchant(IOutput output, IScheduler scheduler, IPrepareItemEnchantEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PrepareItemEnchantEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PrepareItemEnchantEvent event)
	{
		handler.OnPrepareItemEnchantEvent(new RunsafePrepareItemEnchantEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IPrepareItemEnchantEvent> getInterface()
			{
				return IPrepareItemEnchantEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent handler)
			{
				return new PrepareItemEnchant(output, scheduler, (IPrepareItemEnchantEvent) handler);
			}
		};
	}
}
