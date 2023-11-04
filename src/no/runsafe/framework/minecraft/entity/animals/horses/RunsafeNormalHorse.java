package no.runsafe.framework.minecraft.entity.animals.horses;

import no.runsafe.framework.api.entity.animals.horses.INormalHorse;
import org.bukkit.entity.Horse;

import java.util.Random;

public class RunsafeNormalHorse extends RunsafeHorse implements INormalHorse
{
	public RunsafeNormalHorse(Horse toWrap)
	{
		super(toWrap);
		normalHorse = toWrap;
	}

	@Override
	public Horse.Color getColour()
	{
		return normalHorse.getColor();
	}

	@Override
	public void setColour(HorseColour colour)
	{
		normalHorse.setColor(colour.getBukkitColour());
	}

	@Override
	public void setRandomColour()
	{
		Horse.Color[] values = Horse.Color.values();
		normalHorse.setColor(values[this.random.nextInt(values.length)]);
	}

	@Override
	public Horse.Style getStyle()
	{
		return normalHorse.getStyle();
	}

	@Override
	public void setStyle(HorseStyle style)
	{
		normalHorse.setStyle(style.getBukkitStyle());
	}

	@Override
	public void setRandomStyle()
	{
		Horse.Style[] values = Horse.Style.values();
		normalHorse.setStyle(values[this.random.nextInt(values.length)]);
	}

	@Override
	public Horse getRaw()
	{
		return normalHorse;
	}

	private static final Random random = new Random();
	Horse normalHorse;
}
