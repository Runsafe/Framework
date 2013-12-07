package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitJukebox;
import org.bukkit.block.Jukebox;

public class RunsafeJukebox extends BukkitJukebox implements no.runsafe.framework.api.block.IJukebox
{
	public RunsafeJukebox(Jukebox toWrap)
	{
		super(toWrap);
	}
}
