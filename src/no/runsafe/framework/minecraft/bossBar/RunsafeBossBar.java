package no.runsafe.framework.minecraft.bossBar;

import no.runsafe.framework.api.IBossBar;
import no.runsafe.framework.internal.wrapper.BukkitBossBar;
import org.bukkit.boss.BossBar;
import org.bukkit.craftbukkit.v1_12_R1.boss.CraftBossBar;

public class RunsafeBossBar extends BukkitBossBar implements IBossBar
{
    public RunsafeBossBar(BossBar toWrap)
    {
        super(toWrap);
        bossbar = toWrap;
    }

    public RunsafeBossBar(String title, BarColour colour, BarStyle style)
    {
        this(new CraftBossBar(title,colour.getBukkitBarColour(), style.getBukkitBarStyle()));
    }

    BossBar bossbar;
}
