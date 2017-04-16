package no.runsafe.framework.minecraft;

import net.minecraft.server.v1_8_R3.EnumParticle;
import no.runsafe.framework.api.IWorldEffect;

public enum WorldEffect implements IWorldEffect
{
	HUGE_EXPLOSION("hugeexplosion", EnumParticle.EXPLOSION_LARGE),
	LARGE_EXPLODE("largeexplode", EnumParticle.EXPLOSION_LARGE),
	FIREWORKS_SPARK("fireworksSpark", EnumParticle.FIREWORKS_SPARK),
	BUBBLE("bubble", EnumParticle.WATER_BUBBLE),
	SUSPEND("suspended", EnumParticle.SUSPENDED),
	DEPTH_SUSPEND("depthsuspend", EnumParticle.SUSPENDED_DEPTH),
	TOWN_AURA("townaura", EnumParticle.TOWN_AURA),
	CRIT("crit", EnumParticle.CRIT),
	MAGIC_CRIT("magicCrit", EnumParticle.CRIT_MAGIC),
	SMOKE("smoke", EnumParticle.SMOKE_NORMAL),
	MOB_SPELL("mobSpell", EnumParticle.SPELL_MOB),
	MOB_SPELL_AMBIENT("mobSpellAmbient", EnumParticle.SPELL_MOB_AMBIENT),
	SPELL("spell", EnumParticle.SPELL),
	INSTANT_SPELL("instantSpell", EnumParticle.SPELL_INSTANT),
	WITCH_MAGIC("witchMagic", EnumParticle.SPELL_WITCH),
	NOTE("note", EnumParticle.NOTE),
	PORTAL("portal", EnumParticle.PORTAL),
	ENCHANTMENT_TABLE("enchantmenttable", EnumParticle.ENCHANTMENT_TABLE),
	EXPLODE("explode", EnumParticle.EXPLOSION_NORMAL),
	FLAME("flame", EnumParticle.FLAME),
	LAVA("lava", EnumParticle.LAVA),
	FOOTSTEP("footstep", EnumParticle.FOOTSTEP),
	SPLASH("splash", EnumParticle.WATER_SPLASH),
	WAKE("wake", EnumParticle.WATER_WAKE),
	LARGE_SMOKE("largesmoke", EnumParticle.SMOKE_LARGE),
	CLOUD("cloud", EnumParticle.CLOUD),
	RED_DUST("reddust", EnumParticle.REDSTONE),
	SNOWBALL_POOF("snowballpoof", EnumParticle.SNOWBALL),
	DRIP_WATER("dripWater", EnumParticle.DRIP_WATER),
	DRIP_LAVA("dripLava", EnumParticle.DRIP_LAVA),
	SNOW_SHOVEL("snowshovel", EnumParticle.SNOW_SHOVEL),
	SLIME("slime", EnumParticle.SLIME),
	HEART("heart", EnumParticle.HEART),
	ANGRY_VILLAGER("angryVillager", EnumParticle.VILLAGER_ANGRY),
	HAPPY_VILLAGER("happyVillager", EnumParticle.VILLAGER_HAPPY),
	ICON_CRACK("iconcrack_", EnumParticle.ITEM_CRACK),
	TILE_CRACK("tilecrack_", EnumParticle.BLOCK_CRACK),
	BLOCK_DUST("blockdust_", EnumParticle.BLOCK_DUST);

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
