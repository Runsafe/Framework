package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.bossBar.BarColour;
import no.runsafe.framework.minecraft.bossBar.BarFlag;
import no.runsafe.framework.minecraft.bossBar.BarStyle;
import org.bukkit.Server;
import org.bukkit.boss.BossBar;

import java.util.List;

public class BukkitBossBar implements IWrapper<BossBar>
{
    protected BukkitBossBar(BossBar toWrap)
    {
        bossBar = toWrap;
    }

    @Override
    public BossBar getRaw()
    {
        return bossBar;
    }

    void addFlag(BarFlag flag)
    {
        bossBar.addFlag(flag.getBukkitFlag());
    }

    boolean hasFlag(BarFlag flag)
    {
        return bossBar.hasFlag(flag.getBukkitFlag());
    }

    void removeFlag(BarFlag flag)
    {
        bossBar.removeFlag(flag.getBukkitFlag());
    }

    void addPlayer(IPlayer player)
    {
        bossBar.addPlayer(ObjectUnwrapper.convert(player));
    }

    List<IPlayer> getPlayers()
    {
        return ObjectUnwrapper.convert(bossBar.getPlayers());
    }

    void removePlayer(IPlayer player)
    {
        bossBar.removePlayer(ObjectUnwrapper.convert(player));
    }

    void removeAllPlayers()
    {
        bossBar.removeAll();
    }

    void setColour(BarColour colour)
    {
        bossBar.setColor(colour.getBukkitBarColour());
    }

    void setProgress(double progress)
    {
        bossBar.setProgress(progress);
    }

    double getProgress()
    {
        return bossBar.getProgress();
    }

    void setStyle(BarStyle style)
    {
        bossBar.setStyle(style.getBukkitBarStyle());
    }

    void setTitle(String title)
    {
        bossBar.setTitle(title);
    }

    String getTitle()
    {
        return bossBar.getTitle();
    }

    void setVisible(boolean visible)
    {
        bossBar.setVisible(visible);
    }

    boolean isVisible()
    {
        return bossBar.isVisible();
    }
    BossBar bossBar;
}
