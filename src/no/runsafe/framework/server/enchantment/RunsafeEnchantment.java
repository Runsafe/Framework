package no.runsafe.framework.server.enchantment;

import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;

public class RunsafeEnchantment
{
	public RunsafeEnchantment(EnchantmentWrapper toWrap)
	{
		this.enchantment = toWrap;
	}

	public RunsafeEnchantment(Enchantment enchantment)
	{
		this.enchantment = new EnchantmentWrapper(enchantment.getId());
	}

	public RunsafeEnchantment(RunsafeEnchantmentType enchantType)
	{
		this.enchantment = new EnchantmentWrapper(enchantType.ordinal());
	}

	public RunsafeEnchantment(int id)
	{
		this.enchantment = new EnchantmentWrapper(id);
	}

	public int getId()
	{
		return this.enchantment.getId();
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

	public boolean conflictsWith(RunsafeEnchantment enchantment)
	{
		return this.enchantment.conflictsWith(enchantment.getRaw());
	}

	public boolean canEnchantItem(RunsafeItemStack itemStack)
	{
		return this.enchantment.canEnchantItem(itemStack.getRaw());
	}

	public Enchantment getRaw()
	{
		return this.enchantment;
	}

	private final EnchantmentWrapper enchantment;
}
