package no.runsafe.framework.minecraft.bossBar;

import no.runsafe.framework.api.IBossBar;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.BukkitBossBar;
import org.bukkit.boss.BossBar;
import org.bukkit.craftbukkit.v1_12_R1.boss.CraftBossBar;

import java.util.List;

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

    public void setActivePlayers(List<IPlayer> players)
    {
        List<IPlayer> bossBarPlayers = this.getPlayers();

        // Remove players not on the new list
        for (IPlayer bossBarPlayer : bossBarPlayers)
            if (!players.contains(bossBarPlayer))
            {
                this.removePlayer(bossBarPlayer);
                bossBarPlayers.remove(bossBarPlayer);
            }

        // Add players not on the old list
        for (IPlayer newPlayer : players)
            if (!bossBarPlayers.contains(newPlayer))
                this.addPlayer(newPlayer);
    }

    private final BossBar bossbar;
}
