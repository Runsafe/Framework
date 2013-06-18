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

	public boolean canEnchantItem(RunsafeMeta target)
	{
		return this.enchantment.canEnchantItem(target.getRaw());
	}

	public Enchantment getRaw()
	{
		return this.enchantment;
	}

	protected final Enchantment enchantment;
}
