package no.runsafe.framework.api.player;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import javax.annotation.Nullable;

public interface IPlayerInventory extends IInventoryHolder
{
	void give(RunsafeMeta... items);

	boolean hasItem(Item itemType, int amount);

	void removeItem(Item itemType, int amount);

	void removeItem(Item itemType);

	void clearInventory();

	void closeInventory();

	@Nullable
	RunsafeMeta getItemInHand();

	void updateInventory();

	void openInventory(RunsafeInventory inventory);

	@Nullable
	RunsafeMeta getHelmet();

	@Nullable
	RunsafeMeta getChestplate();

	@Nullable
	RunsafeMeta getLeggings();

	@Nullable
	RunsafeMeta getBoots();

	void setHelmet(RunsafeMeta itemStack);

	void setChestplate(RunsafeMeta itemStack);

	void setLeggings(RunsafeMeta itemStack);

	void setBoots(RunsafeMeta itemStack);

	void removeExactItem(RunsafeMeta item, int amount);

	void removeExactItem(RunsafeMeta item);
}
