package no.runsafe.framework.internal.wrapper.enchantment;

import no.runsafe.framework.api.minecraft.IEnchant;
import no.runsafe.framework.api.minecraft.IEnchantable;
import no.runsafe.framework.internal.wrapper.item.BukkitItemStack;
import org.bukkit.enchantments.Enchantment;

public abstract class BukkitEnchantment
{
	protected BukkitEnchantment(Enchantment toWrap)
	{
		enchantment = toWrap;
	}

	protected BukkitEnchantment(int id)
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

	@SuppressWarnings("CastToConcreteClass")
	public boolean canEnchantItem(IEnchantable target)
	{
		return enchantment.canEnchantItem(((BukkitItemStack) target).getRaw());
	}

	public Enchantment getRaw()
	{
		return enchantment;
	}

	protected final Enchantment enchantment;
}
