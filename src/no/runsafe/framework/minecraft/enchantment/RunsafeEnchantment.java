package no.runsafe.framework.minecraft.enchantment;

import no.runsafe.framework.internal.wrapper.enchantment.BukkitEnchantment;
import org.bukkit.enchantments.Enchantment;

public class RunsafeEnchantment extends BukkitEnchantment
{
	public RunsafeEnchantment(Enchantment toWrap)
	{
		super(toWrap);
	}
}
