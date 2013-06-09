package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class BukkitMeta extends RunsafeItemStack
{
	public BukkitMeta(ItemStack stack)
	{
		super(stack);
	}
	
	public ItemMeta getRawMeta()
	{
		return itemStack.getItemMeta();
	}

	public boolean hasEnchants()
	{
		return getRawMeta().hasEnchants();
	}

	public boolean hasEnchant(RunsafeEnchantment ench)
	{
		return getRawMeta().hasEnchant(ench.getRaw());
	}

	public int getEnchantLevel(RunsafeEnchantment ench)
	{
		return getRawMeta().getEnchantLevel(ench.getRaw());
	}

	public boolean addEnchant(RunsafeEnchantment ench, int level, boolean ignoreLevelRestriction)
	{
		ItemMeta meta = getRawMeta();
		boolean success = meta.addEnchant(ench.getRaw(), level, ignoreLevelRestriction);
		if (success)
			itemStack.setItemMeta(meta);
		return success;
	}

	public boolean removeEnchant(RunsafeEnchantment ench)
	{
		ItemMeta meta = getRawMeta();
		boolean success = meta.removeEnchant(ench.getRaw());
		if (success)
			itemStack.setItemMeta(meta);
		return success;
	}

	public boolean hasDisplayName()
	{
		return getRawMeta().hasDisplayName();
	}

	public String getDisplayName()
	{
		return getRawMeta().getDisplayName();
	}

	public BukkitMeta setDisplayName(String name)
	{
		ItemMeta meta = getRawMeta();
		meta.setDisplayName(name);
		itemStack.setItemMeta(meta);
		return this;
	}

	public boolean hasLore()
	{
		return getRawMeta().hasLore();
	}

	public List<String> getLore()
	{
		return getRawMeta().getLore();
	}

	public BukkitMeta addLore(String lore)
	{
		ItemMeta meta = getRawMeta();
		List<String> currentLore = meta.getLore();
		if (currentLore == null)
			currentLore = new ArrayList<String>();
		currentLore.add(lore);
		meta.setLore(currentLore);
		itemStack.setItemMeta(meta);
		return this;
	}

	public BukkitMeta setLore(List<String> lore)
	{
		ItemMeta meta = getRawMeta();
		meta.setLore(lore);
		itemStack.setItemMeta(meta);
		return this;
	}
}
