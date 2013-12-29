package no.runsafe.framework.minecraft;

public enum WorldBlockEffectType
{
	IRON_CRACK("ironcrack_"),
	BLOCK_CRACK("blockcrack_"),
	BLOCK_DUST("blockdust_");

	WorldBlockEffectType(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	private final String name;
}
