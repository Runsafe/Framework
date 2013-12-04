package no.runsafe.framework.internal.networking;

import no.runsafe.framework.RunsafePlugin;

public class NetworkAgentPlugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		addComponent(NetworkAgent.class);
	}
}
