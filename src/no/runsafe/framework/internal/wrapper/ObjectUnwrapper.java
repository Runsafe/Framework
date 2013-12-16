package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_6_R3.Entity;
import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.EntityProjectile;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftProjectile;
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
		Projectile bukkit = convert(projectile);
		if (bukkit == null)
			return null;
		return ((CraftProjectile) bukkit).getHandle();
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
