package no.runsafe.framework.server.inventory;

import com.google.common.collect.Lists;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.material.RunsafeMaterial;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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

	public void addItems(RunsafeItemStack... items)
	{
		if (items == null || items.length < 1)
			return;
		ItemStack[] itemStacks = new ItemStack[items.length];
		for (int i = 0; i < items.length; ++i)
			itemStacks[i] = items[i].getRaw();
		inventory.addItem(itemStacks);
	}

	public void clear()
	{
		inventory.clear();
	}

	public void clear(int slot)
	{
		inventory.clear(slot);
	}

	public Inventory getRaw()
	{
		return this.inventory;
	}

	public boolean contains(int material)
	{
		return this.inventory.contains(material);
	}

	public boolean contains(int material, int amount)
	{
		return this.inventory.contains(material, amount);
	}

	public boolean contains(RunsafeItemStack itemStack)
	{
		return this.inventory.contains(itemStack.getRaw());
	}

	public boolean contains(RunsafeItemStack itemStack, int amount)
	{
		return this.inventory.contains(itemStack.getRaw(), amount);
	}

	public boolean contains(RunsafeMaterial material)
	{
		return this.inventory.contains(material.getRaw());
	}
	public boolean contains(RunsafeMaterial material, int amount)
	{
		return this.inventory.contains(material.getRaw(), amount);
	}

	public int first(int material)
	{
		return this.inventory.first(material);
	}

	public int first(RunsafeItemStack itemStack)
	{
		return this.inventory.first(itemStack.getRaw());
	}

	public int first(RunsafeMaterial material)
	{
		return this.inventory.first(material.getRaw());
	}

	public int firstEmpty()
	{
		return this.inventory.firstEmpty();
	}

	public int getMaxStackSize()
	{
		return this.inventory.getMaxStackSize();
	}

	public String getName()
	{
		return this.inventory.getName();
	}

	public String getTitle()
	{
		return this.inventory.getTitle();
	}

	public int getSize()
	{
		return this.inventory.getSize();
	}

	public void remove(int material)
	{
		this.inventory.remove(material);
	}

	public void remove(RunsafeItemStack itemStack)
	{
		this.inventory.remove(itemStack.getRaw());
	}

	public void remove(RunsafeMaterial material)
	{
		this.inventory.remove(material.getRaw());
	}

	public void remove(int materialID, int amount)
	{
		int needed = amount;

		for (RunsafeItemStack itemStack : this.getContents())
		{
			if (itemStack.getItemId() == materialID)
			{
				if (itemStack.getAmount() <= needed)
				{
					this.remove(itemStack);
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

	public void setItem(int index, RunsafeItemStack itemStack)
	{
		this.inventory.setItem(index, itemStack.getRaw());
	}

	public void setMaxStackSize(int size)
	{
		this.inventory.setMaxStackSize(size);
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
			RunsafeServer.Instance.getLogger().warning(ExceptionUtils.getFullStackTrace(e));
		}
	}

	private final Inventory inventory;
}
