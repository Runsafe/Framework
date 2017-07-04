package no.runsafe.framework.minecraft.entity.animals;

import no.runsafe.framework.api.entity.animals.ISheep;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import no.runsafe.framework.minecraft.entityData.DyeColour;
import org.bukkit.DyeColor;
import org.bukkit.entity.Sheep;

import javax.annotation.Nullable;

public class RunsafeSheep extends RunsafeAgeable implements ISheep
{
	public RunsafeSheep(Sheep toWrap)
	{
		super(toWrap);
		sheep = toWrap;
	}

	@Override
	public boolean isSheared()
	{
		return sheep.isSheared();
	}

	@Override
	public void setSheared(boolean sheared)
	{
		sheep.setSheared(sheared);
	}

	@Override
	public void setColour(DyeColour colour)
	{
		sheep.setColor(DyeColor.valueOf(colour.name()));
	}

	@Override
	public DyeColour getColour()
	{
		return DyeColour.valueOf(sheep.getColor().name());
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Sheep.Idle;
	}

	private final Sheep sheep;
}
