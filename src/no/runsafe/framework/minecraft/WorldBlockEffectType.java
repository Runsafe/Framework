package no.runsafe.framework.minecraft;

import net.minecraft.server.v1_12_R1.EnumParticle;

public enum WorldBlockEffectType
{
	IRON_CRACK("ironcrack_", EnumParticle.ITEM_CRACK),
	BLOCK_CRACK("blockcrack_", EnumParticle.BLOCK_CRACK),
	BLOCK_DUST("blockdust_", EnumParticle.BLOCK_DUST);

	WorldBlockEffectType(String name, EnumParticle particle)
	{
		this.name = name;
		this.particle = particle;
	}

	public String getName()
	{
		return name;
	}

	public EnumParticle getBukkitParticle()
	{
		return particle;
	}

	private final EnumParticle particle;
	private final String name;
}
