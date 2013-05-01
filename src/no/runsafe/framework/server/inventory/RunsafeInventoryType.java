package no.runsafe.framework.server.inventory;

public enum RunsafeInventoryType
{
	CHEST(27, "Chest"),
	DISPENSER(9, "Dispenser"),
	FURNACE(3, "Furnace"),
	WORKBENCH(10, "Crafting"),
	CRAFTING(5, "Crafting"),
	ENCHANTING(1, "Enchanting"),
	BREWING(4, "Brewing"),
	PLAYER(36, "Player"),
	CREATIVE(9, "Creative"),
	MERCHANT(3, "Villager"),
	ENDER_CHEST(27, "Ender Chest"),
	ANVIL(3, "Repairing"),
	BEACON(1, "container.beacon");

	private final int size;
	private final String title;

	private RunsafeInventoryType(int defaultSize, String defaultTitle)
	{
		this.size = defaultSize;
		this.title = defaultTitle;
	}

	public int getDefaultSize()
	{
		return this.size;
	}

	public String getDefaultTitle()
	{
		return this.title;
	}

	public enum SlotType
	{
		RESULT,
		CRAFTING,
		ARMOR,
		CONTAINER,
		QUICKBAR,
		OUTSIDE,
		FUEL;
	}
}
