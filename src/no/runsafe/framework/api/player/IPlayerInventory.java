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

	boolean hasItemStrict(Item itemType, int amount);

	void removeItem(Item itemType, int amount);

	void removeItem(Item itemType);

	void clearInventory();

	void closeInventory();

	@Nullable
	RunsafeMeta getItemInMainHand();

	@Nullable
	RunsafeMeta getItemInOffHand();

	void setItemInMainHand(RunsafeMeta itemStack);

	void setItemInOffHand(RunsafeMeta itemStack);

	void updateInventory();

	void openInventory(RunsafeInventory inventory);

	/**
	 * Gets the number of spaces free.
	 * Ignore armor slots / offhand
	 * @return number of free spaces. -1 if something goes wrong
	 */
	int getInventoryFreeSpaces();

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
