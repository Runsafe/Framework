package no.runsafe.framework.internal.networking;

import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.minecraft.event.networking.RunsafeNetworkEvent;

import java.util.HashMap;
import java.util.Map;

public class NetworkManager
{
	public static NetworkManager Get()
	{
		return InjectionPlugin.getGlobalComponent(NetworkManager.class);
	}

	public NetworkManager()
	{
		debug = Debug.Global();
		debug.debugInfo("Network manager is active.");
	}

	public void setTabListName(IPlayer player, String name)
	{
		if (name.length()> PLAYERLIST_MAXLENGTH)
			name = name.substring(0, PLAYERLIST_MAXLENGTH);

		tabListNames.put(player.getName(), name);
	}

	public String getTabListName(IPlayer player)
	{
		String playerName = player.getName();

		if (tabListNames.containsKey(playerName))
			return tabListNames.get(playerName);

		return playerName;
	}

	public void handleEvent(RunsafeNetworkEvent networkEvent)
	{
		debug.debugInfo("Network event detected.");
		/*if (networkEvent instanceof RunsafeSendPacketEvent)
		{
			debug.debugInfo("Network event is instanceof RunsafeSendPacketEvent");
			RunsafeSendPacketEvent sendEvent = (RunsafeSendPacketEvent) networkEvent;
			NetworkPacket rawPacket = sendEvent.getPacket();

			if (rawPacket instanceof PacketPlayerInfo)
			{
				debug.debugInfo("rawPacket is instanceof PacketPlayerInfo");
				PacketPlayerInfo packet = (PacketPlayerInfo) rawPacket;

				debug.debugInfo("Tab name: " + getTabListName(sendEvent.getPlayer()));
				packet.setPlayerName(getTabListName(sendEvent.getPlayer()));
			}
		}*/
	}

	private final IDebug debug;
	private static final int PLAYERLIST_MAXLENGTH = 16;
	private final Map<String, String> tabListNames = new HashMap<String, String>(0);
}
