package no.runsafe.framework.api.entity.villagers;

import org.bukkit.entity.Villager;

public interface IVillager
{
	void setProfession(Villager.Profession profession);
	Villager.Profession getProfession();
}
