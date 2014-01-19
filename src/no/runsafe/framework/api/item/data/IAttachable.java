package no.runsafe.framework.api.item.data;

import org.bukkit.block.BlockFace;

public interface IAttachable extends IDirectional
{
	BlockFace getAttachedFace();
}
