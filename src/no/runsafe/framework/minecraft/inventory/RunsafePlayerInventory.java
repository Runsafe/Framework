package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.internal.wrapper.inventory.BukkitPlayerInventory;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class RunsafePlayerInventory extends BukkitPlayerInventory
{
	public RunsafePlayerInventory(PlayerInventory toWrap)
	{
		super(toWrap);
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
}
