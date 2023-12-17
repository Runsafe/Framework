package no.runsafe.framework.api.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;

public interface IPlayerKinematics
{
	ILocation getLocation();

	void teleport(IWorld world, double x, double y, double z);

	void throwToPoint(ILocation location);

	void throwFromPoint(ILocation location);
}
