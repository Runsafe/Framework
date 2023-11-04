package no.runsafe.framework.internal.wrapper.block;

import net.minecraft.server.v1_12_R1.BlockPosition;
import net.minecraft.server.v1_12_R1.Blocks;
import net.minecraft.server.v1_12_R1.IBlockData;
import net.minecraft.server.v1_12_R1.World;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.internal.lua.GlobalEnvironment;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_12_R1.block.CraftBlock;

public class BukkitBlock extends BukkitMetadata
{
	protected BukkitBlock(Block toWrap)
	{
		super(toWrap);
		block = toWrap;
	}

	public byte getData()
	{
		return block.getData();
	}

	/**
	 * @deprecated Do not use this, setType with a material instead
	 */
	@Deprecated
	public void setData(byte data)
	{
		IConsole console = Console.Global();
		console.logInformation(
			"setting bukkit block %d,%d,%d@%s to %d",
			block.getX(), block.getY(), block.getZ(), block.getWorld().getName(),
			data
		);
		block.setData(data);
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public void set(Item type)
	{
		IConsole console = Console.Global();
		org.bukkit.Material material = type.getType();
		console.logInformation(
			"setting bukkit block %d,%d,%d@%s to %s on thread %d %s",
			block.getX(), block.getY(), block.getZ(), block.getWorld().getName(),
			material.name(), Thread.currentThread().getId(), Thread.currentThread().getName()
		);

		block.getLocation().getChunk().load(); //.setForceLoaded(true);
		block.setType(material, false);

		console.logInformation(
			"bukkit block %d,%d,%d@%s is %s on thread %d %s",
			block.getX(), block.getY(), block.getZ(), block.getWorld().getName(),
			block.getType().name(), Thread.currentThread().getId(), Thread.currentThread().getName()
		);
	}

	@Deprecated
	public int getTypeId()
	{
		return LegacyMaterial.getIdOf(block.getType());
	}

	@Deprecated
	public void setTypeId(int materialID)
	{
		block.setType(LegacyMaterial.getById(materialID));
	}

	public IWorld getWorld()
	{
		return ObjectWrapper.convert(block.getWorld());
	}

	public ILocation getLocation()
	{
		return ObjectWrapper.convert(block.getLocation());
	}

	@Override
	public Block getRaw()
	{
		return block;
	}

	public Item getMaterial()
	{
		return Item.get(block.getType(), block.getData());
	}

	public void setMaterial(Item material)
	{
		block.setType(material.getType());
		if (material.getData() >= 0)
			block.setData(material.getData());
	}

	public void breakNaturally()
	{
		block.breakNaturally();
	}

	public int getRedstonePower()
	{
		return block.getBlockPower();
	}

	protected final Block block;
}
