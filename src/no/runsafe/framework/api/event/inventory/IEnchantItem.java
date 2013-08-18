package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.enchantment.RunsafeEnchantItemEvent;

public interface IEnchantItem extends IRunsafeEvent
{
	void OnEnchantItem(RunsafeEnchantItemEvent event);
}
