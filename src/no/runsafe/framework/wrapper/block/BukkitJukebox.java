package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.Jukebox;

@SuppressWarnings("deprecation")
public class BukkitJukebox extends RunsafeBlockState
{
	public BukkitJukebox(Jukebox toWrap)
	{
		super(toWrap);
		jukebox = toWrap;
	}

	@Deprecated
	public RunsafeMaterial getPlaying()
	{
		return ObjectWrapper.convert(jukebox.getPlaying());
	}

	@Deprecated
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

	protected final Jukebox jukebox;
}
