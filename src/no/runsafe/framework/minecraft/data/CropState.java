package no.runsafe.framework.minecraft.data;

public enum CropState
{
	GERMINATED(org.bukkit.CropState.GERMINATED),
	MEDIUM(org.bukkit.CropState.MEDIUM),
	RIPE(org.bukkit.CropState.RIPE),
	SEEDED(org.bukkit.CropState.SEEDED),
	SMALL(org.bukkit.CropState.SMALL),
	TALL(org.bukkit.CropState.TALL),
	VERY_SMALL(org.bukkit.CropState.VERY_SMALL),
	VERY_TALL(org.bukkit.CropState.VERY_TALL);

	CropState(org.bukkit.CropState bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.CropState toBukkit()
	{
		return type;
	}

	public static CropState fromBukkit(org.bukkit.CropState bukkitState)
	{
		for (CropState state : values())
			if (state.toBukkit() == bukkitState)
				return state;

		return SMALL;
	}

	private final org.bukkit.CropState type;
}
