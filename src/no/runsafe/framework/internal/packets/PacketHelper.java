package no.runsafe.framework.internal.packets;

import no.runsafe.framework.api.player.IPlayer;
import org.bukkit.Bukkit;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PacketHelper
{
	private PacketHelper(){}

	@Nullable
	public static String getPackageName()
	{
		Matcher match = pattern.matcher(Bukkit.getServer().getClass().getPackage().getName());

		if (match.find())
			return "net.minecraft.server." + match.group(2);

		return null;
	}

	public static Object getPacket(String packetClass) throws Exception
	{
		Class<?> packet = Class.forName(String.format("%s.%s", getPackageName(), packetClass));
		return packet.getConstructors()[0].newInstance();
	}

	public static Object stuffPacket(Object packet, HashMap<String, Object> values) throws Exception
	{
		for (Map.Entry<String, Object> node : values.entrySet())
		{
			Field field = packet.getClass().getDeclaredField(node.getKey());
			field.setAccessible(true);
			field.set(packet, node.getValue());
		}
		return packet;
	}

	@Nullable
	public static Method getMethod(String name, Class<?> c, int params)
	{
		for (Method method : c.getMethods())
			if (method.getName().equals(name) && method.getParameterTypes().length == params)
				return method;

		return null;
	}

	public static void sendPacket(IPlayer player, Object packet) throws Exception
	{
		Object entityPlayer = getMethod("getHandle", player.getClass(), 0).invoke(player);
		Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
		getMethod("sendPacket", playerConnection.getClass(), 1).invoke(playerConnection, packet);
	}

	private static final Pattern pattern = Pattern.compile("(\\.)(\\w+)$");
}