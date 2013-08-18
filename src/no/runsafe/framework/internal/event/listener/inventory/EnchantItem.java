package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IEnchantItem;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.enchantment.RunsafeEnchantItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public final class EnchantItem extends EventRouterBase<IEnchantItem, EnchantItemEvent>
{
	EnchantItem(IOutput output, IScheduler scheduler, IEnchantItem handler)
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
		handler.OnEnchantItem(new RunsafeEnchantItemEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IEnchantItem> getInterface()
			{
				return IEnchantItem.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EnchantItem(output, scheduler, (IEnchantItem) subscriber);
			}
		};
	}
}