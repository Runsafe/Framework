package no.runsafe.framework.minecraft.entity.animals.horses;

import no.runsafe.framework.minecraft.Sound;
import org.bukkit.entity.Horse;

public enum HorseColour
{
    WHITE(Horse.Color.WHITE),
    BLACK(Horse.Color.BLACK),
    BROWN(Horse.Color.BROWN),
    CHESTNUT(Horse.Color.CHESTNUT),
    CREAMY(Horse.Color.CREAMY),
    DARK_BROWN(Horse.Color.DARK_BROWN),
    GREY(Horse.Color.GRAY);

    private HorseColour(Horse.Color colour)
    {
        this.colour = colour;
    }

    public Horse.Color getBukkitColour()
    {
        return colour;
    }

    private Horse.Color colour;
}
