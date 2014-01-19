package no.runsafe.framework.api.item.data;

import javafx.beans.binding.SetBinding;
import org.bukkit.block.BlockFace;

public interface IMushroomData extends IItemData
{
	SetBinding<BlockFace> getPaintedFaces();
	boolean isFacePainted(BlockFace face);
	boolean isStem();
	void setPaintedFace(BlockFace face, boolean painted);
	void setStem();
}
