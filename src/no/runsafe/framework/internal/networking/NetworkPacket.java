package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.Packet;
import no.runsafe.framework.api.packets.IPacket;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class NetworkPacket implements IPacket
{
	@Override
	public void send(IPlayer player)
	{
		EntityPlayer rawPlayer = ObjectUnwrapper.convert(player);
		Packet packet = getNMSPacket();

		if (packet != null)
			rawPlayer.playerConnection.sendPacket(getNMSPacket());
	}

	protected void setData(String key, Object value)
	{
		data.put(key, value);
	}

	private Packet getNMSPacket()
	{
		try
		{
			Packet packet = getPacketType().makePacket();
			for (Map.Entry<String, Object> node : data.entrySet())
			{
				Field field = packet.getClass().getDeclaredField(node.getKey());
				field.setAccessible(true);
				field.set(packet, node.getValue());
			}
			return packet;
		}
		catch (Exception exception)
		{
			return null;
		}
	}

	protected HashMap<String, Object> data = new HashMap<String, Object>(0);
}
