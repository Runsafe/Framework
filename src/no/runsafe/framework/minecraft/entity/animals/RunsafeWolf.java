package no.runsafe.framework.minecraft.entity.animals;

import no.runsafe.framework.api.entity.animals.IWolf;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entityData.DyeColour;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.DyeColor;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Wolf;

public class RunsafeWolf extends RunsafeAgeable implements IWolf
{
	public RunsafeWolf(Wolf toWrap)
	{
		super(toWrap);
		wolf = toWrap;
	}

	@Override
	public boolean isTamed()
	{
		return wolf.isTamed();
	}

	@Override
	public DyeColour getCollarColour()
	{
		return DyeColour.valueOf(wolf.getCollarColor().name());
	}

	@Override
	public boolean isAngry()
	{
		return wolf.isAngry();
	}

	@Override
	public boolean isSitting()
	{
		return wolf.isSitting();
	}

	@Override
	public void setCollarColour(DyeColour colour)
	{
		wolf.setCollarColor(DyeColor.valueOf(colour.name()));
	}

	@Override
	public void setSitting(boolean sitting)
	{
		wolf.setSitting(sitting);
	}

	@Override
	public void setAngry(boolean angry)
	{
		wolf.setAngry(angry);
	}

	@Override
	public void setTamed(boolean tamed)
	{
		wolf.setTamed(tamed);
	}

	@Override
	public void setOwner(IAnimalTamer tamer)
	{
		wolf.setOwner((AnimalTamer) ObjectUnwrapper.convert(tamer));
	}

	@Override
	public IAnimalTamer getOwner()
	{
		return ObjectWrapper.convert(wolf.getOwner());
	}

	private final Wolf wolf;
}
