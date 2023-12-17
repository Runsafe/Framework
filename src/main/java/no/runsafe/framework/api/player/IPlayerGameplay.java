package no.runsafe.framework.api.player;

import org.bukkit.GameMode;

import javax.annotation.Nullable;

public interface IPlayerGameplay
{
	boolean isSurvivalist();

	boolean isCreative();

	boolean isAdventurer();

	boolean isSpectator();

	boolean isPvPFlagged();

	boolean canBuildNow();

	void heal(double amount);

	float getXP();

	void setXP(float points);

	int getLevel();

	void setLevel(int level);

	int getOldLevel();

	@Nullable
	GameMode getGameMode();

	void setGameMode(GameMode gameMode);

	int getFoodLevel();

	void setFoodLevel(int level);

	float getSaturation();

	void setSaturation(float saturation);
}
