package no.runsafe.framework.event.listener;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.Listener;

public interface EventRouterFactory
{
	Class<? extends IRunsafeEvent> getInterface();
	Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber);
}
