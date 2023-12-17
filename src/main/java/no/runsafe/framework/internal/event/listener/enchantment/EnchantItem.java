package no.runsafe.framework.internal.event.listener.enchantment;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.enchantment.IEnchantItemEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.enchantment.RunsafeEnchantItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public final class EnchantItem extends EventRouterBase<IEnchantItemEvent, EnchantItemEvent>
{
	EnchantItem(IConsole output, IScheduler scheduler, IEnchantItemEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EnchantItemEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EnchantItemEvent event)
	{
		handler.OnEnchantItemEvent(new RunsafeEnchantItemEvent(event));
		return false;
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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EnchantItem(output, scheduler, (IEnchantItemEvent) subscriber);
			}
		};
	}
}
