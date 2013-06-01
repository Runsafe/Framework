package no.runsafe.framework.server.enchantment;

import no.runsafe.framework.enchant.IEnchant;
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
		this.enchantment = Enchantment.getById(enchantType.getEnchantId());
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

	public boolean conflictsWith(IEnchant enchantment)
	{
		return this.enchantment.conflictsWith(enchantment.getEnchant().getRaw());
	}

	public boolean canEnchantItem(RunsafeItemStack target)
	{
		return this.enchantment.canEnchantItem(target.getRaw());
	}

	public Enchantment getRaw()
	{
		return this.enchantment;
	}

	private final Enchantment enchantment;
}
