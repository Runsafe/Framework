package no.runsafe.framework.api.player;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import javax.annotation.Nullable;

public interface IPlayerInventory extends IInventoryHolder
{
	void give(RunsafeMeta... items);

	void removeItem(Item itemType, int amount);

	void removeItem(Item itemType);

	void clearInventory();

	void closeInventory();

	@Nullable
	RunsafeMeta getItemInHand();

	void updateInventory();

	void openInventory(RunsafeInventory inventory);
}
