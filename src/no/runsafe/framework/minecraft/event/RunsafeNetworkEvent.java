package no.runsafe.framework.minecraft.event;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.INetworkEvent;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.internal.InjectionPlugin;

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
		Debug.Global().debugFiner("Firing custom event %s.", getClass().getName());
		for (IKernel plugin : InjectionPlugin.Instances.values())
		{
			Debug.Global().debugFiner("Asking %s.", plugin.getClass().getName());
			for (INetworkEvent listener : plugin.getComponents(INetworkEvent.class))
			{
				Debug.Global().debugFiner("Telling %s.", listener.getClass().getName());
				listener.onNetworkEvent(this);
			}
		}
		return true;
	}
}
