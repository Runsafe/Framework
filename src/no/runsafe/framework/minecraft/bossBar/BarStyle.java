package no.runsafe.framework.minecraft.bossBar;

public enum BarStyle
{
    SOLID(org.bukkit.boss.BarStyle.SOLID),
    SEGMENTED_6(org.bukkit.boss.BarStyle.SEGMENTED_6),
    SEGMENTED_10(org.bukkit.boss.BarStyle.SEGMENTED_10),
    SEGMENTED_12(org.bukkit.boss.BarStyle.SEGMENTED_12),
    SEGMENTED_20(org.bukkit.boss.BarStyle.SEGMENTED_20);

    BarStyle(org.bukkit.boss.BarStyle barStyle)
    {
        this.barStyle = barStyle;
    }

    public org.bukkit.boss.BarStyle getBukkitBarStyle()
    {
        return barStyle;
    }

    private final org.bukkit.boss.BarStyle barStyle;
}
