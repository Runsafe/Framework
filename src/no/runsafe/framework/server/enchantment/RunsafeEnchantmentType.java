package no.runsafe.framework.server.enchantment;

@Deprecated
public enum RunsafeEnchantmentType
{
	PROTECTION_ENVIRONMENTAL(0),
	PROTECTION_FIRE(1),
	PROTECTION_FALL(2),
	PROTECTION_EXPLOSIONS(3),
	PROTECTION_PROJECTILE(4),
	OXYGEN(5),
	WATER_WORKER(6),
	THORNS(7),
	DAMAGE_ALL(16),
	DAMAGE_UNDEAD(17),
	DAMAGE_ARTHROPODS(18),
	KNOCKBACK(19),
	FIRE_ASPECT(20),
	LOOT_BONUS_MOBS(21),
	DIG_SPEED(32),
	SILK_TOUCH(33),
	DURABILITY(34),
	LOOT_BONUS_BLOCKS(35),
	ARROW_DAMAGE(48),
	ARROW_KNOCKBACK(49),
	ARROW_FIRE(50),
	ARROW_INFINITE(51);

	private final int id;

	private RunsafeEnchantmentType(int id)
	{
		this.id = id;
	}

	public int getEnchantId()
	{
		return this.id;
	}
}
