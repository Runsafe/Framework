package no.runsafe.framework.api;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.util.Vector;

import java.util.List;

public interface ILocation
{
	ILocation findTop();

	void incrementX(double x);

	void incrementY(double y);

	void incrementZ(double z);

	void decrementX(double x);

	void decrementY(double y);

	void decrementZ(double z);

	void playSound(Sound sound);

	void playSound(Sound sound, float volume, float pitch);

	void offset(double x, double y, double z);

	List<IPlayer> getPlayersInRange(double range);

	double getX();

	double getY();

	double getZ();

	void setYaw(float yaw);

	void setPitch(float pitch);

	float getYaw();

	float getPitch();

	void setX(double x);

	void setY(double y);

	void setZ(double z);

	IWorld getWorld();

	int getBlockX();

	int getBlockY();

	int getBlockZ();

	IChunk getChunk();

	IBlock getBlock();

	double length();

	double lengthSquared();

	double distance(ILocation location);

	double distanceSquared(ILocation location);

	ILocation multiply(double factor);

	ILocation zero();

	@SuppressWarnings("CloneDoesntDeclareCloneNotSupportedException")
	ILocation clone();

	void playEffect(IWorldEffect effect, float speed, int particleAmount, double range);

	void playEffect(IWorldEffect effect, int particleAmount, double range);

	Vector getDirection();
}
