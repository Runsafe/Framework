package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_6_R3.EntityArrow;
import net.minecraft.server.v1_6_R3.NBTTagCompound;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import org.bukkit.entity.Projectile;

import javax.annotation.Nullable;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}

	@Nullable
	public IBlock getImpaledBlock()
	{
		Projectile projectileEntity = ObjectUnwrapper.convert(this);

		IWorld world = getWorld();
		if (!(projectileEntity instanceof EntityArrow) || world == null)
			return null;

		EntityArrow arrow = (EntityArrow) projectileEntity;
		NBTTagCompound tag = new NBTTagCompound();
		arrow.a(tag);
		return world.getBlockAt(tag.getShort("xTile"), tag.getShort("yTile"), tag.getShort("zTile"));
	}

	@Nullable
	@SuppressWarnings({"LocalVariableOfConcreteClass"})
	public IPlayer getShooterPlayer()
	{
		IWorld world = getWorld();
		RunsafeLivingEntity shooter = getShooter();

		if (world != null && shooter != null)
		{
			IEntity shooterEntity = world.getEntityById(shooter.getEntityId());

			if (shooterEntity instanceof IPlayer)
				return (IPlayer) shooterEntity;
		}

		return null;
	}
}
