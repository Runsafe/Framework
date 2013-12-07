package no.runsafe.framework.minecraft.event.enchantment;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCancellableInventoryEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.enchantment.EnchantItemEvent;

import java.util.HashMap;
import java.util.Map;

public class RunsafeEnchantItemEvent extends RunsafeCancellableInventoryEvent
{
	public RunsafeEnchantItemEvent(EnchantItemEvent toWrap)
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

	public int getExpLevelCost()
	{
		return event.getExpLevelCost();
	}

	public void setExpLevelCost(int level)
	{
		event.setExpLevelCost(level);
	}

	public Map<RunsafeEnchantment, Integer> getEnchantsToAdd()
	{
		Map<RunsafeEnchantment, Integer> enchantments = new HashMap<RunsafeEnchantment, Integer>(event.getEnchantsToAdd().size());

		for (Map.Entry<Enchantment, Integer> enchant : event.getEnchantsToAdd().entrySet())
			enchantments.put(ObjectWrapper.convert(enchant.getKey()), enchant.getValue());

		return enchantments;
	}

	public int whichButton()
	{
		return event.whichButton();
	}

	private final EnchantItemEvent event;
}
