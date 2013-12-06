package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeRecipe;
import org.bukkit.event.inventory.CraftItemEvent;

public class RunsafeCraftItemEvent extends RunsafeInventoryClickEvent
{
	public RunsafeCraftItemEvent(CraftItemEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeRecipe getRecipe()
	{
		return ObjectWrapper.convert(event.getRecipe());
	}

	private final CraftItemEvent event;
}
