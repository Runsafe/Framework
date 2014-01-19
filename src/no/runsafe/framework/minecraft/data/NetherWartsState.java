package no.runsafe.framework.minecraft.data;

public enum NetherWartsState
{
	RIPE(org.bukkit.NetherWartsState.RIPE),
	SEEDED(org.bukkit.NetherWartsState.SEEDED),
	STAGE_ONE(org.bukkit.NetherWartsState.STAGE_ONE),
	STAGE_TWO(org.bukkit.NetherWartsState.STAGE_TWO);

	NetherWartsState(org.bukkit.NetherWartsState bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.NetherWartsState toBukkit()
	{
		return type;
	}

	public static NetherWartsState fromBukkit(org.bukkit.NetherWartsState bukkitType)
	{
		for (NetherWartsState state : values())
			if (state.toBukkit() == bukkitType)
				return state;

		return SEEDED;
	}

	private final org.bukkit.NetherWartsState type;
}
