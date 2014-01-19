package no.runsafe.framework.api.item.data;

import no.runsafe.framework.api.item.IItemStack;
import no.runsafe.framework.minecraft.Item;

public interface IItemData
{
	Item getItemType();
	IItemStack toItemStack();
	IItemStack toItemStack(int amount);
}
