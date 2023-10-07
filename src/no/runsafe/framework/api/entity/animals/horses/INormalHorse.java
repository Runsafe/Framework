package no.runsafe.framework.api.entity.animals.horses;

import no.runsafe.framework.minecraft.entity.animals.horses.HorseColour;
import no.runsafe.framework.minecraft.entity.animals.horses.HorseStyle;
import org.bukkit.entity.Horse;

public interface INormalHorse extends IHorse
{
	Horse.Color getColour();

	void setColour(HorseColour colour);

	void setRandomColour();

	Horse.Style getStyle();

	void setStyle(HorseStyle style);

	void setRandomStyle();
}
