package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import org.bukkit.block.Jukebox;

public abstract class BukkitJukebox extends RunsafeBlockState
{
	protected BukkitJukebox(Jukebox toWrap)
	{
		super(toWrap);
		jukebox = toWrap;
	}

	public Item getPlaying()
	{
		return Item.get(jukebox.getPlaying(), (byte) 0);
	}

	public void setPlaying(Item material)
	{
		jukebox.setPlaying(material.getType());
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
