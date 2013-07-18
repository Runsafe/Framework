package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_6_R2.Entity;
import net.minecraft.server.v1_6_R2.EntityPlayer;
import net.minecraft.server.v1_6_R2.IProjectile;
import net.minecraft.server.v1_6_R2.World;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.craftbukkit.v1_6_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftProjectile;

import javax.annotation.Nullable;

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
}
