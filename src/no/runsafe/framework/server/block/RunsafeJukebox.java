package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitJukebox;
import org.bukkit.block.Jukebox;

public class RunsafeJukebox extends BukkitJukebox
{
	public RunsafeJukebox(Jukebox toWrap)
	{
		super(toWrap);
	}
}
