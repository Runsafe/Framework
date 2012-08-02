package no.runsafe.framework.extensibility;

import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface ITeleport {
	RunsafeLocation engage(RunsafeLocation location);
}
