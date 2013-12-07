package no.runsafe.framework.api.player;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;

public interface IPlayerKinematics
{
	RunsafeLocation getLocation();
	void teleport(RunsafeWorld world, double x, double y, double z);
	void throwToPoint(RunsafeLocation location);
	void throwFromPoint(RunsafeLocation location);
}
