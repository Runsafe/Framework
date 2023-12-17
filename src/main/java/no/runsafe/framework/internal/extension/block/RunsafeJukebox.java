package no.runsafe.framework.internal.extension.block;


import no.runsafe.framework.api.block.IJukebox;
import no.runsafe.framework.internal.wrapper.block.BukkitJukebox;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;

public class RunsafeJukebox extends BukkitJukebox implements IJukebox
{
	public RunsafeJukebox(Block toWrap, Jukebox state)
	{
		super(toWrap, state);
	}
}
