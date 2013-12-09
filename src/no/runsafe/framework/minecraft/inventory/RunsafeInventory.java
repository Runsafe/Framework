package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.internal.wrapper.inventory.BukkitInventory;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RunsafeInventory extends BukkitInventory
{
	public RunsafeInventory(Inventory toWrap)
	{
		super(toWrap);
	}

	public void remove(Item item, int amount)
	{
		int needed = amount;
		for (RunsafeMeta itemStack : getContents())
		{
			if (itemStack.is(item))
			{
				if (itemStack.getAmount() <= needed)
				{
					inventory.remove(itemStack.getRaw());
					needed -= itemStack.getAmount();
				}
				else
				{
					itemStack.setAmount(itemStack.getAmount() - needed);
					break;
				}
			}
		}
	}

	public int getAmountOfItem(Item item)
	{
		int amount = 0;
		for (RunsafeMeta meta : getContents())
			if (meta.is(item))
				amount += meta.getAmount();

		return amount;
	}

	public String serialize()
	{
		YamlConfiguration serialize = new YamlConfiguration();
		ConfigurationSection contents = serialize.createSection("contents");

		int index = 0;
		for (ItemStack item : inventory.getContents())
		{
			contents.set(String.valueOf(index), item);
			index++;
		}
		return serialize.saveToString();
	}

	public void unserialize(String serialized)
	{
		inventory.clear();
		if (serialized == null)
			return;
		try
		{
			YamlConfiguration unserialize = new YamlConfiguration();
			unserialize.loadFromString(serialized);
			ConfigurationSection contents = unserialize.getConfigurationSection("contents");
			for (String index : contents.getKeys(false))
				inventory.setItem(Integer.valueOf(index), contents.getItemStack(index));
		}
		catch (InvalidConfigurationException e)
		{
			Console.Global().logException(e);
		}
	}
}
