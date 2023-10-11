package no.runsafe.framework.minecraft.bossBar;

public enum BarFlag
{
    FOG(org.bukkit.boss.BarFlag.CREATE_FOG),
    DARKEN_SKY(org.bukkit.boss.BarFlag.DARKEN_SKY),
    DRAGON_BOSS_AMBIENCE(org.bukkit.boss.BarFlag.PLAY_BOSS_MUSIC);

    BarFlag(org.bukkit.boss.BarFlag flag)
    {
        this.flag = flag;
    }

    public org.bukkit.boss.BarFlag getBukkitFlag()
    {
        return flag;
    }

    private final org.bukkit.boss.BarFlag flag;
}