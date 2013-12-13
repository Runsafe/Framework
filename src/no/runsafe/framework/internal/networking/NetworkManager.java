package no.runsafe.framework.internal.networking;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.INetworkEvent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.minecraft.event.networking.RunsafeNetworkEvent;
import no.runsafe.framework.minecraft.event.networking.RunsafeSendPacketEvent;
import no.runsafe.framework.minecraft.packets.PacketPlayerInfo;

import java.util.HashMap;
import java.util.Map;

public class NetworkManager implements INetworkEvent
{
	public static NetworkManager Get()
	{
		return InjectionPlugin.getGlobalComponent(NetworkManager.class);
	}

	public NetworkManager(IConsole output)
	{
		this.output = output;
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

	@SuppressWarnings({"InstanceofInterfaces", "CastToConcreteClass", "LocalVariableOfConcreteClass"})
	@Override
	public void onNetworkEvent(RunsafeNetworkEvent networkEvent)
	{
		output.logInformation("Network event detected.");
		if (networkEvent instanceof RunsafeSendPacketEvent)
		{
			output.logInformation("Network event is a RunsafeSendPacketEvent.");
			RunsafeSendPacketEvent sendEvent = (RunsafeSendPacketEvent) networkEvent;
			NetworkPacket rawPacket = sendEvent.getPacket();

			if (rawPacket instanceof PacketPlayerInfo)
			{
				output.logInformation("Packet is a PacketPlayerInfo.");
				PacketPlayerInfo packet = (PacketPlayerInfo) rawPacket;
				output.logInformation("Setting name to: %s", getTabListName(sendEvent.getPlayer()));
				packet.setPlayerName(getTabListName(sendEvent.getPlayer()));
			}
		}
	}

	private static final int PLAYERLIST_MAXLENGTH = 16;
	private final Map<String, String> tabListNames = new HashMap<String, String>(0);
	private final IConsole output;
}
