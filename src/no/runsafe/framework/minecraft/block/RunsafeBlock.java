package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.block.BukkitBlock;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.Collection;

public class RunsafeBlock extends BukkitBlock implements IBlock
{
	public RunsafeBlock(Block toWrap)
	{
		super(toWrap);
	}

	@Override
	public boolean is(Item type)
	{
		return block.getType() == type.getType()
			&& (type.getData() == (byte) -1 || getData() == type.getData());
	}

	@Override
	public boolean hasInterface()
	{
		return RunsafeBlock.interfaceBlocks.contains(getTypeId());
	}

	@Override
	public boolean isInteractBlock()
	{
		return RunsafeBlock.interactBlocks.contains(getTypeId());
	}

	@Override
	public boolean canPassThrough()
	{
		return passableBlocks.contains(getTypeId());
	}

	@Override
	@SuppressWarnings("EnumSwitchStatementWhichMissesCases")
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

	@Override
	public boolean isAir()
	{
		return block.getType() == Item.Unavailable.Air.getType();
	}

	@Override
	public boolean isWater()
	{
		return block.getType() == Item.Unavailable.Water.getType()
			|| block.getType() == Item.Unavailable.StationaryWater.getType();
	}

	@Override
	public boolean isLava()
	{
		return block.getType() == Item.Unavailable.Lava.getType()
			|| block.getType() == Item.Unavailable.StationaryLava.getType();
	}

	@Override
	public boolean isAbleToFall()
	{
		return block.getType().hasGravity();
	}

	private static final Collection<Integer> passableBlocks = new ArrayList<Integer>(40);
	private static final Collection<Integer> interfaceBlocks = new ArrayList<Integer>(12);
	private static final Collection<Integer> interactBlocks = new ArrayList<Integer>(12);

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
}
