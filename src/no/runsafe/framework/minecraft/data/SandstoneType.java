package no.runsafe.framework.minecraft.data;

public enum SandstoneType
{
	CRACKED(org.bukkit.SandstoneType.CRACKED),
	GLYPHED(org.bukkit.SandstoneType.GLYPHED),
	SMOOTH(org.bukkit.SandstoneType.SMOOTH);

	SandstoneType(org.bukkit.SandstoneType bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.SandstoneType toBukkit()
	{
		return type;
	}

	public static SandstoneType fromBukkit(org.bukkit.SandstoneType bukkitType)
	{
		for (SandstoneType sandstoneType : values())
			if (sandstoneType.toBukkit() == bukkitType)
				return sandstoneType;

		return SMOOTH;
	}

	private final org.bukkit.SandstoneType type;
}
