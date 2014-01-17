package no.runsafe.framework.minecraft.data;

public enum EntityEffect
{
	DEATH(org.bukkit.EntityEffect.DEATH),
	HURT(org.bukkit.EntityEffect.HURT),
	SHEEP_EAT(org.bukkit.EntityEffect.SHEEP_EAT),
	WOLF_HEARTS(org.bukkit.EntityEffect.WOLF_HEARTS),
	WOLF_SHAKE(org.bukkit.EntityEffect.WOLF_SHAKE),
	WOLF_SMOKE(org.bukkit.EntityEffect.WOLF_SMOKE);

	EntityEffect(org.bukkit.EntityEffect toWrap)
	{
		effect = toWrap;
	}

	public org.bukkit.EntityEffect toBukkit()
	{
		return effect;
	}

	public static EntityEffect fromBukkit(org.bukkit.EntityEffect bukkitEffect)
	{
		for (EntityEffect check : values())
			if (check.toBukkit() == bukkitEffect)
				return check;

		return HURT; // Most sane default.
	}

	private final org.bukkit.EntityEffect effect;
}
