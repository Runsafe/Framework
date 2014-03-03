package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.CraftingInventory;

import java.util.List;

public class BukkitCraftingInventory extends RunsafeInventory
{
	public BukkitCraftingInventory(CraftingInventory toWrap)
	{
		super(toWrap);
		inventory = toWrap;
	}

	public RunsafeMeta getResult()
	{
		return ObjectWrapper.convert(inventory.getResult());
	}

	public void setResult(RunsafeMeta result)
	{
		inventory.setResult(ObjectUnwrapper.convert(result));
	}

	public List<RunsafeMeta> getMatrix()
	{
		return ObjectWrapper.convert(inventory.getMatrix());
	}

	private final CraftingInventory inventory;
}
