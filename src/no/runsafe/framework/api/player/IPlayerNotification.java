package no.runsafe.framework.api.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.minecraft.Sound;

public interface IPlayerNotification
{
	void sendColouredMessage(String format, Object... params);

	void sendTitle(String title, String subtitle);

	void resetTitle();

	void sendBlockChange(IBlock block, byte data);

	void sendBlockChange(ILocation location, int itemId, byte data);

	void sendSignChange(ILocation location, String line1, String line2, String line3, String line4);

	void setCompassTarget(ILocation location);

	ILocation getCompassTarget();

	void playSound(Sound sound);

	void playSound(Sound sound, float volume, float pitch);
}
