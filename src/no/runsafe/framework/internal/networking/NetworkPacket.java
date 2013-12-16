package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.Packet;
import no.runsafe.framework.api.packets.IPacket;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public abstract class NetworkPacket implements IPacket
{
	protected NetworkPacket()
	{}

	@Override
	public void send(IPlayer player)
	{
		EntityPlayer rawPlayer = ObjectUnwrapper.getMinecraft(player);

		if (wrappedPacket != null && rawPlayer != null)
			rawPlayer.playerConnection.sendPacket(wrappedPacket);
	}

	protected void setData(String key, Object value)
	{
		try
		{
			constructPacket(); // Make sure we have a packet.
			getPacketField(key).set(wrappedPacket, value);
		}
		catch (Exception exception)
		{
			// Can't set it, whelp..
		}
	}

	@Nullable
	protected Object getData(String key)
	{
		try
		{
			return getPacketField(key).get(wrappedPacket);
		}
		catch (Exception exception)
		{
			return null;
		}
	}

	private Field getPacketField(String key) throws Exception
	{
		Field field = wrappedPacket.getClass().getDeclaredField(key);
		field.setAccessible(true);
		return field;
	}

	protected void constructPacket() throws Exception
	{
		if (wrappedPacket == null)
			wrappedPacket = getPacketType().makePacket();
	}

	protected void setWrappedPacket(Packet packet)
	{
		wrappedPacket = packet;
	}

	protected Packet wrappedPacket;
}
