package no.runsafe.framework.server.enchantment;

import java.util.ArrayList;
import java.util.List;

public class RunsafeEnchantmentType
{
	public static final RunsafeEnchantmentType PROTECTION_ENVIRONMENTAL = new RunsafeEnchantmentType(0);
	public static final RunsafeEnchantmentType PROTECTION_FIRE = new RunsafeEnchantmentType(1);
	public static final RunsafeEnchantmentType PROTECTION_FALL = new RunsafeEnchantmentType(2);
	public static final RunsafeEnchantmentType PROTECTION_EXPLOSIONS = new RunsafeEnchantmentType(3);
	public static final RunsafeEnchantmentType PROTECTION_PROJECTILE = new RunsafeEnchantmentType(4);
	public static final RunsafeEnchantmentType OXYGEN = new RunsafeEnchantmentType(5);
	public static final RunsafeEnchantmentType WATER_WORKER = new RunsafeEnchantmentType(6);
	public static final RunsafeEnchantmentType THORNS = new RunsafeEnchantmentType(7);
	public static final RunsafeEnchantmentType DAMAGE_ALL = new RunsafeEnchantmentType(8);
	public static final RunsafeEnchantmentType DAMAGE_UNDEAD = new RunsafeEnchantmentType(9);
	public static final RunsafeEnchantmentType DAMAGE_ARTHROPODS = new RunsafeEnchantmentType(10);
	public static final RunsafeEnchantmentType KNOCKBACK = new RunsafeEnchantmentType(11);
	public static final RunsafeEnchantmentType FIRE_ASPECT = new RunsafeEnchantmentType(12);
	public static final RunsafeEnchantmentType LOOT_BONUS_MOBS = new RunsafeEnchantmentType(13);
	public static final RunsafeEnchantmentType DIG_SPEED = new RunsafeEnchantmentType(14);
	public static final RunsafeEnchantmentType SILK_TOUCH = new RunsafeEnchantmentType(15);
	public static final RunsafeEnchantmentType DURABILITY = new RunsafeEnchantmentType(16);
	public static final RunsafeEnchantmentType LOOT_BONUS_BLOCKS = new RunsafeEnchantmentType(17);
	public static final RunsafeEnchantmentType ARROW_DAMAGE = new RunsafeEnchantmentType(18);
	public static final RunsafeEnchantmentType ARROW_KNOCKBACK = new RunsafeEnchantmentType(19);
	public static final RunsafeEnchantmentType ARROW_FIRE = new RunsafeEnchantmentType(20);
	public static final RunsafeEnchantmentType ARROW_INFINITE = new RunsafeEnchantmentType(21);

	public RunsafeEnchantmentType(int enchantID)
	{
		this.enchantID = enchantID;
		RunsafeEnchantmentType.enchants.add(enchantID);
	}

	public int getID()
	{
		return this.enchantID;
	}

	private int enchantID;
	public static List<Integer> enchants = new ArrayList<Integer>();
}
