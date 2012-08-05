package no.runsafe.framework.server.enchantment;

import org.bukkit.enchantments.EnchantmentWrapper;

public class RunsafeEnchantmentWrapper
{
	public RunsafeEnchantmentWrapper(EnchantmentWrapper toWrap)
	{
		enchantmentWrapper = toWrap;
	}

	public RunsafeEnchantmentWrapper(int enchantId)
	{
		enchantmentWrapper = new EnchantmentWrapper(enchantId);
	}

	public EnchantmentWrapper getRaw()
	{
		return enchantmentWrapper;
	}

	private final EnchantmentWrapper enchantmentWrapper;
}
