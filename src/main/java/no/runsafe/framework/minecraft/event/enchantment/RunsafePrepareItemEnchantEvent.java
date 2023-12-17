package no.runsafe.framework.minecraft.event.enchantment;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCancellableInventoryEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class RunsafePrepareItemEnchantEvent extends RunsafeCancellableInventoryEvent
{
	public RunsafePrepareItemEnchantEvent(PrepareItemEnchantEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IPlayer getEnchanter()
	{
		return ObjectWrapper.convert((OfflinePlayer) event.getEnchanter());
	}

	public IBlock getEnchantBlock()
	{
		return ObjectWrapper.convert(event.getEnchantBlock());
	}

	public RunsafeMeta getItem()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	public int[] getExpLevelCostsOffered()
	{
		return event.getExpLevelCostsOffered();
	}

	public int getEnchantmentBonus()
	{
		return event.getEnchantmentBonus();
	}

	private final PrepareItemEnchantEvent event;
}
