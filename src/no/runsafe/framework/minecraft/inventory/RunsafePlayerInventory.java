package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.internal.wrapper.inventory.BukkitPlayerInventory;
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

	@Override
	public String serialize()
	{
		YamlConfiguration serialize = new YamlConfiguration();
		ConfigurationSection contents = serialize.createSection("contents");
		ConfigurationSection armour = serialize.createSection("armour");
		int index = 0;
		for (ItemStack item : playerInventory.getContents())
		{
			contents.set(String.valueOf(index), item);
			index++;
		}
		armour.set("helmet", playerInventory.getHelmet());
		armour.set("chestplate", playerInventory.getChestplate());
		armour.set("leggings", playerInventory.getLeggings());
		armour.set("boots", playerInventory.getBoots());
		return serialize.saveToString();
	}

	@Override
	public void unserialize(String serialized)
	{
		playerInventory.clear();
		try
		{
			YamlConfiguration unserialize = new YamlConfiguration();
			unserialize.loadFromString(serialized);
			ConfigurationSection contents = unserialize.getConfigurationSection("contents");
			ConfigurationSection armour = unserialize.getConfigurationSection("armour");
			for (String index : contents.getKeys(false))
				playerInventory.setItem(Integer.valueOf(index), contents.getItemStack(index));
			playerInventory.setHelmet(armour.getItemStack("helmet"));
			playerInventory.setChestplate(armour.getItemStack("chestplate"));
			playerInventory.setLeggings(armour.getItemStack("leggings"));
			playerInventory.setBoots(armour.getItemStack("boots"));
		}
		catch (InvalidConfigurationException e)
		{
			Console.Global().logException(e);
		}
	}
}
