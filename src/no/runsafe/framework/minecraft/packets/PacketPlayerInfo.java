package no.runsafe.framework.minecraft.packets;

import no.runsafe.framework.internal.networking.NetworkPacket;

@SuppressWarnings("OverridableMethodCallDuringObjectConstruction")
public class PacketPlayerInfo extends NetworkPacket
{
	public PacketPlayerInfo(String playerName, boolean flag, int ping)
	{
		setPlayerName(playerName);
		setFlag(flag);
		setPing(ping);
	}

	public String getPlayerName()
	{
		return (String) getData("a");
	}

	public boolean getFlag()
	{
		return (Boolean) getData("b");
	}

	public int getPing()
	{
		return (Integer) getData("c");
	}

	public void setPlayerName(String playerName)
	{
		setData("a", playerName);
	}

	public void setFlag(boolean flag)
	{
		setData("b", flag);
	}

	public void setPing(int ping)
	{
		setData("c", ping);
	}

	@Override
	public PacketType getPacketType()
	{
		return PacketType.PLAYER_INFO;
	}
}
