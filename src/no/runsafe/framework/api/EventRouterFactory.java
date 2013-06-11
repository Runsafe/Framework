package no.runsafe.framework.api;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.Listener;

public interface EventRouterFactory
{
	Class<? extends IRunsafeEvent> getInterface();
	Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber);
}
