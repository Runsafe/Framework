package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_12_R1.EntityArrow;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.entity.projectiles.IProjectile;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.api.entity.IProjectileSource;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import org.bukkit.entity.Projectile;

import javax.annotation.Nullable;

public class RunsafeProjectile extends BukkitProjectile implements IProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}

	@Override
	@Nullable
	public IBlock getImpaledBlock()
	{
		Projectile projectileEntity = (Projectile) ObjectUnwrapper.convert(this);

		IWorld world = getWorld();
		if (!(projectileEntity instanceof EntityArrow) || world == null)
			return null;

		EntityArrow arrow = (EntityArrow) projectileEntity;
		NBTTagCompound tag = new NBTTagCompound();
		arrow.a(tag);
		return world.getBlockAt(tag.getShort("xTile"), tag.getShort("yTile"), tag.getShort("zTile"));
	}

	@Override
	@Nullable
	public IPlayer getShootingPlayer()
	{
		IProjectileSource shooterSource = getShooter();
		return (shooterSource instanceof IPlayer) ? (IPlayer) shooterSource : null;
	}

	@Override
	@Nullable
	public ILivingEntity getShootingEntity()
	{
		IProjectileSource shooterSource = getShooter();
		return (shooterSource instanceof ILivingEntity) ? (ILivingEntity) shooterSource : null;
	}
}
