package no.runsafe.framework.server.enchantment;

import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.enchantments.Enchantment;

public class RunsafeEnchantment
{
	public RunsafeEnchantment(Enchantment toWrap)
	{
		enchantment = toWrap;
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
