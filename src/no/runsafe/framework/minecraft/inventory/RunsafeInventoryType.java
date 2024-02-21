package no.runsafe.framework.minecraft.inventory;

import org.bukkit.event.inventory.InventoryType;

import javax.annotation.Nonnull;

public enum RunsafeInventoryType
{
	CHEST(27, "Chest"),
	DISPENSER(9, "Dispenser"),
	FURNACE(3, "Furnace"),
	HOPPER(5, "Hopper"),
	WORKBENCH(10, "Crafting"),
	CRAFTING(5, "Crafting"),
	ENCHANTING(1, "Enchanting"),
	BREWING(4, "Brewing"),
	PLAYER(36, "PlayerExtensions"),
	CREATIVE(9, "Creative"),
	MERCHANT(3, "Villager"),
	ENDER_CHEST(27, "Ender Chest"),
	ANVIL(3, "Repairing"),
	BEACON(1, "container.beacon"),
	DROPPER(9, "Dropper");

	private final int size;
	private final String title;

	RunsafeInventoryType(int defaultSize, String defaultTitle)
	{
		size = defaultSize;
		title = defaultTitle;
	}

	public int getDefaultSize()
	{
		return size;
	}

	public String getDefaultTitle()
	{
		return title;
	}

	@Nonnull
	public InventoryType getRaw()
	{
		return InventoryType.valueOf(name());
	}

	@SuppressWarnings("InnerClassFieldHidesOuterClassField")
	public enum SlotType
	{
		RESULT,
		CRAFTING,
		ARMOR,
		CONTAINER,
		QUICKBAR,
		OUTSIDE,
		FUEL
	}
}
