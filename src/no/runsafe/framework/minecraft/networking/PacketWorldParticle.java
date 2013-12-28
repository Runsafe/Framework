package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_7_R1.PacketPlayOutWorldParticles;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.minecraft.WorldEffect;

public class PacketWorldParticle extends RunsafePacket
{
	@SuppressWarnings("NumericCastThatLosesPrecision")
	public PacketWorldParticle(WorldEffect effect, ILocation location, WorldParticleOffset offset, int speed, int amount)
	{
		packet = new PacketPlayOutWorldParticles(
				effect.getName(),
				(float) location.getX(),
				(float) location.getY(),
				(float) location.getZ(),
				offset.getX(),
				offset.getY(),
				offset.getZ(),
				speed,
				amount
		);
	}
}
