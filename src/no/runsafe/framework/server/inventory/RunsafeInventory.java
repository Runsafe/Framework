package no.runsafe.framework.server.inventory;

import com.google.common.collect.Lists;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class RunsafeInventory
{
	public RunsafeInventory(Inventory toWrap)
	{
		inventory = toWrap;
	}

	public IInventoryHolder getHolder()
	{
		return ObjectWrapper.convert(inventory.getHolder());
	}

	public List<RunsafeItemStack> getContents()
	{
		return ObjectWrapper.convert(Lists.newArrayList(inventory.getContents()));
	}

	public void clear()
	{
		inventory.clear();
	}

	private final Inventory inventory;
}
