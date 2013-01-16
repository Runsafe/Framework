package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunsafeItemMeta
{
	public RunsafeItemMeta(ItemMeta meta)
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

	public Map<RunsafeEnchantment, Integer> getEnchants()
	{
		return convertEnchants(meta.getEnchants());
	}

	public boolean addEnchant(RunsafeEnchantment ench, int level, boolean ignoreLevelRestriction)
	{
		return meta.addEnchant(ench.getRaw(), level, ignoreLevelRestriction);
	}

	public boolean removeEnchant(RunsafeEnchantment ench)
	{
		return meta.removeEnchant(ench.getRaw());
	}

	public RunsafeItemMeta clone()
	{
		return new RunsafeItemMeta(meta.clone());
	}

	public ItemMeta getRaw()
	{
		return meta;
	}

	public void update(Map<String, Object> data)
	{
		if (data.containsKey("display-name"))
			meta.setDisplayName((String) data.get("display-name"));
	}

	protected Map<RunsafeEnchantment, Integer> convertEnchants(Map<Enchantment, Integer> bukkitEnchants)
	{
		HashMap<RunsafeEnchantment, Integer> enchants = new HashMap<RunsafeEnchantment, Integer>();
		for (Enchantment ench : bukkitEnchants.keySet())
			enchants.put(ObjectWrapper.convert(ench), bukkitEnchants.get(ench));
		return enchants;
	}

	private final ItemMeta meta;
}
