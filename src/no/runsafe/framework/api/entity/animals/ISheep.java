package no.runsafe.framework.api.entity.animals;

import no.runsafe.framework.api.entity.IAnimal;
import no.runsafe.framework.api.entity.IColourable;

public interface ISheep extends IAnimal, IColourable
{
	boolean isSheared();

	void setSheared(boolean sheared);
}
