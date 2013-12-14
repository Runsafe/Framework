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

	@SuppressWarnings("InstanceMethodNamingConvention")
	@Override
	public boolean is(Item type)
	{
		return block.getType() == type.getType()
			&& (type.getData() == (byte) -1 || getData() == type.getData());
	}

	@Override
	public boolean isAny(Item... type)
	{
		if(type.length == 0)
			return false;

		for(Item test : type)
			if(is(test))
				return true;

		return false;
	}

	@Override
	public boolean hasInterface()
	{
		return RunsafeBlock.interfaceBlocks.contains(block.getType());
	}

	@Override
	public boolean isInteractBlock()
	{
		return RunsafeBlock.interactBlocks.contains(block.getType());
	}

	@Override
	public boolean canPassThrough()
	{
		return passableBlocks.contains(block.getType());
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

	private static final Collection<Material> passableBlocks = new ArrayList<Material>(40);
	private static final Collection<Material> interfaceBlocks = new ArrayList<Material>(12);
	private static final Collection<Material> interactBlocks = new ArrayList<Material>(12);

	static
	{
		passableBlocks.add(Material.AIR);
		passableBlocks.add(Material.BROWN_MUSHROOM);
		passableBlocks.add(Material.CROPS);
		passableBlocks.add(Material.DEAD_BUSH);
		passableBlocks.add(Material.DETECTOR_RAIL);
		passableBlocks.add(Material.DIODE);
		passableBlocks.add(Material.ENDER_PORTAL);
		passableBlocks.add(Material.FIRE);
		passableBlocks.add(Material.LADDER);
		passableBlocks.add(Material.LAVA);
		passableBlocks.add(Material.LEVER);
		passableBlocks.add(Material.LONG_GRASS);
		passableBlocks.add(Material.MELON_STEM);
		passableBlocks.add(Material.NETHER_WARTS);
		passableBlocks.add(Material.PORTAL);
		passableBlocks.add(Material.POWERED_RAIL);
		passableBlocks.add(Material.PUMPKIN_STEM);
		passableBlocks.add(Material.RAILS);
		passableBlocks.add(Material.REDSTONE_TORCH_OFF);
		passableBlocks.add(Material.REDSTONE_TORCH_ON);
		passableBlocks.add(Material.REDSTONE_WIRE);
		passableBlocks.add(Material.RED_MUSHROOM);
		passableBlocks.add(Material.RED_ROSE);
		passableBlocks.add(Material.SAPLING);
		passableBlocks.add(Material.SIGN_POST);
		passableBlocks.add(Material.SNOW);
		passableBlocks.add(Material.STATIONARY_LAVA);
		passableBlocks.add(Material.STATIONARY_WATER);
		passableBlocks.add(Material.STONE_BUTTON);
		passableBlocks.add(Material.STONE_PLATE);
		passableBlocks.add(Material.SUGAR_CANE_BLOCK);
		passableBlocks.add(Material.TORCH);
		passableBlocks.add(Material.VINE);
		passableBlocks.add(Material.WALL_SIGN);
		passableBlocks.add(Material.WATER);
		passableBlocks.add(Material.WEB);
		passableBlocks.add(Material.WOOD_PLATE);
		passableBlocks.add(Material.YELLOW_FLOWER);

		interfaceBlocks.add(Item.Decoration.Workbench.getType());
		interfaceBlocks.add(Item.Decoration.TrappedChest.getType());
		interfaceBlocks.add(Item.Decoration.Furnace.getType());
		interfaceBlocks.add(Item.Decoration.EnderChest.getType());
		interfaceBlocks.add(Item.Decoration.EnchantmentTable.getType());
		interfaceBlocks.add(Item.Decoration.Anvil.Any.getType());
		interfaceBlocks.add(Item.Brewing.BrewingStand.getType());
		interfaceBlocks.add(Item.Redstone.Device.Hopper.getType());
		interfaceBlocks.add(Item.Redstone.Device.Dropper.getType());
		interfaceBlocks.add(Item.Decoration.Chest.getType());
		interfaceBlocks.add(Item.Redstone.Device.Dispenser.getType());

		interactBlocks.add(Item.Redstone.Comparator.getType());
		interactBlocks.add(Item.Redstone.Diode.getType());
		interactBlocks.add(Item.Redstone.Lever.getType());
		interactBlocks.add(Item.Redstone.Button.Stone.getType());
		interactBlocks.add(Item.Redstone.Button.Wood.getType());
		interactBlocks.add(Item.Redstone.Device.NoteBlock.getType());
		interactBlocks.add(Item.Redstone.Door.Gate.getType());
		interactBlocks.add(Item.Redstone.Door.Iron.getType());
		interactBlocks.add(Item.Redstone.Door.Trap.getType());
		interactBlocks.add(Item.Redstone.Door.Gate.getType());
		interactBlocks.add(Item.Redstone.Door.Wood.getType());
	}
}
