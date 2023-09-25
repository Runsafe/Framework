package no.runsafe.framework.minecraft;

import net.minecraft.server.v1_12_R1.EnumParticle;
import no.runsafe.framework.api.IWorldEffect;

public enum WorldEffect implements IWorldEffect
{
	EXPLODE("explode", EnumParticle.EXPLOSION_NORMAL),
	HUGE_EXPLOSION("hugeexplosion", EnumParticle.EXPLOSION_LARGE),
	LARGE_EXPLODE("largeexplode", EnumParticle.EXPLOSION_LARGE),
	FIREWORKS_SPARK("fireworksSpark", EnumParticle.FIREWORKS_SPARK),
	BUBBLE("bubble", EnumParticle.WATER_BUBBLE),
	SPLASH("splash", EnumParticle.WATER_SPLASH),
	WAKE("wake", EnumParticle.WATER_WAKE),
	SUSPEND("suspended", EnumParticle.SUSPENDED),
	DEPTH_SUSPEND("depthsuspend", EnumParticle.SUSPENDED_DEPTH),
	CRIT("crit", EnumParticle.CRIT),
	MAGIC_CRIT("magicCrit", EnumParticle.CRIT_MAGIC),
	SMOKE("smoke", EnumParticle.SMOKE_NORMAL),
	LARGE_SMOKE("largesmoke", EnumParticle.SMOKE_LARGE),
	SPELL("spell", EnumParticle.SPELL),
	INSTANT_SPELL("instantSpell", EnumParticle.SPELL_INSTANT),
	MOB_SPELL("mobSpell", EnumParticle.SPELL_MOB),
	MOB_SPELL_AMBIENT("mobSpellAmbient", EnumParticle.SPELL_MOB_AMBIENT),
	WITCH_MAGIC("witchMagic", EnumParticle.SPELL_WITCH),
	DRIP_WATER("dripWater", EnumParticle.DRIP_WATER),
	DRIP_LAVA("dripLava", EnumParticle.DRIP_LAVA),
	ANGRY_VILLAGER("angryVillager", EnumParticle.VILLAGER_ANGRY),
	HAPPY_VILLAGER("happyVillager", EnumParticle.VILLAGER_HAPPY),
	TOWN_AURA("townaura", EnumParticle.TOWN_AURA),
	NOTE("note", EnumParticle.NOTE),
	PORTAL("portal", EnumParticle.PORTAL),
	ENCHANTMENT_TABLE("enchantmenttable", EnumParticle.ENCHANTMENT_TABLE),
	FLAME("flame", EnumParticle.FLAME),
	LAVA("lava", EnumParticle.LAVA),
	FOOTSTEP("footstep", EnumParticle.FOOTSTEP),
	CLOUD("cloud", EnumParticle.CLOUD),
	RED_DUST("reddust", EnumParticle.REDSTONE),
	SNOWBALL_POOF("snowballpoof", EnumParticle.SNOWBALL),
	SNOW_SHOVEL("snowshovel", EnumParticle.SNOW_SHOVEL),
	SLIME("slime", EnumParticle.SLIME),
	HEART("heart", EnumParticle.HEART),
	BARRIER("barrier", EnumParticle.BARRIER),
	ICON_CRACK("iconcrack_", EnumParticle.ITEM_CRACK),
	TILE_CRACK("tilecrack_", EnumParticle.BLOCK_CRACK),
	BLOCK_DUST("blockdust_", EnumParticle.BLOCK_DUST),
	WATER_DROP("droplet", EnumParticle.WATER_DROP),
	ITEM_TAKE("take", EnumParticle.ITEM_TAKE),
	GUARDIAN_POPUP("mobappearance", EnumParticle.MOB_APPEARANCE);

	WorldEffect(String name, EnumParticle particle)
	{
		this.name = name;
		this.particle = particle;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public EnumParticle getBukkitParticle()
	{
		return particle;
	}
	private final String name;
	private final EnumParticle particle;
}
