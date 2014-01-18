package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_7_R1.PacketPlayOutWorldParticles;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorldEffect;

public class PacketWorldParticle extends RunsafePacket
{
	@SuppressWarnings("NumericCastThatLosesPrecision")
	public PacketWorldParticle(IWorldEffect effect, ILocation location, WorldParticleOffset offset, float speed, int amount)
	{
		setPacket(
			new PacketPlayOutWorldParticles(
				effect.getName(),
				(float) location.getX(),
				(float) location.getY(),
				(float) location.getZ(),
				offset.getX(),
				offset.getY(),
				offset.getZ(),
				speed,
				amount
			)
		);
	}
}
