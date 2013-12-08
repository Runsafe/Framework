package no.runsafe.framework.api;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.WorldEffect;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import no.runsafe.framework.minecraft.packets.WorldParticleOffset;

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

	void playEffect(WorldEffect effect, int speed, int amount, int range);

	void playEffect(WorldEffect effect, WorldParticleOffset offset, int speed, int amount, int range);

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

	RunsafeChunk getChunk();

	IBlock getBlock();

	ILocation add(ILocation vec);

	ILocation add(double x, double y, double z);

	ILocation subtract(ILocation vec);

	ILocation subtract(double x, double y, double z);

	double length();

	double lengthSquared();

	double distance(ILocation location);

	double distanceSquared(ILocation location);

	ILocation multiply(double factor);

	ILocation zero();
}
