package no.runsafe.framework.server.enchantment;

import no.runsafe.framework.wrapper.enchantment.BukkitEnchantment;
import org.bukkit.enchantments.Enchantment;

public class RunsafeEnchantment extends BukkitEnchantment
{
	public RunsafeEnchantment(Enchantment toWrap)
	{
		super(toWrap);
	}
}
