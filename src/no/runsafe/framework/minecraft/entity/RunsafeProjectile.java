package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_6_R3.EntityArrow;
import net.minecraft.server.v1_6_R3.IProjectile;
import net.minecraft.server.v1_6_R3.NBTTagCompound;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.entity.Projectile;

import javax.annotation.Nullable;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	@Nullable
	public IBlock getImpaledBlock()
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

	@Nullable
	@SuppressWarnings({"CastToConcreteClass", "InstanceofInterfaces", "LocalVariableOfConcreteClass"})
	public IPlayer getShooterPlayer()
	{
		RunsafeWorld world = getWorld();
		RunsafeLivingEntity shooter = getShooter();

		if (world != null && shooter != null)
		{
			RunsafeEntity shooterEntity = world.getEntityById(shooter.getEntityId());

			if (shooterEntity instanceof RunsafePlayer)
				return (IPlayer) shooterEntity;
		}

		return null;
	}
}
