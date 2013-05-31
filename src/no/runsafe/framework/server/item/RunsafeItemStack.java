package no.runsafe.framework.server.item;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.server.enchantment.RunsafeEnchantmentType;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.server.material.RunsafeMaterialData;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class RunsafeItemStack implements ConfigurationSerializable
{
	public RunsafeItemStack(ItemStack stack)
	{
		itemStack = stack;
	}

	public RunsafeItemStack(int itemId)
	{
		itemStack = new ItemStack(itemId);
	}

	public RunsafeItemStack(int itemId, int amount)
	{
		itemStack = new ItemStack(itemId, amount);
	}

	public RunsafeItemStack(RunsafeMaterial material)
	{
		itemStack = new ItemStack(material.getRaw());
	}

	public RunsafeItemStack(RunsafeMaterial material, int amount)
	{
		itemStack = new ItemStack(material.getRaw(), amount);
	}

	public RunsafeItemStack(int materialId, int amount, short durability)
	{
		itemStack = new ItemStack(materialId, amount, durability);
	}

	public RunsafeItemStack(int materialId, int amount, short durability, Byte data)
	{
		itemStack = new ItemStack(materialId, amount, durability);
		itemStack.setData(new MaterialData(Material.getMaterial(materialId), data));
	}

	public Material getType()
	{
		return this.itemStack.getType();
	}

	public void setType(Material type)
	{
		this.itemStack.setType(type);
	}

	public String getNormalName()
	{
		return this.getType().name().replace("_", " ").toLowerCase();
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

	public static List<RunsafeItemStack> convert(ItemStack[] armorContents)
	{
		ArrayList<RunsafeItemStack> result = new ArrayList<RunsafeItemStack>();
		for (ItemStack item : armorContents)
			result.add(new RunsafeItemStack(item));
		return result;
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
		return itemStack.equals(obj);
	}

	public RunsafeItemStack clone()
	{
		return new RunsafeItemStack(itemStack.clone());
	}

	public final int hashCode()
	{
		return itemStack.hashCode();
	}

	public boolean containsEnchantment(RunsafeEnchantment ench)
	{
		return itemStack.containsEnchantment(ench.getRaw());
	}

	public boolean containsEnchantment(RunsafeEnchantmentType type)
	{
		return itemStack.containsEnchantment(Enchantment.getById(type.getEnchantId()));
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

	public RunsafeItemMeta getItemMeta()
	{
		return ObjectWrapper.convert(itemStack.getItemMeta());
	}

	public boolean hasItemMeta()
	{
		return itemStack.hasItemMeta();
	}

	public boolean setItemMeta(RunsafeItemMeta itemMeta)
	{
		return itemStack.setItemMeta(itemMeta.getRaw());
	}

	@Override
	public Map<String, Object> serialize()
	{
		return this.itemStack.serialize();
	}

	public static RunsafeItemStack deserialize(Map<String, Object> args)
	{
		return ObjectWrapper.convert(ItemStack.deserialize(args));
	}

	private final ItemStack itemStack;
}
