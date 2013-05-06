package no.runsafe.framework.server.enchantment;

import org.bukkit.enchantments.EnchantmentWrapper;

public class RunsafeEnchantmentWrapper extends RunsafeEnchantment
{
	public RunsafeEnchantmentWrapper(EnchantmentWrapper toWrap)
	{
		super(toWrap);
		enchantmentWrapper = toWrap;
	}

	public RunsafeEnchantmentWrapper(int enchantId)
	{
		super(enchantId);
		enchantmentWrapper = new EnchantmentWrapper(enchantId);
	}

	public EnchantmentWrapper getRaw()
	{
		return enchantmentWrapper;
	}

	private final EnchantmentWrapper enchantmentWrapper;
}
