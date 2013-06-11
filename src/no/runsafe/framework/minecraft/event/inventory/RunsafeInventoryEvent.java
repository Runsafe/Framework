package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryView;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
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
