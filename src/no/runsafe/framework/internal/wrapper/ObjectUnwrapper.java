package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_6_R3.*;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_6_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftProjectile;

import javax.annotation.Nullable;

@SuppressWarnings("OverloadedMethodsWithSameNumberOfParameters")
public final class ObjectUnwrapper
{
	private ObjectUnwrapper()
	{
	}

	@Nullable
	public static EntityPlayer convert(RunsafePlayer player)
	{
		if (player == null)
			return null;

		CraftPlayer craftPlayer = (CraftPlayer) player.getRaw();
		if (craftPlayer == null)
			return null;

		return craftPlayer.getHandle();
	}

	@Nullable
	public static Entity convert(RunsafeEntity entity)
	{
		if (entity == null)
			return null;
		return ((CraftEntity) entity.getRaw()).getHandle();
	}

	public static IProjectile convert(RunsafeProjectile projectile)
	{
		return ((CraftProjectile) projectile.getRaw()).getHandle();
	}

	@SuppressWarnings("unchecked")
	public static <T> T convert(Object wrapper)
	{
		return ((IWrapper<T>)wrapper).getRaw();
	}

	public static OfflinePlayer convert(BukkitPlayer player)
	{
		return player.getBasePlayer();
	}

	public static <T extends Object> T convert(IWrapper<T> wrapper)
	{
		return wrapper.getRaw();
	}
}
