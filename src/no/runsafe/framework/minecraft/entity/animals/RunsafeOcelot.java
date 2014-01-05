package no.runsafe.framework.minecraft.entity.animals;

import no.runsafe.framework.api.entity.animals.IOcelot;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Ocelot;

public class RunsafeOcelot extends RunsafeAgeable implements IOcelot
{
	public RunsafeOcelot(Ocelot toWrap)
	{
		super(toWrap);
		ocelot = toWrap;
	}

	@Override
	public Ocelot.Type getCatType()
	{
		return ocelot.getCatType();
	}

	@Override
	public boolean isSitting()
	{
		return ocelot.isSitting();
	}

	@Override
	public void setCatType(Ocelot.Type type)
	{
		ocelot.setCatType(type);
	}

	@Override
	public void setSitting(boolean sitting)
	{
		ocelot.setSitting(sitting);
	}

	@Override
	public boolean isTamed()
	{
		return ocelot.isTamed();
	}

	@Override
	public void setTamed(boolean tamed)
	{
		ocelot.setTamed(tamed);
	}

	@Override
	public void setOwner(IAnimalTamer tamer)
	{
		ocelot.setOwner((AnimalTamer) ObjectUnwrapper.convert(tamer));
	}

	@Override
	public IAnimalTamer getOwner()
	{
		return ObjectWrapper.convert(ocelot.getOwner());
	}

	private final Ocelot ocelot;
}
