package no.runsafe.framework.minecraft.entity.animals.horses;

import no.runsafe.framework.api.entity.animals.horses.IHorse;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import org.bukkit.entity.Horse;

import java.util.Random;

public class RunsafeHorse extends RunsafeAbstractHorse implements IHorse
{
	public RunsafeHorse(Horse toWrap)
	{
		super(toWrap);
		horse = toWrap;
	}

	@Override
	public Horse.Variant getType()
	{
		return horse.getVariant();
	}

	@Override
	public void setType(Horse.Variant type)
	{
		horse.setVariant(type);
	}

	@Override
	public void setRandomType()
	{
		Horse.Variant[] values = Horse.Variant.values();
		horse.setVariant(values[this.random.nextInt(values.length)]);
	}

	@Override
	public Horse.Color getColour()
	{
		return horse.getColor();
	}

	@Override
	public void setColour(Horse.Color colour)
	{
		horse.setColor(colour);
	}

	@Override
	public void setRandomColour()
	{
		Horse.Color[] values = Horse.Color.values();
		horse.setColor(values[this.random.nextInt(values.length)]);
	}

	@Override
	public Horse.Style getStyle()
	{
		return horse.getStyle();
	}

	@Override
	public void setStyle(Horse.Style style)
	{
		horse.setStyle(style);
	}

	@Override
	public void setRandomStyle()
	{
		Horse.Style[] values = Horse.Style.values();
		horse.setStyle(values[this.random.nextInt(values.length)]);
	}

	@Override
	public Horse getRaw()
	{
		return horse;
	}

	private Random random = new Random();
	Horse horse;
}
