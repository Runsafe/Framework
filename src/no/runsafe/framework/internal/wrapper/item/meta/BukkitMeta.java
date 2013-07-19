package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;
import no.runsafe.framework.minecraft.item.RunsafeItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class BukkitMeta extends RunsafeItemStack
{
	protected BukkitMeta(ItemStack stack)
	{
		super(stack);
	}

	public ItemMeta getRawMeta()
	{
		return itemStack.getItemMeta();
	}

	public boolean hasEnchants()
	{
		ItemMeta meta = getRawMeta();
		return meta != null && meta.hasEnchants();
	}

	public boolean hasEnchant(RunsafeEnchantment ench)
	{
		ItemMeta meta = getRawMeta();
		return meta != null && meta.hasEnchant(ench.getRaw());
	}

	public int getEnchantLevel(RunsafeEnchantment ench)
	{
		ItemMeta meta = getRawMeta();
		return meta == null ? -1 : meta.getEnchantLevel(ench.getRaw());
	}

	public boolean addEnchant(RunsafeEnchantment ench, int level, boolean anyLevel)
	{
		ItemMeta meta = getRawMeta();
		boolean success = false;
		if (meta != null)
		{
			success = meta.addEnchant(ench.getRaw(), level, anyLevel);
			if (success)
				itemStack.setItemMeta(meta);
		}
		return success;
	}

	public boolean removeEnchant(RunsafeEnchantment ench)
	{
		ItemMeta meta = getRawMeta();
		boolean success = false;
		if (meta != null)
		{
			success = meta.removeEnchant(ench.getRaw());
			if (success)
				itemStack.setItemMeta(meta);
		}
		return success;
	}

	public boolean hasDisplayName()
	{
		ItemMeta meta = getRawMeta();
		return meta != null && meta.hasDisplayName();
	}

	@Nullable
	public String getDisplayName()
	{
		ItemMeta meta = getRawMeta();
		return meta == null ? null : meta.getDisplayName();
	}

	public BukkitMeta setDisplayName(String name)
	{
		ItemMeta meta = getRawMeta();
		if (meta != null)
		{
			meta.setDisplayName(name);
			itemStack.setItemMeta(meta);
		}
		return this;
	}

	public boolean hasLore()
	{
		ItemMeta meta = getRawMeta();
		return meta != null && meta.hasLore();
	}

	@Nullable
	public List<String> getLore()
	{
		ItemMeta meta = getRawMeta();
		return meta == null ? null : meta.getLore();
	}

	public BukkitMeta addLore(String lore)
	{
		ItemMeta meta = getRawMeta();
		if (meta != null)
		{
			List<String> currentLore = meta.getLore();
			if (currentLore == null)
				currentLore = new ArrayList<String>(1);
			currentLore.add(lore);
			meta.setLore(currentLore);
			itemStack.setItemMeta(meta);
		}
		return this;
	}

	public BukkitMeta setLore(List<String> lore)
	{
		ItemMeta meta = getRawMeta();
		if (meta != null)
		{
			meta.setLore(lore);
			itemStack.setItemMeta(meta);
		}
		return this;
	}
}
