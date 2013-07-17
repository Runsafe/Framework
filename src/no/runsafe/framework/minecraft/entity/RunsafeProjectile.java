package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_6_R2.EntityArrow;
import net.minecraft.server.v1_6_R2.IProjectile;
import net.minecraft.server.v1_6_R2.NBTTagCompound;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import org.bukkit.entity.Projectile;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}

	public RunsafeBlock getImpaledBlock()
	{
		IProjectile projectile = ObjectUnwrapper.convert(this);
		if(!(projectile instanceof EntityArrow))
			return null;

		EntityArrow arrow = (EntityArrow)projectile;
		NBTTagCompound tag = new NBTTagCompound();
		arrow.a(tag);
		return this.getWorld().getBlockAt(tag.getShort("xTile"), tag.getShort("yTile"), tag.getShort("zTile"));
	}
}
