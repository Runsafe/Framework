package no.runsafe.framework.api.entity.animals.horses;

import no.runsafe.framework.api.entity.IAnimal;
import no.runsafe.framework.api.entity.ITameable;

public interface IHorse extends IAnimal, ITameable
{
	int getDomestication();

	void setDomestication(int level);

	int getMaxDomestication();

	void setMaxDomestication(int maxDomestication);

	double getJumpStrength();

	void setJumpStrength(double jumpStrength);
}
