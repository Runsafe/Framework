package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.INetworkManager;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.PlayerConnection;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.reflection.ReflectionHelper;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.networking.RunsafePlayerConnection;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.lang.reflect.Field;

public class NetworkEngine
{
	public static void interceptConnection(RunsafePlayer player, IOutput output)
	{
		try
		{
			EntityPlayer nmsPlayer = ObjectUnwrapper.convert(player);

			Field field = ReflectionHelper.getField(nmsPlayer, "playerConnection");
			field.setAccessible(true);

			PlayerConnection rawConnection = (PlayerConnection) field.get(nmsPlayer);

			MinecraftServer server = (MinecraftServer) ReflectionHelper.getFieldObject(rawConnection, "minecraftServer");
			INetworkManager manager = (INetworkManager) ReflectionHelper.getFieldObject(rawConnection, "networkManager");

			field.set(nmsPlayer, new RunsafePlayerConnection(server, manager, nmsPlayer, output));
		}
		catch (Exception exception)
		{
			output.write(exception.getMessage());
			output.warning("Invalid EntityPlayer class found, check framework is up-to-date?");
		}
	}
}
