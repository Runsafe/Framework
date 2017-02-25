package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_8_R3.EnumParticle;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorldEffect;

public class PacketWorldParticle extends RunsafePacket
{
	@SuppressWarnings("NumericCastThatLosesPrecision")
	public PacketWorldParticle(IWorldEffect effect, ILocation location, WorldParticleOffset offset, float speed, int amount)
	{
		setPacket(
			new PacketPlayOutWorldParticles(
				EnumParticle.valueOf(effect.getName()),
				true,
				(float) location.getX(),
				(float) location.getY(),
				(float) location.getZ(),
				offset.getX(),
				offset.getY(),
				offset.getZ(),
				speed,
				amount,
				0
			)
		);
	}
}
