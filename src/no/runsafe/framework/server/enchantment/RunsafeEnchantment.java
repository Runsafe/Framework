package no.runsafe.framework.server.enchantment;

import org.bukkit.enchantments.Enchantment;

public class RunsafeEnchantment
{
    public RunsafeEnchantment(Enchantment toWrap)
    {
        enchantment = toWrap;
    }

    private Enchantment enchantment;
}
