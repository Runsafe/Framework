package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.minecraft.IEnchant;
import no.runsafe.framework.api.minecraft.IEnchantable;
import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;
import org.bukkit.enchantments.Enchantment;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Enchant implements IEnchant
{
	public static final Collection<IEnchant> All = new ArrayList<IEnchant>(Enchantment.values().length);
	public static final IEnchant EnvironmentalProtection = new Enchant(Enchantment.PROTECTION_ENVIRONMENTAL, true);
	public static final IEnchant FireProtection = new Enchant(Enchantment.PROTECTION_FIRE, true);
	public static final IEnchant FallProtection = new Enchant(Enchantment.PROTECTION_FALL, true);
	public static final IEnchant ExplosionProtection = new Enchant(Enchantment.PROTECTION_EXPLOSIONS, true);
	public static final IEnchant ProjectileProtection = new Enchant(Enchantment.PROTECTION_PROJECTILE, true);
	public static final IEnchant WaterBreathing = new Enchant(Enchantment.OXYGEN, true);
	public static final IEnchant WaterWorker = new Enchant(Enchantment.WATER_WORKER, true);
	public static final IEnchant Thorns = new Enchant(Enchantment.THORNS, true);
	public static final IEnchant DepthStrider = new Enchant(Enchantment.DEPTH_STRIDER, true);
	public static final IEnchant FrostWalker = new Enchant(Enchantment.FROST_WALKER, true);
	public static final IEnchant Damage = new Enchant(Enchantment.DAMAGE_ALL, true);
	public static final IEnchant DamageUndead = new Enchant(Enchantment.DAMAGE_UNDEAD, true);
	public static final IEnchant DamageArthropods = new Enchant(Enchantment.DAMAGE_ARTHROPODS, true);
	public static final IEnchant SweepingEdge = new Enchant(Enchantment.SWEEPING_EDGE, true);
	public static final IEnchant Knockback = new Enchant(Enchantment.KNOCKBACK, true);
	public static final IEnchant Fire = new Enchant(Enchantment.FIRE_ASPECT, true);
	public static final IEnchant MobLoot = new Enchant(Enchantment.LOOT_BONUS_MOBS, true);
	public static final IEnchant DigSpeed = new Enchant(Enchantment.DIG_SPEED, true);
	public static final IEnchant SilkTouch = new Enchant(Enchantment.SILK_TOUCH, true);
	public static final IEnchant Durability = new Enchant(Enchantment.DURABILITY, true);
	public static final IEnchant BlockLoot = new Enchant(Enchantment.LOOT_BONUS_BLOCKS, true);
	public static final IEnchant ArrowDamage = new Enchant(Enchantment.ARROW_DAMAGE, true);
	public static final IEnchant KnockbackArrow = new Enchant(Enchantment.ARROW_KNOCKBACK, true);
	public static final IEnchant FlameArrow = new Enchant(Enchantment.ARROW_FIRE, true);
	public static final IEnchant InfiniteArrows = new Enchant(Enchantment.ARROW_INFINITE, true);
	public static final IEnchant Lure = new Enchant(Enchantment.LURE, true);
	public static final IEnchant Luck = new Enchant(Enchantment.LUCK, true);
	public static final IEnchant Mending = new Enchant(Enchantment.MENDING, true);
	public static final IEnchant BindingCurse = new Enchant(Enchantment.BINDING_CURSE, true);
	public static final IEnchant VanishingCurse = new Enchant(Enchantment.VANISHING_CURSE, true);

	@Nullable
	public static IEnchant getByName(String name)
	{
		for (Enchantment enchantType : Enchantment.values())
			if (enchantType.getName().equalsIgnoreCase(name))
				return new Enchant(enchantType, false);
		return null;
	}

	public static List<IEnchant> getByTarget(IEnchantable target)
	{
		List<IEnchant> enchants = new ArrayList<IEnchant>(All.size());
		for (IEnchant enchant : All)
			if (enchant.canEnchant(target))
				enchants.add(enchant);
		return enchants;
	}

	@Override
	public IEnchant power(int power)
	{
		if (root)
			return copy().power(power);
		this.power = power;
		return this;
	}

	@Override
	public IEnchant max()
	{
		if (root)
			return copy().max();
		power = getMaxLevel();
		return this;
	}

	@Override
	public int getId()
	{
		return type.getId();
	}

	@Override
	public String getName()
	{
		return type.getName();
	}

	@Override
	public final int getMaxLevel()
	{
		return enchant.getMaxLevel();
	}

	@Override
	public int getStartLevel()
	{
		return enchant.getStartLevel();
	}

	@Override
	public boolean isOn(IEnchantable target)
	{
		return target != null && target.enchanted(this);
	}

	@Override
	public boolean canCoexist(IEnchant enchantment)
	{
		return enchant.compatibleWith(enchantment);
	}

	@Override
	public boolean canEnchant(IEnchantable target)
	{
		return target != null && enchant.canEnchantItem(target);
	}

	@Override
	public IEnchant applyTo(IEnchantable target)
	{
		target.enchant(this);
		return this;
	}

	@Override
	public int power()
	{
		return Math.max(getStartLevel(), Math.min(getMaxLevel(), power));
	}

	@Override
	public RunsafeEnchantment getEnchant()
	{
		return enchant;
	}

	private Enchant(Enchantment type, boolean root)
	{
		enchant = new RunsafeEnchantment(type);
		this.type = type;
		this.root = root;
		power = getMaxLevel();
		if (root)
			//noinspection ThisEscapedInObjectConstruction
			All.add(this);
	}

	private IEnchant copy()
	{
		return new Enchant(type, false);
	}

	private final Enchantment type;
	private final RunsafeEnchantment enchant;
	private final boolean root;
	private int power;
}
