package no.runsafe.framework.server.enchantment;

import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.enchantments.Enchantment;

public class RunsafeEnchantment
{
	public RunsafeEnchantment(Enchantment toWrap)
	{
		enchantment = toWrap;
	}

	public RunsafeEnchantment(RunsafeEnchantmentType enchantType)
	{
		this.enchantment = Enchantment.getById(enchantType.getID());
	}

	public RunsafeEnchantment(int id)
	{
		this.enchantment = Enchantment.getById(id);
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
		return enchantment.canEnchantItem(itemStack.getRaw());
	}

	public Enchantment getRaw()
	{
		return enchantment;
	}

	private final Enchantment enchantment;
}
