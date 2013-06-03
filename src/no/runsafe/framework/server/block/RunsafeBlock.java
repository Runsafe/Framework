package no.runsafe.framework.server.block;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.server.metadata.RunsafeMetadata;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class RunsafeBlock extends RunsafeMetadata
{
	public RunsafeBlock(Block toWrap)
	{
		super(toWrap);
		block = toWrap;
	}

	public int getData()
	{
		return this.block.getData();
	}

	public boolean is(Item type)
	{
		return this.block.getType() == type.getType()
				&& (type.getData() == (byte) -1 || this.getData() == type.getData());
	}

	public boolean hasInterface()
	{
		return RunsafeBlock.interfaceBlocks.contains(this.getTypeId());
	}

	public boolean isInteractBlock()
	{
		return RunsafeBlock.interactBlocks.contains(this.getTypeId());
	}

	public int getTypeId()
	{
		return block.getTypeId();
	}

	public boolean canPassThrough()
	{
		return passableBlocks.contains(this.getTypeId());
	}

	public void setTypeId(int materialID)
	{
		this.block.setTypeId(materialID);
	}

	public RunsafeWorld getWorld()
	{
		return ObjectWrapper.convert(block.getWorld());
	}

	public RunsafeBlockState getBlockState()
	{
		return ObjectWrapper.convert(block.getState());
	}

	public RunsafeLocation getLocation()
	{
		return ObjectWrapper.convert(block.getLocation());
	}

	public Block getRaw()
	{
		return block;
	}

	public RunsafeMaterial getMaterialType()
	{
		return ObjectWrapper.convert(block.getType());
	}

	public void breakNaturally()
	{
		block.breakNaturally();
	}

	public boolean isHazardous()
	{
		switch (block.getType())
		{
			case LAVA:
			case STATIONARY_LAVA:
			case FIRE:
			case TRIPWIRE:
			case WOOD_PLATE:
			case STONE_PLATE:
				return true;
			default:
				return false;
		}
	}

	public boolean isAir()
	{
		return this.getTypeId() == Material.AIR.getId();
	}

	public boolean isWater()
	{
		return this.getTypeId() == Material.STATIONARY_WATER.getId() || getTypeId() == Material.WATER.getId();
	}

	public boolean isLava()
	{
		return getTypeId() == Material.LAVA.getId() || getTypeId() == Material.STATIONARY_LAVA.getId();
	}

	public boolean isAbleToFall()
	{
		switch (block.getType())
		{
			case SAND:
			case GRAVEL:
			case ANVIL:
				return true;
			default:
				return false;
		}
	}

	private static final ArrayList<Integer> passableBlocks = new ArrayList<Integer>();

	static
	{
		passableBlocks.add(Material.AIR.getId());
		passableBlocks.add(Material.BROWN_MUSHROOM.getId());
		passableBlocks.add(Material.CROPS.getId());
		passableBlocks.add(Material.DEAD_BUSH.getId());
		passableBlocks.add(Material.DETECTOR_RAIL.getId());
		passableBlocks.add(Material.DIODE.getId());
		passableBlocks.add(Material.ENDER_PORTAL.getId());
		passableBlocks.add(Material.FIRE.getId());
		passableBlocks.add(Material.LADDER.getId());
		passableBlocks.add(Material.LAVA.getId());
		passableBlocks.add(Material.LEVER.getId());
		passableBlocks.add(Material.LONG_GRASS.getId());
		passableBlocks.add(Material.MELON_STEM.getId());
		passableBlocks.add(Material.NETHER_WARTS.getId());
		passableBlocks.add(Material.PORTAL.getId());
		passableBlocks.add(Material.POWERED_RAIL.getId());
		passableBlocks.add(Material.PUMPKIN_STEM.getId());
		passableBlocks.add(Material.RAILS.getId());
		passableBlocks.add(Material.REDSTONE_TORCH_OFF.getId());
		passableBlocks.add(Material.REDSTONE_TORCH_ON.getId());
		passableBlocks.add(Material.REDSTONE_WIRE.getId());
		passableBlocks.add(Material.RED_MUSHROOM.getId());
		passableBlocks.add(Material.RED_ROSE.getId());
		passableBlocks.add(Material.SAPLING.getId());
		passableBlocks.add(Material.SIGN_POST.getId());
		passableBlocks.add(Material.SNOW.getId());
		passableBlocks.add(Material.STATIONARY_LAVA.getId());
		passableBlocks.add(Material.STATIONARY_WATER.getId());
		passableBlocks.add(Material.STONE_BUTTON.getId());
		passableBlocks.add(Material.STONE_PLATE.getId());
		passableBlocks.add(Material.SUGAR_CANE_BLOCK.getId());
		passableBlocks.add(Material.TORCH.getId());
		passableBlocks.add(Material.VINE.getId());
		passableBlocks.add(Material.WALL_SIGN.getId());
		passableBlocks.add(Material.WATER.getId());
		passableBlocks.add(Material.WEB.getId());
		passableBlocks.add(Material.WOOD_PLATE.getId());
		passableBlocks.add(Material.YELLOW_FLOWER.getId());
	}

	private static final ArrayList<Integer> interfaceBlocks = new ArrayList<Integer>();

	static
	{
		interfaceBlocks.add(Item.Decoration.Workbench.getTypeID());
		interfaceBlocks.add(Item.Decoration.TrappedChest.getTypeID());
		interfaceBlocks.add(Item.Decoration.Furnace.getTypeID());
		interfaceBlocks.add(Item.Decoration.EnderChest.getTypeID());
		interfaceBlocks.add(Item.Decoration.EnchantmentTable.getTypeID());
		interfaceBlocks.add(Item.Decoration.Anvil.Any.getTypeID());
		interfaceBlocks.add(Item.Brewing.BrewingStand.getTypeID());
		interfaceBlocks.add(Item.Redstone.Device.Hopper.getTypeID());
		interfaceBlocks.add(Item.Redstone.Device.Dropper.getTypeID());
		interfaceBlocks.add(Item.Decoration.Chest.getTypeID());
		interfaceBlocks.add(Item.Redstone.Device.Dispenser.getTypeID());
	}

	private static final ArrayList<Integer> interactBlocks = new ArrayList<Integer>();

	static
	{
		interactBlocks.add(Item.Redstone.Comparator.getTypeID());
		interactBlocks.add(Item.Redstone.Diode.getTypeID());
		interactBlocks.add(Item.Redstone.Lever.getTypeID());
		interactBlocks.add(Item.Redstone.Button.Stone.getTypeID());
		interactBlocks.add(Item.Redstone.Button.Wood.getTypeID());
		interactBlocks.add(Item.Redstone.Device.NoteBlock.getTypeID());
		interactBlocks.add(Item.Redstone.Door.Gate.getTypeID());
		interactBlocks.add(Item.Redstone.Door.Iron.getTypeID());
		interactBlocks.add(Item.Redstone.Door.Trap.getTypeID());
		interactBlocks.add(Item.Redstone.Door.Gate.getTypeID());
		interactBlocks.add(Item.Redstone.Door.Wood.getTypeID());
	}

	private final Block block;
}
