package no.runsafe.framework.minecraft.event.enchantment;

import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCancellableInventoryEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class RunsafePrepareItemEnchantEvent extends RunsafeCancellableInventoryEvent
{
	public RunsafePrepareItemEnchantEvent(PrepareItemEnchantEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafePlayer getEnchanter()
	{
		return ObjectWrapper.convert(this.event.getEnchanter());
	}

	public RunsafeBlock getEnchantBlock()
	{
		return ObjectWrapper.convert(this.event.getEnchantBlock());
	}

	public RunsafeMeta getItem()
	{
		return ObjectWrapper.convert(this.event.getItem());
	}

	public int[] getExpLevelCostsOffered()
	{
		return this.event.getExpLevelCostsOffered();
	}

	public int getEnchantmentBonus()
	{
		return this.event.getEnchantmentBonus();
	}

	private final PrepareItemEnchantEvent event;
}
