package no.runsafe.framework.api.event.enchantment;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.enchantment.RunsafePrepareItemEnchantEvent;

public interface IPrepareItemEnchantEvent extends IRunsafeEvent
{
	void OnPrepareItemEnchantEvent(RunsafePrepareItemEnchantEvent event);
}
