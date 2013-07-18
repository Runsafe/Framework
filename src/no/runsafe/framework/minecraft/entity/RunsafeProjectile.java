package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_6_R2.EntityArrow;
import net.minecraft.server.v1_6_R2.IProjectile;
import net.minecraft.server.v1_6_R2.NBTTagCompound;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
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
		if(!(minecraftProjectile instanceof EntityArrow))
			return null;

		EntityArrow arrow = (EntityArrow)minecraftProjectile;
		NBTTagCompound tag = new NBTTagCompound();
		arrow.a(tag);
		return getWorld().getBlockAt(tag.getShort("xTile"), tag.getShort("yTile"), tag.getShort("zTile"));
	}
}
