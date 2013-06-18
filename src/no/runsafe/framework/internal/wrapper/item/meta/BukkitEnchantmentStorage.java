package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.HashMap;
import java.util.Map;

public abstract class BukkitEnchantmentStorage extends RunsafeMeta
{
	protected BukkitEnchantmentStorage(ItemStack stack)
	{
		super(stack);
	}

	@Override
	public EnchantmentStorageMeta getRawMeta()
	{
		return (EnchantmentStorageMeta) itemStack.getItemMeta();
	}

	public boolean hasStoredEnchants()
	{
		return getRawMeta().hasStoredEnchants();
	}

	public boolean hasStoredEnchant(RunsafeEnchantment ench)
	{
		return getRawMeta().hasStoredEnchant(ench.getRaw());
	}

	public int getStoredEnchantLevel(RunsafeEnchantment ench)
	{
		return getRawMeta().getStoredEnchantLevel(ench.getRaw());
	}

	public Map<RunsafeEnchantment, Integer> getStoredEnchants()
	{
		Map<Enchantment, Integer> bukkitEnchants = getRawMeta().getStoredEnchants();
		HashMap<RunsafeEnchantment, Integer> enchants = new HashMap<RunsafeEnchantment, Integer>();
			for (Enchantment ench : bukkitEnchants.keySet())
				enchants.put(ObjectWrapper.convert(ench), bukkitEnchants.get(ench));
			return enchants;
	}

	public boolean addStoredEnchant(RunsafeEnchantment ench, int level, boolean ignoreLevelRestriction)
	{
		EnchantmentStorageMeta meta = getRawMeta();
		boolean success = meta.addStoredEnchant(ench.getRaw(), level, ignoreLevelRestriction);
		if (success)
			itemStack.setItemMeta(meta);
		return success;
	}

	public boolean removeStoredEnchant(RunsafeEnchantment ench) throws IllegalArgumentException
	{
		EnchantmentStorageMeta meta = getRawMeta();
		boolean success = meta.removeStoredEnchant(ench.getRaw());
		if (success)
			itemStack.setItemMeta(meta);
		return success;
	}
}
