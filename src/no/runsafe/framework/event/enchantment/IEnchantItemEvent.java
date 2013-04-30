package no.runsafe.framework.event.enchantment;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.enchantment.RunsafeEnchantItemEvent;

public interface IEnchantItemEvent extends IRunsafeEvent
{
	public void OnEnchantItemEvent(RunsafeEnchantItemEvent event);
}
