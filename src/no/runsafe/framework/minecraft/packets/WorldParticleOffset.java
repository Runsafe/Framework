package no.runsafe.framework.minecraft.packets;

import java.util.Random;

public class WorldParticleOffset
{
	public WorldParticleOffset(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public WorldParticleOffset()
	{
		Random random = new Random();
		x = random.nextFloat();
		y = random.nextFloat();
		z = random.nextFloat();
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public float getZ()
	{
		return z;
	}

	private final float x;
	private final float y;
	private final float z;
}
