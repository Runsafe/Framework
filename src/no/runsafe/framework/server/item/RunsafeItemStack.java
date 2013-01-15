package no.runsafe.framework.server.item;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.server.enchantment.RunsafeEnchantmentWrapper;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.server.material.RunsafeMaterialData;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.*;

public class RunsafeItemStack
{
	public RunsafeItemStack(ItemStack stack)
	{
		itemStack = stack;
	}

	public RunsafeItemStack(int itemId)
	{
		itemStack = new ItemStack(itemId);
	}

	public RunsafeItemStack(RunsafeMaterial material)
	{
		itemStack = new ItemStack(material.getRaw());
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

	public boolean containsEnchantment(RunsafeEnchantmentWrapper enchantmentWrapper)
	{
		return itemStack.containsEnchantment(enchantmentWrapper.getRaw());
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

	public String serialize()
	{
		return String.format(
			"%s:%s:%s:%s:%s:%s",
			itemStack.getTypeId(),
			itemStack.getAmount(),
			itemStack.getDurability(),
			itemStack.getData().getData(),
			flattenEnchants(itemStack.getEnchantments()),
			hasItemMeta() ? getItemMeta().serialize() : "0"
		);
	}

	public static RunsafeItemStack deserialize(String itemString)
	{
		String[] itemData = itemString.split(":");
		int itemID = Integer.parseInt(itemData[0]);
		ItemStack itemStack = new ItemStack(itemID);
		itemStack.setAmount(Integer.parseInt(itemData[1]));
		itemStack.setDurability(Short.parseShort(itemData[2]));
		itemStack.setData(new MaterialData(itemID, Byte.parseByte(itemData[3])));

		// Backwards compatibility check
		if (itemData.length > 4 && !itemData[4].equals("0"))
			itemStack.addEnchantments(unpackEnchants(itemData[4]));

		if (itemData.length > 5 && !itemData[5].equals("0"))
			itemStack.setItemMeta(RunsafeItemMeta.deserialize(itemData[5]));

		return new RunsafeItemStack(itemStack);
	}

	private static String flattenEnchants(Map<Enchantment, Integer> enchants)
	{
		if (!enchants.isEmpty())
		{
			ArrayList<String> enchantStrings = new ArrayList<String>();
			Set<Enchantment> enchantKeys = enchants.keySet();

			for (Enchantment theEnchant : enchantKeys)
			{
				int enchantData = enchants.get(theEnchant);
				enchantStrings.add(String.format("%s#%s", theEnchant.getId(), enchantData));
			}

			return StringUtils.join(enchantStrings, "@");
		}
		else
		{
			return "0";
		}
	}

	private static Map<Enchantment, Integer> unpackEnchants(String enchantString)
	{
		Map<Enchantment, Integer> returnEnchants = new HashMap<Enchantment, Integer>();
		String enchantSplit[] = enchantString.split("@");
		for (String anEnchantSplit : enchantSplit)
		{
			String enchantData[] = anEnchantSplit.split("#");
			Enchantment enchant = new EnchantmentWrapper(Integer.parseInt(enchantData[0]));
			returnEnchants.put(enchant, Integer.parseInt(enchantData[1]));
		}

		return returnEnchants;
	}

	private final ItemStack itemStack;
}
