package no.runsafe.framework.api.entity.animals;

import no.runsafe.framework.api.entity.IAnimal;
import no.runsafe.framework.api.entity.ITameable;
import org.bukkit.entity.Ocelot;

public interface IOcelot extends IAnimal, ITameable
{
	Ocelot.Type getCatType();
	boolean isSitting();
	void setCatType(Ocelot.Type type);
	void setSitting(boolean sitting);
}
