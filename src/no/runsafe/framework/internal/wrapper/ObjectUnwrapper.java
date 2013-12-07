package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_6_R3.Entity;
import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.IProjectile;
import net.minecraft.server.v1_6_R3.World;
import net.minecraft.v1_6_R3.org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.OfflinePlayer;
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
		return ((CraftPlayer) player.getRaw()).getHandle();
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

	public static World convert(RunsafeWorld world)
	{
		return ((CraftWorld) world.getRaw()).getHandle();
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
