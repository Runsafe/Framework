package no.runsafe.framework.minecraft.bossBar;

import org.bukkit.boss.BarColor;

public enum BarColour
{
    BLUE(BarColor.BLUE),
    GREEN(BarColor.GREEN),
    PINK(BarColor.PINK),
    PURPLE(BarColor.PURPLE),
    RED(BarColor.RED),
    WHITE(BarColor.WHITE),
    YELLOW(BarColor.YELLOW);

    BarColour(BarColor colour)
    {
        this.colour = colour;
    }

    public BarColor getBukkitBarColour()
    {
        return colour;
    }

    private final BarColor colour;
}
