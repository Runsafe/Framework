package no.runsafe.framework.api.event.enchantment;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.enchantment.RunsafeEnchantItemEvent;

public interface IEnchantItemEvent extends IRunsafeEvent
{
	void OnEnchantItemEvent(RunsafeEnchantItemEvent event);
}
