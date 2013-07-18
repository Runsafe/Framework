package no.runsafe.framework.internal.wrapper.enchantment;

import no.runsafe.framework.api.minecraft.IEnchant;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.enchantments.Enchantment;

public abstract class BukkitEnchantment
{
	protected BukkitEnchantment(Enchantment toWrap)
	{
		enchantment = toWrap;
	}

	public BukkitEnchantment(int id)
	{
		enchantment = Enchantment.getById(id);
	}

	public int getId()
	{
		return enchantment.getId();
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

	@Deprecated
	public boolean conflictsWith(IEnchant enchantment)
	{
		return !compatibleWith(enchantment);
	}

	public boolean compatibleWith(IEnchant enchantment)
	{
		return !this.enchantment.conflictsWith(enchantment.getEnchant().getRaw());
	}

	public boolean canEnchantItem(RunsafeMeta target)
	{
		return enchantment.canEnchantItem(target.getRaw());
	}

	public Enchantment getRaw()
	{
		return enchantment;
	}

	protected final Enchantment enchantment;
}
