package no.runsafe.framework.api.player;

import no.runsafe.framework.minecraft.RunsafeWorld;

public interface IFakePlayer extends IPlayer
{
	void setWorld(RunsafeWorld world);
}
