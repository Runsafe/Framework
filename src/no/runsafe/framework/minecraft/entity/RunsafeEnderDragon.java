package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_8_R3.EntityEnderDragon;
import no.runsafe.framework.api.entity.IEnderDragon;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.*;
import org.bukkit.entity.LivingEntity;

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
		LivingEntity livingEntity = ObjectUnwrapper.convert(entity);
		raw.b(((CraftLivingEntity) livingEntity).getHandle());
	}

	private final EnderDragon dragon;
}
