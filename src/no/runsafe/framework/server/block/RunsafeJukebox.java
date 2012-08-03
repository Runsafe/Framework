package no.runsafe.framework.server.block;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Jukebox;

public class RunsafeJukebox extends RunsafeBlockState
{
	public RunsafeJukebox(Jukebox toWrap)
	{
		super(toWrap);
		jukebox = toWrap;
	}

//	public Material getPlaying()
//	{
//	}
//
//	public void setPlaying(Material material)
//	{
//	}

	public boolean isPlaying()
	{
		return jukebox.isPlaying();
	}

	public boolean eject()
	{
		return jukebox.eject();
	}

	private final Jukebox jukebox;
}
