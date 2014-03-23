package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
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

	public boolean containsStrict(RunsafeMeta item, int amount)
	{
		int needed = amount;
		for (int slot = 0; slot < inventory.getSize(); slot++)
		{
			RunsafeMeta itemStack = getItemInSlot(slot);
			if (itemStack == null || itemStack.equals(AIR) || !itemStack.equals(item))
				continue;

			needed -= itemStack.getAmount();
			if (needed <= 0)
				return true;
		}
		return false;
	}

	public void removeItemInSlot(int slot)
	{
		setItemInSlot(AIR, slot);
	}

	public void setItemInSlot(RunsafeMeta item, int slot)
	{
		inventory.setItem(slot, item.getRaw());
	}

	public RunsafeMeta getItemInSlot(int slot)
	{
		return ObjectWrapper.convert(inventory.getItem(slot));
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	public void remove(Item item, int amount)
	{
		int needed = amount;
		for (int slot = 0; slot < inventory.getSize(); slot++)
		{
			RunsafeMeta itemStack = getItemInSlot(slot);
			if (itemStack == null || !itemStack.is(item))
				continue;

			if (itemStack.getAmount() <= needed)
			{
				needed -= itemStack.getAmount();
				removeItemInSlot(slot);

				if (needed == 0)
					break;
			}
			else
			{
				itemStack.setAmount(itemStack.getAmount() - needed);
				break;
			}
		}
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	public void removeExact(RunsafeMeta meta, int amount)
	{
		int needed = amount;
		for (int slot = 0; slot < inventory.getSize(); slot++)
		{
			RunsafeMeta itemStack = getItemInSlot(slot);

			if (itemStack == null || itemStack.equals(AIR))
				continue;

			RunsafeMeta cloneStack = itemStack.clone();
			cloneStack.setAmount(meta.getAmount());

			if (!cloneStack.equals(meta))
				continue;

			if (itemStack.getAmount() <= needed)
			{
				needed -= itemStack.getAmount();
				removeItemInSlot(slot);

				if (needed == 0)
					break;
			}
			else
			{
				itemStack.setAmount(itemStack.getAmount() - needed);
				break;
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

	private static final RunsafeMeta AIR = Item.Unavailable.Air.getItem();
}
