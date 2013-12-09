package no.runsafe.framework.minecraft.event.networking;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.INetworkEvent;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.minecraft.event.RunsafeInternalEvent;

public abstract class RunsafeNetworkEvent extends RunsafeInternalEvent
{
	protected RunsafeNetworkEvent()
	{

	}

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
