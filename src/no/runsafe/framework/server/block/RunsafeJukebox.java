package no.runsafe.framework.server.block;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.material.RunsafeMaterial;
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

	public RunsafeMaterial getPlaying()
	{
		return ObjectWrapper.convert(jukebox.getPlaying());
	}

	public void setPlaying(RunsafeMaterial material)
	{
		jukebox.setPlaying(material.getRaw());
	}

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
