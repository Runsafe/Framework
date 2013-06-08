package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Map;

public abstract class BukkitEnchantmentStorageMeta extends RunsafeItemMeta
{
	public BukkitEnchantmentStorageMeta(EnchantmentStorageMeta meta)
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

	@Override
	public EnchantmentStorageMeta getRaw()
	{
		return enchantmentStorageMeta;
	}

	protected final EnchantmentStorageMeta enchantmentStorageMeta;
}
