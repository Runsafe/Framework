package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorldEffect;
import no.runsafe.framework.minecraft.WorldBlockEffect;
import org.bukkit.material.MaterialData;

public class PacketWorldParticle extends RunsafePacket
{
	@SuppressWarnings("NumericCastThatLosesPrecision")
	public PacketWorldParticle(IWorldEffect effect, ILocation location, WorldParticleOffset offset, float speed, int amount)
	{
		//Set item values if needed.
		int[] itemValues;
		if(effect instanceof WorldBlockEffect)
		{
			WorldBlockEffect blockEffect = (WorldBlockEffect) effect;
			MaterialData data = blockEffect.getBlock().getData().getRaw();

			// There is no obvious alternative to these deprecated methods
			itemValues = new int[]{data.getItemType().getId(), data.getData()};
		}
		else
			itemValues = new int[0];

		setPacket(
			new PacketPlayOutWorldParticles(
				effect.getBukkitParticle(),
				true,
				(float) location.getX(),
				(float) location.getY(),
				(float) location.getZ(),
				offset.getX(),
				offset.getY(),
				offset.getZ(),
				speed,
				amount,
				itemValues
			)
		);
	}
}
