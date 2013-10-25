package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_6_R3.EntityArrow;
import net.minecraft.server.v1_6_R3.IProjectile;
import net.minecraft.server.v1_6_R3.NBTTagCompound;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.entity.Projectile;

import javax.annotation.Nullable;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}

	@Nullable
	public RunsafeBlock getImpaledBlock()
	{
		IProjectile minecraftProjectile = ObjectUnwrapper.convert(this);
		RunsafeWorld world = getWorld();
		if (!(minecraftProjectile instanceof EntityArrow) || world == null)
			return null;

		EntityArrow arrow = (EntityArrow) minecraftProjectile;
		NBTTagCompound tag = new NBTTagCompound();
		arrow.a(tag);
		return world.getBlockAt(tag.getShort("xTile"), tag.getShort("yTile"), tag.getShort("zTile"));
	}

	public RunsafePlayer getShooterPlayer()
	{
		RunsafeWorld world = getWorld();
		RunsafeLivingEntity shooter = getShooter();

		if (world != null && shooter != null)
		{
			RunsafeEntity shooterEntity = world.getEntityById(shooter.getEntityId());

			if (shooterEntity instanceof RunsafePlayer)
				return (RunsafePlayer) shooterEntity;
		}

		return null;
	}
}
