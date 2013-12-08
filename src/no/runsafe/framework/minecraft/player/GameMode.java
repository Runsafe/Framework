package no.runsafe.framework.minecraft.player;

import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;

public enum GameMode
{
	Survival(org.bukkit.GameMode.SURVIVAL),
	Creative(org.bukkit.GameMode.CREATIVE),
	Adventure(org.bukkit.GameMode.ADVENTURE);

	@Nullable
	public static GameMode search(String name)
	{
		for (GameMode gameMode : values())
			if (gameMode.name().toLowerCase().startsWith(name.toLowerCase()))
				return gameMode;
		return null;
	}

	public void apply(IPlayer player)
	{
		player.setGameMode(mode);
	}

	GameMode(org.bukkit.GameMode mode)
	{
		this.mode = mode;
	}

	private final org.bukkit.GameMode mode;
}
