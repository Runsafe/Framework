package no.runsafe.framework.server.event.inventory;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.event.RunsafeEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.inventory.RunsafeInventoryView;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryEvent;

import java.util.ArrayList;
import java.util.List;

public class RunsafeInventoryEvent extends RunsafeEvent
{
	public RunsafeInventoryEvent(InventoryEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(this.event.getInventory());
	}

	public List<RunsafePlayer> getViewers()
	{
		List<RunsafePlayer> runsafeHumanEntities = new ArrayList<RunsafePlayer>();
		for (HumanEntity humanEntity : this.event.getViewers())
			runsafeHumanEntities.add(ObjectWrapper.convert(humanEntity));

		return runsafeHumanEntities;
	}

	public RunsafeInventoryView getView()
	{
		return ObjectWrapper.convert(this.event.getView());
	}

	private final InventoryEvent event;
}
