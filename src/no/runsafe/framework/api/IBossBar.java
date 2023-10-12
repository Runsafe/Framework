package no.runsafe.framework.api;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.bossBar.BarColour;
import no.runsafe.framework.minecraft.bossBar.BarFlag;
import no.runsafe.framework.minecraft.bossBar.BarStyle;

import java.util.List;

public interface IBossBar
{
    void addFlag(BarFlag flag);
    boolean hasFlag(BarFlag flag);
    void removeFlag(BarFlag flag);
    void addPlayer(IPlayer player);
    List<IPlayer> getPlayers();
    void removePlayer(IPlayer player);
    void removeAllPlayers();
    void setColour(BarColour colour);
    void setProgress(double progress);
    double getProgress();
    void setStyle(BarStyle style);
    void setTitle(String title);
    String getTitle();
    void setVisible(boolean visible);
    boolean isVisible();

    /**
     * Set players who are viewing this boss bar.
     * Removes players not on this list.
     * @param players
     */
    void setActivePlayers(List<IPlayer> players);
}
