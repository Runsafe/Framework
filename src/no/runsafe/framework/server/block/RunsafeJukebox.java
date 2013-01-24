package no.runsafe.framework.server.block;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.material.RunsafeMaterial;
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

	@Override
	public Jukebox getRaw()
	{
		return jukebox;
	}

	private final Jukebox jukebox;
}
