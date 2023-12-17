package no.runsafe.framework.api;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.log.IConsole;
import org.bukkit.event.Listener;

public interface EventRouterFactory
{
	Class<? extends IRunsafeEvent> getInterface();

	Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber);
}
