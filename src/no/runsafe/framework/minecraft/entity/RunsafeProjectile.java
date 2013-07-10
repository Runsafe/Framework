package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_6_R2.EntityArrow;
import net.minecraft.server.v1_6_R2.NBTTagCompound;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftArrow;
import org.bukkit.entity.Projectile;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}

	public RunsafeBlock getImpaledBlock()
	{
		EntityArrow arrow = ((CraftArrow) this.getRaw()).getHandle();
		NBTTagCompound tag = new NBTTagCompound();
		arrow.a(tag);

		return this.getWorld().getBlockAt(tag.getShort("xTile"), tag.getShort("yTile"), tag.getShort("zTile"));
	}
}
