package no.runsafe.framework.api;

import no.runsafe.framework.api.event.IRunsafeEvent;
import org.bukkit.event.Listener;

public interface EventRouterFactory
{
	Class<? extends IRunsafeEvent> getInterface();

	Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber);
}
