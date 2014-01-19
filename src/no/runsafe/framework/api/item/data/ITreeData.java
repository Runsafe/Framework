package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.BlockFace;
import no.runsafe.framework.minecraft.data.TreeSpecies;

public interface ITreeData extends IItemData
{
	BlockFace getDirection();
	TreeSpecies getSpecies();
	void setDirection(BlockFace direction);
	void setSpecies(TreeSpecies species);
}
