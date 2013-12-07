package no.runsafe.framework.minecraft.event;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.INetworkEvent;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.minecraft.RunsafeServer;

public abstract class RunsafeNetworkEvent extends RunsafeInternalEvent
{
	protected RunsafeNetworkEvent()
	{

	}

	public abstract Object getData();

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		RunsafeServer.Instance.getDebugger().debugFiner("Firing custom event %s.", getClass().getName());
		for (IKernel plugin : InjectionPlugin.Instances.values())
		{
			RunsafeServer.Instance.getDebugger().debugFiner("Asking %s.", plugin.getClass().getName());
			for (INetworkEvent listener : plugin.getComponents(INetworkEvent.class))
			{
				RunsafeServer.Instance.getDebugger().debugFiner("Telling %s.", listener.getClass().getName());
				listener.onNetworkEvent(this);
			}
		}
		return true;
	}
}
