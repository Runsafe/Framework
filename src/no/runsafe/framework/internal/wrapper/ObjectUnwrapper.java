package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_7_R1.Entity;
import net.minecraft.server.v1_7_R1.EntityPlayer;
import net.minecraft.server.v1_7_R1.EntityProjectile;
import net.minecraft.server.v1_7_R1.World;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_7_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftProjectile;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import javax.annotation.Nullable;

@SuppressWarnings("OverloadedMethodsWithSameNumberOfParameters")
public final class ObjectUnwrapper
{
	private ObjectUnwrapper()
	{
	}

	@Nullable
	public static EntityPlayer getMinecraft(IPlayer player)
	{
		Player bukkit = convert(player);
		if (bukkit == null)
			return null;
		return ((CraftPlayer) bukkit).getHandle();
	}

	@Nullable
	public static Entity getMinecraft(IEntity entity)
	{
		org.bukkit.entity.Entity bukkit = convert(entity);
		if (bukkit == null)
			return null;
		return ((CraftEntity) bukkit).getHandle();
	}

	@Nullable
	public static EntityProjectile getMinecraft(RunsafeProjectile projectile)
	{
		Projectile bukkit = (Projectile) convert(projectile);
		if (bukkit == null)
			return null;
		return ((CraftProjectile) bukkit).getHandle();
	}

	@Nullable
	public static World getMinecraft(IWorld world)
	{
		org.bukkit.World bukkitWorld = convert(world);
		return ((CraftWorld) bukkitWorld).getHandle();
	}

	@SuppressWarnings("unchecked")
	@Nullable
	public static <T> T convert(Object wrapper)
	{
		return convert((IWrapper<T>) wrapper);
	}

	public static OfflinePlayer convert(BukkitPlayer player)
	{
		return player.getBasePlayer();
	}

	@Nullable
	public static <T> T convert(IWrapper<T> wrapper)
	{
		return wrapper.getRaw();
	}
}
