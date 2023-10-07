package no.runsafe.framework.minecraft.entity.animals.horses;

import org.bukkit.entity.Horse;

public enum HorseStyle
{
    NONE(Horse.Style.NONE),
    WHITE(Horse.Style.WHITE),
    BLACK_DOTS(Horse.Style.BLACK_DOTS),
    WHITE_DOTS(Horse.Style.WHITE_DOTS),
    WHITEFIELD(Horse.Style.WHITEFIELD);

    private HorseStyle(Horse.Style style)
    {
        this.style = style;
    }

    public Horse.Style getBukkitStyle()
    {
        return style;
    }

    private Horse.Style style;
}
