package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Map;

public class RunsafeEnchantmentStorageMeta extends RunsafeItemMeta
{
	public RunsafeEnchantmentStorageMeta(EnchantmentStorageMeta meta)
	{
		super(meta);
		enchantmentStorageMeta = meta;
	}

	public boolean hasStoredEnchants()
	{
		return enchantmentStorageMeta.hasStoredEnchants();
	}

	public boolean hasStoredEnchant(RunsafeEnchantment ench)
	{
		return enchantmentStorageMeta.hasStoredEnchant(ench.getRaw());
	}

	public int getStoredEnchantLevel(RunsafeEnchantment ench)
	{
		return enchantmentStorageMeta.getStoredEnchantLevel(ench.getRaw());
	}

	public Map<RunsafeEnchantment, Integer> getStoredEnchants()
	{
		return convertEnchants(enchantmentStorageMeta.getEnchants());
	}

	public boolean addStoredEnchant(RunsafeEnchantment ench, int level, boolean ignoreLevelRestriction)
	{
		return enchantmentStorageMeta.addStoredEnchant(ench.getRaw(), level, ignoreLevelRestriction);
	}

	public boolean removeStoredEnchant(RunsafeEnchantment ench) throws IllegalArgumentException
	{
		return enchantmentStorageMeta.removeStoredEnchant(ench.getRaw());
	}

	private final EnchantmentStorageMeta enchantmentStorageMeta;
}
