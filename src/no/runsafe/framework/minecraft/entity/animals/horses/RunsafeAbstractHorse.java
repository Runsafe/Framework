package no.runsafe.framework.minecraft.entity.animals.horses;

import no.runsafe.framework.api.entity.animals.horses.IAbstractHorse;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.entity.Horse;

public class RunsafeAbstractHorse extends RunsafeAgeable implements IAbstractHorse
{
	public RunsafeAbstractHorse(Horse toWrap)
	{
		super(toWrap);
		abstractHorse = toWrap;
	}

	@Override
	public int getDomestication()
	{
		return abstractHorse.getDomestication();
	}

	@Override
	public void setDomestication(int level)
	{
		abstractHorse.setDomestication(level);
	}

	@Override
	public int getMaxDomestication()
	{
		return abstractHorse.getMaxDomestication();
	}

	@Override
	public void setMaxDomestication(int maxDomestication)
	{
		abstractHorse.setMaxDomestication(maxDomestication);
	}

	@Override
	public double getJumpStrength()
	{
		return abstractHorse.getJumpStrength();
	}

	@Override
	public void setJumpStrength(double jumpStrength)
	{
		abstractHorse.setJumpStrength(jumpStrength);
	}

	@Override
	public boolean isTamed()
	{
		return abstractHorse.isTamed();
	}

	@Override
	public void setTamed(boolean tamed)
	{
		abstractHorse.setTamed(tamed);
	}

	@Override
	public void setOwner(IAnimalTamer tamer)
	{
		abstractHorse.setOwner(ObjectUnwrapper.convert(tamer));
	}

	@Override
	public IAnimalTamer getOwner()
	{
		return ObjectWrapper.convert(abstractHorse.getOwner());
	}

	@Override
	public Horse getRaw()
	{
		return abstractHorse;
	}

	Horse abstractHorse;
}
