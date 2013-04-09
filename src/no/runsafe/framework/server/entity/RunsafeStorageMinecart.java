package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.entity.StorageMinecart;

public class RunsafeStorageMinecart extends RunsafeMinecart implements IInventoryHolder
{
	public RunsafeStorageMinecart(StorageMinecart toWrap)
	{
		super(toWrap);
		storage = toWrap;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(storage.getInventory());
	}

	private final StorageMinecart storage;
}
