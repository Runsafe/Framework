package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.Item;

import java.util.List;

public interface ITexturedMaterial extends IItemData
{
	Item getMaterial();
	List<Item> getTextures();
	void setMaterial(Item material);
}
