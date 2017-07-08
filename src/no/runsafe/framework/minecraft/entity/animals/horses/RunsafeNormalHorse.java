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
	public Horse.Variant getType()
	{
		return normalHorse.getVariant();
	}

	@Override
	public void setType(Horse.Variant type)
	{
		normalHorse.setVariant(type);
	}

	@Override
	public void setRandomType()
	{
		Horse.Variant[] values = Horse.Variant.values();
		normalHorse.setVariant(values[this.random.nextInt(values.length)]);
	}

	@Override
	public Horse.Color getColour()
	{
		return normalHorse.getColor();
	}

	@Override
	public void setColour(Horse.Color colour)
	{
		normalHorse.setColor(colour);
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
	public void setStyle(Horse.Style style)
	{
		normalHorse.setStyle(style);
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

	private static Random random = new Random();
	Horse normalHorse;
}
