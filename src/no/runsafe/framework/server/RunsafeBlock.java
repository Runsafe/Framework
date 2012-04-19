package no.runsafe.framework.server;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class RunsafeBlock
{
	public RunsafeBlock(Block toWrap)
	{
		block = toWrap;
	}

	public int getTypeId()
	{
		return block.getTypeId();
	}

	public boolean canPassThrough()
	{
		if (passableBlocks.contains(this.getTypeId()))
			return true;

		return false;
	}

	public void setTypeId(int materialID)
	{
		this.block.setTypeId(materialID);
	}

	public Block getRaw()
	{
		return block;
	}

	public boolean isHazardous()
	{
		int blockType = this.getTypeId();

		if (blockType == Material.LAVA.getId() ||
			blockType == Material.STATIONARY_LAVA.getId() ||
			blockType == Material.FIRE.getId())
			return true;

		return false;
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

	private Block block;
}
