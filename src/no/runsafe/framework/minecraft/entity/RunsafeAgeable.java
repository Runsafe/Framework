package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IAgeable;
import org.bukkit.entity.Ageable;

public class RunsafeAgeable extends RunsafeCreature implements IAgeable
{
	public RunsafeAgeable(Ageable toWrap)
	{
		super(toWrap);
		ageable = toWrap;
	}

	@Override
	public boolean canBreed()
	{
		return ageable.canBreed();
	}

	@Override
	public int getAge()
	{
		return ageable.getAge();
	}

	@Override
	public boolean getAgeLock()
	{
		return ageable.getAgeLock();
	}

	@Override
	public boolean isAdult()
	{
		return ageable.isAdult();
	}

	@Override
	public void setAdult()
	{
		ageable.setAdult();
	}

	@Override
	public void setAge(int age)
	{
		ageable.setAge(age);
	}

	@Override
	public void setAgeLock(boolean lock)
	{
		ageable.setAgeLock(lock);
	}

	@Override
	public void setBaby()
	{
		ageable.setBaby();
	}

	@Override
	public void setBreed(boolean breed)
	{
		ageable.setBreed(breed);
	}

	private final Ageable ageable;
}
