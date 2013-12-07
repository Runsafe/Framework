package no.runsafe.framework.api.player;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface IPlayerKinematics
{
	RunsafeLocation getLocation();
	void teleport(IWorld world, double x, double y, double z);
	void throwToPoint(RunsafeLocation location);
	void throwFromPoint(RunsafeLocation location);
}
