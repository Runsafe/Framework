package no.runsafe.framework.api.item;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public enum BuildingBlock implements IMaterial
{
	Stone(Material.STONE),
	Grass(Material.GRASS),
	Dirt(Material.DIRT),
	Cobblestone(Material.COBBLESTONE),
	Bedrock(Material.BEDROCK),
	Sand(Material.SAND),
	Gravel(Material.GRAVEL),
	Sponge(Material.SPONGE),
	Glass(Material.GLASS),
	LapisLazuli(Material.LAPIS_BLOCK),
	GoldBlock(Material.GOLD_BLOCK),
	IronBlock(Material.IRON_BLOCK),
	Brick(Material.BRICK),
	Bookshelf(Material.BOOKSHELF),
	MossyCobblestone(Material.MOSSY_COBBLESTONE),
	Obsidian(Material.OBSIDIAN),
	Diamond(Material.DIAMOND_BLOCK),
	Ice(Material.ICE),
	Snow(Material.SNOW_BLOCK),
	Clay(Material.CLAY),
	Pumpkin(Material.PUMPKIN),
	Netherrack(Material.NETHERRACK),
	Soulsand(Material.SOUL_SAND),
	Glowstone(Material.GLOWSTONE),
	JackOLantern(Material.JACK_O_LANTERN),
	Melon(Material.MELON_BLOCK),
	Mycelium(Material.MYCEL),
	NetherBrick(Material.NETHER_BRICK),
	EndStone(Material.ENDER_STONE),
	Emerald(Material.EMERALD_BLOCK),
	CoalBlock(Material.COAL_BLOCK),
	OakStair(Material.WOOD_STAIRS),
	SpruceStair(Material.SPRUCE_WOOD_STAIRS),
	BirchStair(Material.BIRCH_WOOD_STAIRS),
	JungleStair(Material.JUNGLE_WOOD_STAIRS),
	CobblestoneStair(Material.COBBLESTONE_STAIRS),
	BrickStair(Material.BRICK_STAIRS),
	StoneBrickStair(Material.SMOOTH_STAIRS),
	NetherBrickStair(Material.NETHER_BRICK_STAIRS),
	QuartzStair(Material.QUARTZ_STAIRS),
	SandstoneStair(Material.SANDSTONE_STAIRS);

	BuildingBlock(Material material)
	{
		kind = material;
	}

	@Override
	public Material getMaterial()
	{
		return kind;
	}

	@Override
	public String getName()
	{
		return name();
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		return material != kind;
	}

	private final Material kind;

	static void register()
	{
		Configurable.addSimple(values());
	}
}
