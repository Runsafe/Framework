package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.villagers.IVillager;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.entity.Villager;

import javax.annotation.Nullable;

public class RunsafeVillager extends RunsafeAgeable implements IVillager
{
	public RunsafeVillager(Villager toWrap)
	{
		super(toWrap);
		villager = toWrap;
	}

	@Override
	public void setProfession(Villager.Profession profession)
	{
		villager.setProfession(profession);
	}

	@Override
	public Villager.Profession getProfession()
	{
		return villager.getProfession();
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Villager.Idle;
	}

	Villager villager;
}
