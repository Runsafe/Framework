package no.runsafe.framework.internal.wrapper.item;

import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.IWrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class BukkitItemStack implements ConfigurationSerializable, IWrapper<ItemStack>
{
	protected BukkitItemStack(ItemStack stack)
	{
		itemStack = stack;
	}

	public Material getType()
	{
		return itemStack.getType();
	}

	public void setType(Material type)
	{
		itemStack.setType(type);
	}

	@Deprecated
	public int getItemId()
	{
		return LegacyMaterial.getIdOf(itemStack.getType());
	}

	@Deprecated
	public void setItemId(int type)
	{
		itemStack.setType(LegacyMaterial.getById(type));
	}

	public short getDurability()
	{
		return itemStack.getDurability();
	}

	@Override
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
		itemStack.setAmount(Math.max(0, itemStack.getAmount() - amount));
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

	@SuppressWarnings("InstanceofInterfaces")
	public boolean equals(Object obj)
	{
		if (obj instanceof BukkitItemStack)
			return itemStack.equals(((BukkitItemStack) obj).itemStack);

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
		Map<RunsafeEnchantment, Integer> enchants = new HashMap<RunsafeEnchantment, Integer>(bukkitEnchants.size());
		for (Map.Entry<Enchantment, Integer> enchantment : bukkitEnchants.entrySet())
			enchants.put(ObjectWrapper.convert(enchantment.getKey()), enchantment.getValue());
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
		return itemStack.serialize();
	}

	protected final ItemStack itemStack;
}
