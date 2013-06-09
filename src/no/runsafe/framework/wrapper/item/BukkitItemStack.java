package no.runsafe.framework.wrapper.item;

import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.server.material.RunsafeMaterialData;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class BukkitItemStack implements ConfigurationSerializable
{
	public BukkitItemStack(ItemStack stack)
	{
		itemStack = stack;
	}

	public Material getType()
	{
		return this.itemStack.getType();
	}

	public void setType(Material type)
	{
		this.itemStack.setType(type);
	}

	public int getItemId()
	{
		return itemStack.getTypeId();
	}

	public void setItemId(int type)
	{
		itemStack.setTypeId(type);
	}

	public short getDurability()
	{
		return itemStack.getDurability();
	}

	public ItemStack getRaw()
	{
		return itemStack;
	}

	public int getAmount()
	{
		return itemStack.getAmount();
	}

	public void setAmount(int amount)
	{
		itemStack.setAmount(amount);
	}

	public void remove(int amount)
	{
		if (itemStack.getAmount() > amount)
			itemStack.setAmount(itemStack.getAmount() - amount);
		else
			itemStack.setAmount(0);
	}

	public RunsafeMaterialData getData()
	{
		return ObjectWrapper.convert(itemStack.getData());
	}

	public void setData(RunsafeMaterialData data)
	{
		itemStack.setData(data.getRaw());
	}

	public void setDurability(short durability)
	{
		itemStack.setDurability(durability);
	}

	public int getMaxStackSize()
	{
		return itemStack.getMaxStackSize();
	}

	public boolean equals(Object obj)
	{
		if (obj instanceof BukkitItemStack)
			return itemStack.equals(((BukkitItemStack) obj).getRaw());

		return obj instanceof ItemStack && itemStack.equals(obj);
	}

	public final int hashCode()
	{
		return itemStack.hashCode();
	}

	public boolean containsEnchantment(RunsafeEnchantment ench)
	{
		return itemStack.containsEnchantment(ench.getRaw());
	}

	public int getEnchantmentLevel(RunsafeEnchantment ench)
	{
		return itemStack.getEnchantmentLevel(ench.getRaw());
	}

	public Map<RunsafeEnchantment, Integer> getEnchantments()
	{
		Map<Enchantment, Integer> bukkitEnchants = itemStack.getEnchantments();
		HashMap<RunsafeEnchantment, Integer> enchants = new HashMap<RunsafeEnchantment, Integer>();
		for (Enchantment ench : bukkitEnchants.keySet())
			enchants.put(ObjectWrapper.convert(ench), bukkitEnchants.get(ench));
		return enchants;
	}

	public void addEnchantment(RunsafeEnchantment ench, int level)
	{
		itemStack.addEnchantment(ench.getRaw(), level);
	}

	public void addUnsafeEnchantment(RunsafeEnchantment ench, int level)
	{
		itemStack.addUnsafeEnchantment(ench.getRaw(), level);
	}

	public int removeEnchantment(RunsafeEnchantment ench)
	{
		return itemStack.removeEnchantment(ench.getRaw());
	}

	public boolean hasItemMeta()
	{
		return itemStack.hasItemMeta();
	}

	@Override
	public Map<String, Object> serialize()
	{
		return this.itemStack.serialize();
	}

	protected final ItemStack itemStack;
}
