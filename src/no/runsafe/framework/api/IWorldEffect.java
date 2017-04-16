package no.runsafe.framework.api;

import net.minecraft.server.v1_8_R3.EnumParticle;

public interface IWorldEffect
{
	String getName();

	EnumParticle getBukkitParticle();
}
