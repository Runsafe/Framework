package no.runsafe.framework.event.enchantment;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.enchantment.RunsafePrepareItemEnchantEvent;

public interface IPrepareItemEnchantEvent extends IRunsafeEvent
{
	public void OnPrepareItemEnchantEvent(RunsafePrepareItemEnchantEvent event);
}
