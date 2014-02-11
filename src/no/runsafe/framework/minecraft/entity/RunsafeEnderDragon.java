package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_7_R1.EntityEnderDragon;
import net.minecraft.server.v1_7_R1.EntityLiving;
import no.runsafe.framework.api.entity.IEnderDragon;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.ILivingEntity;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftLivingEntity;
import org.bukkit.entity.EnderDragon;

public class RunsafeEnderDragon extends RunsafeLivingEntity implements IEnderDragon
{
	public RunsafeEnderDragon(EnderDragon toWrap)
	{
		super(toWrap);
		dragon = toWrap;
	}

	@Override
	public void setDragonTarget(ILivingEntity entity)
	{
		EntityEnderDragon raw = ((CraftEnderDragon) dragon).getHandle();
		raw.setGoalTarget(((CraftLivingEntity) entity).getHandle());
	}

	private final EnderDragon dragon;
}
