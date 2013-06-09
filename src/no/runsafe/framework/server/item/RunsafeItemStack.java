package no.runsafe.framework.server.item;

import no.runsafe.framework.enchant.IEnchant;
import no.runsafe.framework.enchant.IEnchantable;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.wrapper.item.BukkitItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class RunsafeItemStack extends BukkitItemStack implements IEnchantable
{
	public static RunsafeItemStack deserialize(Map<String, Object> args)
	{
		return ObjectWrapper.convert(ItemStack.deserialize(args));
	}

	public RunsafeItemStack(ItemStack stack)
	{
		super(stack);
	}

	@Deprecated
	public RunsafeItemStack(int itemId)
	{
		super(new ItemStack(itemId));
	}

	@Deprecated
	public RunsafeItemStack(int itemId, int amount)
	{
		super(new ItemStack(itemId, amount));
	}

	@Deprecated
	public RunsafeItemStack(int materialId, int amount, short durability)
	{
		super(new ItemStack(materialId, amount, durability));
	}

	@Deprecated
	public RunsafeItemStack(int materialId, int amount, short durability, Byte data)
	{
		super(new ItemStack(materialId, amount, durability));
		itemStack.setData(new MaterialData(Material.getMaterial(materialId), data));
	}

	public String getNormalName()
	{
		return this.getType().name().replace("_", " ").toLowerCase();
	}

	public static List<RunsafeItemStack> convert(ItemStack[] items)
	{
		ArrayList<RunsafeItemStack> result = new ArrayList<RunsafeItemStack>();
		for (ItemStack item : items)
			result.add(ObjectWrapper.convert(item));
		return result;
	}

	public boolean is(Item type)
	{
		RunsafeServer.Instance.getLogger().info(
			String.format(
				"ItemStack(%s,%d) is Item(%s,%d)?",
				itemStack.getType().name(), itemStack.getData().getData(),
				type.getType().name(), type.getData()
			)
		);
		return itemStack.getType() == type.getType()
			&& (type.getData() == (byte) -1 || itemStack.getData().getData() == type.getData());
	}

	@Override
	public boolean enchanted()
	{
		return itemStack.getEnchantments() != null && !itemStack.getEnchantments().isEmpty();
	}

	@Override
	public boolean enchanted(IEnchant enchant)
	{
		return itemStack.containsEnchantment(enchant.getEnchant().getRaw());
	}

	@Override
	public IEnchantable enchant(IEnchant enchant)
	{
		if (enchant.canEnchant(this))
			itemStack.addEnchantment(enchant.getEnchant().getRaw(), enchant.power());
		return this;
	}

	@Override
	public IEnchantable enchant(Iterable<IEnchant> enchants)
	{
		for (IEnchant enchant : enchants)
			enchant(enchant);
		return this;
	}

	@Override
	public IEnchantable disenchant()
	{
		for (Enchantment enchant : itemStack.getEnchantments().keySet())
			itemStack.removeEnchantment(enchant);
		return this;
	}

	@Override
	public IEnchantable disenchant(IEnchant enchant)
	{
		if (itemStack.containsEnchantment(enchant.getEnchant().getRaw()))
			itemStack.removeEnchantment(enchant.getEnchant().getRaw());
		return this;
	}

	@Override
	public RunsafeItemStack getItem()
	{
		return this;
	}

	public Item getItemType()
	{
		return Item.get(itemStack.getType(), itemStack.getData().getData());
	}

	public RunsafeItemStack clone()
	{
		return ObjectWrapper.convert(itemStack.clone());
	}
}
