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

    public void addFlag(BarFlag flag)
    {
        bossBar.addFlag(flag.getBukkitFlag());
    }

    public boolean hasFlag(BarFlag flag)
    {
        return bossBar.hasFlag(flag.getBukkitFlag());
    }

    public void removeFlag(BarFlag flag)
    {
        bossBar.removeFlag(flag.getBukkitFlag());
    }

    public void addPlayer(IPlayer player)
    {
        bossBar.addPlayer(ObjectUnwrapper.convert(player));
    }

    public List<IPlayer> getPlayers()
    {
        return ObjectWrapper.convert(bossBar.getPlayers());
    }

    public void removePlayer(IPlayer player)
    {
        bossBar.removePlayer(ObjectUnwrapper.convert(player));
    }

    public void removeAllPlayers()
    {
        bossBar.removeAll();
    }

    public void setColour(BarColour colour)
    {
        bossBar.setColor(colour.getBukkitBarColour());
    }

    public void setProgress(double progress)
    {
        bossBar.setProgress(progress);
    }

    public double getProgress()
    {
        return bossBar.getProgress();
    }

    public void setStyle(BarStyle style)
    {
        bossBar.setStyle(style.getBukkitBarStyle());
    }

    public void setTitle(String title)
    {
        bossBar.setTitle(title);
    }

    public String getTitle()
    {
        return bossBar.getTitle();
    }

    public void setVisible(boolean visible)
    {
        bossBar.setVisible(visible);
    }

    public boolean isVisible()
    {
        return bossBar.isVisible();
    }
    protected final BossBar bossBar;
}
