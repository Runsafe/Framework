package no.runsafe.framework.api.block;

import no.runsafe.framework.minecraft.Item;

public interface IJukebox extends IBlockState
{
	Item getPlaying();
	void setPlaying(Item material);
	boolean isPlaying();
	boolean eject();
}
