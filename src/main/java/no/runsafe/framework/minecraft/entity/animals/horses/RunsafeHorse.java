package no.runsafe.framework.minecraft.entity.animals.horses;

import no.runsafe.framework.api.entity.animals.horses.IHorse;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.entity.Horse;

public class RunsafeHorse extends RunsafeAgeable implements IHorse
{
	public RunsafeHorse(Horse toWrap)
	{
		super(toWrap);
		horse = toWrap;
	}

	@Override
	public int getDomestication()
	{
		return horse.getDomestication();
	}

	@Override
	public void setDomestication(int level)
	{
		horse.setDomestication(level);
	}

	@Override
	public int getMaxDomestication()
	{
		return horse.getMaxDomestication();
	}

	@Override
	public void setMaxDomestication(int maxDomestication)
	{
		horse.setMaxDomestication(maxDomestication);
	}

	@Override
	public double getJumpStrength()
	{
		return horse.getJumpStrength();
	}

	@Override
	public void setJumpStrength(double jumpStrength)
	{
		horse.setJumpStrength(jumpStrength);
	}

	@Override
	public boolean isTamed()
	{
		return horse.isTamed();
	}

	@Override
	public void setTamed(boolean tamed)
	{
		horse.setTamed(tamed);
	}

	@Override
	public void setOwner(IAnimalTamer tamer)
	{
		horse.setOwner(ObjectUnwrapper.convert(tamer));
	}

	@Override
	public IAnimalTamer getOwner()
	{
		return ObjectWrapper.convert(horse.getOwner());
	}

	@Override
	public Horse getRaw()
	{
		return horse;
	}

	Horse horse;
}
