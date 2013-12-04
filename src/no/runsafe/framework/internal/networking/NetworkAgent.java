package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.INetworkManager;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.PlayerConnection;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.player.IPlayerPreLoginEvent;
import no.runsafe.framework.internal.reflection.ReflectionHelper;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPreLoginEvent;
import no.runsafe.framework.minecraft.networking.RunsafePlayerConnection;

import java.lang.reflect.Field;

public class NetworkAgent implements IPlayerPreLoginEvent
{
	public NetworkAgent(IOutput output)
	{
		this.output = output;
		output.write("Network agent online.");
	}

	@Override
	public void OnBeforePlayerLogin(RunsafePlayerPreLoginEvent event)
	{
		output.write("Detected player log-in: " + event.getPlayer().getName());
		try
		{
			EntityPlayer nmsPlayer = ObjectUnwrapper.convert(event.getPlayer());

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

	private IOutput output;
}
