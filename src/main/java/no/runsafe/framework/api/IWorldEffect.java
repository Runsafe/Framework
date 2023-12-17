package no.runsafe.framework.api;

import net.minecraft.server.v1_12_R1.EnumParticle;

public interface IWorldEffect
{
	String getName();

	EnumParticle getBukkitParticle();
}
