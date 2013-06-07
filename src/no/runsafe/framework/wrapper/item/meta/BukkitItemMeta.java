package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class BukkitItemMeta
{
	public BukkitItemMeta(ItemMeta meta)
	{
		this.meta = meta;
	}

	public boolean hasDisplayName()
	{
		return meta.hasDisplayName();
	}

	public String getDisplayName()
	{
		return meta.getDisplayName();
	}

	public void setDisplayName(String name)
	{
		meta.setDisplayName(name);
	}

	public boolean hasLore()
	{
		return meta.hasLore();
	}

	public List<String> getLore()
	{
		return meta.getLore();
	}

	public void setLore(List<String> lore)
	{
		meta.setLore(lore);
	}

	public boolean hasEnchants()
	{
		return meta.hasEnchants();
	}

	public boolean hasEnchant(RunsafeEnchantment ench)
	{
		return meta.hasEnchant(ench.getRaw());
	}

	public int getEnchantLevel(RunsafeEnchantment ench)
	{
		return meta.getEnchantLevel(ench.getRaw());
	}

	public boolean addEnchant(RunsafeEnchantment ench, int level, boolean ignoreLevelRestriction)
	{
		return meta.addEnchant(ench.getRaw(), level, ignoreLevelRestriction);
	}

	public boolean removeEnchant(RunsafeEnchantment ench)
	{
		return meta.removeEnchant(ench.getRaw());
	}

	public ItemMeta getRaw()
	{
		return meta;
	}

	protected final ItemMeta meta;
}
