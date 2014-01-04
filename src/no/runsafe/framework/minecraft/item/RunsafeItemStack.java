package no.runsafe.framework.minecraft.item;

import net.minecraft.server.v1_7_R1.NBTTagCompound;
import no.runsafe.framework.api.ITagObject;
import no.runsafe.framework.api.minecraft.IEnchant;
import no.runsafe.framework.api.minecraft.IEnchantable;
import no.runsafe.framework.internal.tag.TagHelper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.item.BukkitItemStack;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class RunsafeItemStack extends BukkitItemStack implements IEnchantable, ITagObject
{
	public static RunsafeMeta deserialize(Map<String, Object> args)
	{
		return ObjectWrapper.convert(ItemStack.deserialize(args));
	}

	protected RunsafeItemStack(ItemStack stack)
	{
		super(stack);
	}

	public String getNormalName()
	{
		return getType().name().replace("_", " ").toLowerCase();
	}

	public static List<RunsafeMeta> convert(ItemStack... items)
	{
		List<RunsafeMeta> result = new ArrayList<RunsafeMeta>(items.length);
		for (ItemStack item : items)
			result.add(ObjectWrapper.convert(item));
		return result;
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public boolean is(Item type)
	{
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

	public Item getItemType()
	{
		return Item.get(itemStack.getType(), itemStack.getData().getData());
	}

	@SuppressWarnings({"CloneDoesntCallSuperClone", "CloneDoesntDeclareCloneNotSupportedException"})
	@Override
	public RunsafeMeta clone()
	{
		return ObjectWrapper.convert(itemStack.clone());
	}

	@Override
	public NBTTagCompound getTagCompound()
	{
		return TagHelper.getCompound(this);
	}

	@Override
	public void setTagCompound(NBTTagCompound compound)
	{
		TagHelper.setCompound(this, compound);
	}
}
