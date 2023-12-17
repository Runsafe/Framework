package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.Item;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;

public abstract class BukkitJukebox extends BukkitBlockState
{
	protected BukkitJukebox(Block toWrap, Jukebox state)
	{
		super(toWrap, state);
		jukebox = state;
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

	protected final Jukebox jukebox;
}
