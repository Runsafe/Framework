package no.runsafe.framework.minecraft.event.networking;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.INetworkEvent;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.internal.networking.NetworkManager;
import no.runsafe.framework.minecraft.event.RunsafeInternalEvent;

public abstract class RunsafeNetworkEvent extends RunsafeInternalEvent
{
	protected RunsafeNetworkEvent()
	{

	}

	@Override
	public boolean Fire()
	{
		NetworkManager.Get().handleEvent(this);
		Debug.Global().debugFiner("Firing custom event %s.", getClass().getName());
		for (INetworkEvent listener : RunsafePlugin.getAllPluginComponents(INetworkEvent.class))
		{
			Debug.Global().debugFiner("Telling %s.", listener.getClass().getName());
			listener.onNetworkEvent(this);
		}
		return true;
	}
}
