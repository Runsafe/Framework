package no.runsafe.framework.api.entity.animals.horses;

import org.bukkit.entity.Horse;

public interface INormalHorse extends IHorse
{
	Horse.Variant getType();

	void setType(Horse.Variant type);

	void setRandomType();

	Horse.Color getColour();

	void setColour(Horse.Color colour);

	void setRandomColour();

	Horse.Style getStyle();

	void setStyle(Horse.Style style);

	void setRandomStyle();
}
