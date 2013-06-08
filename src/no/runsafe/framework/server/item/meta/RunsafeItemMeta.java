package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.wrapper.item.meta.BukkitItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class RunsafeItemMeta extends BukkitItemMeta
{
	public RunsafeItemMeta(ItemMeta meta)
	{
		super(meta);
	}

	public RunsafeItemMeta clone()
	{
		return new RunsafeItemMeta(meta.clone());
	}

	public void addLore(String lore)
	{
		List<String> currentLore = this.getLore();
		if (currentLore == null) currentLore = new ArrayList<String>();

		currentLore.add(lore);
		meta.setLore(currentLore);
	}

	public Map<RunsafeEnchantment, Integer> getEnchants()
	{
		return convertEnchants(meta.getEnchants());
	}

	protected Map<RunsafeEnchantment, Integer> convertEnchants(Map<Enchantment, Integer> bukkitEnchants)
	{
		HashMap<RunsafeEnchantment, Integer> enchants = new HashMap<RunsafeEnchantment, Integer>();
		for (Enchantment ench : bukkitEnchants.keySet())
			enchants.put(ObjectWrapper.convert(ench), bukkitEnchants.get(ench));
		return enchants;
	}
}
