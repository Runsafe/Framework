package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_12_R1.EntityEnderDragon;
import no.runsafe.framework.api.entity.IEnderDragon;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftLivingEntity;
import org.bukkit.entity.*;
import org.bukkit.entity.LivingEntity;

public class RunsafeEnderDragon extends RunsafeLivingEntity implements IEnderDragon
{
	public RunsafeEnderDragon(EnderDragon toWrap)
	{
		super(toWrap);
		dragon = toWrap;
	}

	private final EnderDragon dragon;
}
