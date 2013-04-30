package no.runsafe.framework.event.listener.enchantment;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.enchantment.IEnchantItemEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.enchantment.RunsafeEnchantItemEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class EnchantItem extends EventRouterBase<IEnchantItemEvent, EnchantItemEvent>
{
	protected EnchantItem(IOutput output, IScheduler scheduler, IEnchantItemEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EnchantItemEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(EnchantItemEvent event)
	{
		handler.OnEnchantItemEvent(new RunsafeEnchantItemEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IEnchantItemEvent> getInterface()
			{
				return IEnchantItemEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EnchantItem(output, scheduler, (IEnchantItemEvent) subscriber);
			}
		};
	}
}
