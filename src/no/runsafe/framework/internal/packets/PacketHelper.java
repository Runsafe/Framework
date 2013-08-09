package no.runsafe.framework.internal.packets;

import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PacketHelper
{
	private PacketHelper(){}

	public static String getPackageName()
	{
		Matcher match = pattern.matcher(Bukkit.getServer().getClass().getPackage().getName());
		return "net.minecraft.server." + match.group(2);
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

	private static final Pattern pattern = Pattern.compile("(\\.)(\\w+)$");
}
