package no.runsafe.framework.server.inventory;

import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class RunsafePlayerInventory extends RunsafeInventory
{
	public RunsafePlayerInventory(PlayerInventory toWrap)
	{
		super(toWrap);
		inventory = toWrap;
	}

	public List<RunsafeItemStack> getArmorContents()
	{
		return RunsafeItemStack.convert(inventory.getArmorContents());
	}

	public RunsafeItemStack getHelmet()
	{
		return new RunsafeItemStack(inventory.getHelmet());
	}

	public RunsafeItemStack getChestplate()
	{
		return new RunsafeItemStack(inventory.getChestplate());
	}

	public RunsafeItemStack getLeggings()
	{
		return new RunsafeItemStack(inventory.getLeggings());
	}

	public RunsafeItemStack getBoots()
	{
		return new RunsafeItemStack(inventory.getBoots());
	}

	public void setArmorContents(List<RunsafeItemStack> itemStacks)
	{
		ItemStack[] stacks = new ItemStack[itemStacks.size()];
		for (int i = 0; i < itemStacks.size(); ++i)
			stacks[i] = itemStacks.get(i).getRaw();
		inventory.setArmorContents(stacks);
	}

	public void setHelmet(RunsafeItemStack itemStack)
	{
		inventory.setHelmet(itemStack.getRaw());
	}

	public void setChestplate(RunsafeItemStack itemStack)
	{
		inventory.setChestplate(itemStack.getRaw());
	}

	public void setLeggings(RunsafeItemStack itemStack)
	{
		inventory.setLeggings(itemStack.getRaw());
	}

	public void setBoots(RunsafeItemStack itemStack)
	{
		inventory.setBoots(itemStack.getRaw());
	}

	public RunsafeItemStack getItemInHand()
	{
		return new RunsafeItemStack(inventory.getItemInHand());
	}

	public void setItemInHand(RunsafeItemStack itemStack)
	{
		inventory.setItemInHand(itemStack.getRaw());
	}

	public int getHeldItemSlot()
	{
		return inventory.getHeldItemSlot();
	}

	public void clear()
	{
		super.clear();
		inventory.setArmorContents(new ItemStack[4]);
	}

	public String serialize()
	{
		YamlConfiguration serialize = new YamlConfiguration();
		ConfigurationSection contents = serialize.createSection("contents");
		ConfigurationSection armour = serialize.createSection("armour");
		int index = 0;
		for (ItemStack item : inventory.getContents())
		{
			contents.set(String.valueOf(index), item);
			index++;
		}
		armour.set("helmet", inventory.getHelmet());
		armour.set("chestplate", inventory.getChestplate());
		armour.set("leggings", inventory.getLeggings());
		armour.set("boots", inventory.getBoots());
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
			ConfigurationSection armour = unserialize.getConfigurationSection("armour");
			for (String index : contents.getKeys(false))
				inventory.setItem(Integer.valueOf(index), contents.getItemStack(index));
			inventory.setHelmet(armour.getItemStack("helmet"));
			inventory.setChestplate(armour.getItemStack("chestplate"));
			inventory.setLeggings(armour.getItemStack("leggings"));
			inventory.setBoots(armour.getItemStack("boots"));
		}
		catch (InvalidConfigurationException e)
		{
			RunsafeServer.Instance.getLogger().warning(ExceptionUtils.getFullStackTrace(e));
		}
	}

	private final PlayerInventory inventory;
}
