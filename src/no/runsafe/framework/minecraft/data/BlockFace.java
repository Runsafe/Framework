package no.runsafe.framework.minecraft.data;

public enum BlockFace
{
	DOWN(org.bukkit.block.BlockFace.DOWN),
	EAST(org.bukkit.block.BlockFace.EAST),
	EAST_NORTH_EAST(org.bukkit.block.BlockFace.EAST_NORTH_EAST),
	EAST_SOUTH_EAST(org.bukkit.block.BlockFace.EAST_SOUTH_EAST),
	NORTH(org.bukkit.block.BlockFace.NORTH),
	NORTH_EAST(org.bukkit.block.BlockFace.NORTH_EAST),
	NORTH_NORTH_EAST(org.bukkit.block.BlockFace.NORTH_NORTH_EAST),
	NORTH_NORTH_WEST(org.bukkit.block.BlockFace.NORTH_NORTH_WEST),
	NORTH_WEST(org.bukkit.block.BlockFace.NORTH_WEST),
	SELF(org.bukkit.block.BlockFace.SELF),
	SOUTH(org.bukkit.block.BlockFace.SOUTH),
	SOUTH_EAST(org.bukkit.block.BlockFace.SOUTH_EAST),
	SOUTH_SOUTH_EAST(org.bukkit.block.BlockFace.SOUTH_SOUTH_EAST),
	SOUTH_SOUTH_WEST(org.bukkit.block.BlockFace.SOUTH_SOUTH_WEST),
	SOUTH_WEST(org.bukkit.block.BlockFace.SOUTH_WEST),
	UP(org.bukkit.block.BlockFace.UP),
	WEST(org.bukkit.block.BlockFace.WEST),
	WEST_NORTH_WEST(org.bukkit.block.BlockFace.WEST_NORTH_WEST),
	WEST_SOUTH_WEST(org.bukkit.block.BlockFace.WEST_SOUTH_WEST);

	BlockFace(org.bukkit.block.BlockFace bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.block.BlockFace toBukkit()
	{
		return type;
	}

	public static BlockFace fromBukkit(org.bukkit.block.BlockFace bukkitType)
	{
		for (BlockFace face : values())
			if (face.toBukkit() == bukkitType)
				return face;

		return SELF;
	}

	int getModX()
	{
		return type.getModX();
	}

	int getModY()
	{
		return type.getModY();
	}

	int getModZ()
	{
		return type.getModZ();
	}

	BlockFace getOppositeFace()
	{
		return fromBukkit(type.getOppositeFace());
	}

	private final org.bukkit.block.BlockFace type;
}
