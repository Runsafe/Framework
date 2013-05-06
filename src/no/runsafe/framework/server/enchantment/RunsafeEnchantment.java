package no.runsafe.framework.server.enchantment;

import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.Map;

public class RunsafeEnchantment
{
	public static final RunsafeEnchantment PROTECTION_ENVIRONMENTAL = new RunsafeEnchantmentWrapper(0);
	public static final RunsafeEnchantment PROTECTION_FIRE = new RunsafeEnchantmentWrapper(1);
	public static final RunsafeEnchantment PROTECTION_FALL = new RunsafeEnchantmentWrapper(2);
	public static final RunsafeEnchantment PROTECTION_EXPLOSIONS = new RunsafeEnchantmentWrapper(3);
	public static final RunsafeEnchantment PROTECTION_PROJECTILE = new RunsafeEnchantmentWrapper(4);
	public static final RunsafeEnchantment OXYGEN = new RunsafeEnchantmentWrapper(5);
	public static final RunsafeEnchantment WATER_WORKER = new RunsafeEnchantmentWrapper(6);
	public static final RunsafeEnchantment THORNS = new RunsafeEnchantmentWrapper(7);
	public static final RunsafeEnchantment DAMAGE_ALL = new RunsafeEnchantmentWrapper(16);
	public static final RunsafeEnchantment DAMAGE_UNDEAD = new RunsafeEnchantmentWrapper(17);
	public static final RunsafeEnchantment DAMAGE_ARTHROPODS = new RunsafeEnchantmentWrapper(18);
	public static final RunsafeEnchantment KNOCKBACK = new RunsafeEnchantmentWrapper(19);
	public static final RunsafeEnchantment FIRE_ASPECT = new RunsafeEnchantmentWrapper(20);
	public static final RunsafeEnchantment LOOT_BONUS_MOBS = new RunsafeEnchantmentWrapper(21);
	public static final RunsafeEnchantment DIG_SPEED = new RunsafeEnchantmentWrapper(32);
	public static final RunsafeEnchantment SILK_TOUCH = new RunsafeEnchantmentWrapper(33);
	public static final RunsafeEnchantment DURABILITY = new RunsafeEnchantmentWrapper(34);
	public static final RunsafeEnchantment LOOT_BONUS_BLOCKS = new RunsafeEnchantmentWrapper(35);
	public static final RunsafeEnchantment ARROW_DAMAGE = new RunsafeEnchantmentWrapper(48);
	public static final RunsafeEnchantment ARROW_KNOCKBACK = new RunsafeEnchantmentWrapper(49);
	public static final RunsafeEnchantment ARROW_FIRE = new RunsafeEnchantmentWrapper(50);
	public static final RunsafeEnchantment ARROW_INFINITE = new RunsafeEnchantmentWrapper(51);

	private static final Map<Integer, RunsafeEnchantment> byId = new HashMap<Integer, RunsafeEnchantment>();
	private static final Map<String, RunsafeEnchantment> byName = new HashMap<String, RunsafeEnchantment>();
	private final int id;

	public RunsafeEnchantment(Enchantment toWrap)
	{
		enchantment = toWrap;
		this.id = toWrap.getId();
	}

	public RunsafeEnchantment(int id)
	{
		this.id = id;
		this.enchantment = Enchantment.getById(id);
	}

	public int getId()
	{
		return this.id;
	}

	public String getName()
	{
		return enchantment.getName();
	}

	public int getMaxLevel()
	{
		return enchantment.getMaxLevel();
	}

	public int getStartLevel()
	{
		return enchantment.getStartLevel();
	}

//	public RunsafeEnchantmentTarget getItemTarget()
//	{
//		return ObjectWrapper.convert(enchantment.getItemTarget());
//	}

	public boolean conflictsWith(RunsafeEnchantment enchantment)
	{
		return this.enchantment.conflictsWith(enchantment.getRaw());
	}

	public boolean canEnchantItem(RunsafeItemStack itemStack)
	{
		return enchantment.canEnchantItem(itemStack.getRaw());
	}

	public Enchantment getRaw()
	{
		return enchantment;
	}

	private final Enchantment enchantment;
}
