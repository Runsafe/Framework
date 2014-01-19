package no.runsafe.framework.api.item.data;

import org.bukkit.block.BlockFace;

public interface IVineData extends IItemData
{
	boolean isOnFace(BlockFace face);
	void putOnFace(BlockFace face);
	void removeFromFace(BlockFace face);
}
