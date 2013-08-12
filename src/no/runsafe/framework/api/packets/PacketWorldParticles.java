package no.runsafe.framework.api.packets;

import no.runsafe.framework.internal.packets.Packet;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.WorldEffect;

import java.util.HashMap;

public class PacketWorldParticles extends Packet
{
	public PacketWorldParticles(RunsafeLocation location, WorldEffect worldEffect, int speed, int amount, int range)
	{
		super("Packet63WorldParticles");
		this.location = location;
		this.worldEffect = worldEffect;
		this.speed = speed;
		this.amount = amount;
		this.range = range;
		offsetX = (float) location.getX();
		offsetY = (float) location.getY();
		offsetZ = (float) location.getZ();
	}

	public void setOffsetX(float offset)
	{
		offsetX = offset;
	}

	public void setOffsetY(float offset)
	{
		offsetY = offset;
	}

	public void setOffsetZ(float offset)
	{
		offsetZ = offset;
	}

	@Override
	public HashMap<String, Object> prepareData()
	{
		HashMap<String, Object> data = new HashMap<String, Object>(9);
		data.put("a", worldEffect.getName());
		data.put("b", (float) location.getX());
		data.put("c", (float) location.getY());
		data.put("d", (float) location.getZ());
		data.put("e", offsetX);
		data.put("f", offsetY);
		data.put("g", offsetZ);
		data.put("h", speed);
		data.put("i", amount);

		return data;
	}

	private RunsafeLocation location;
	private WorldEffect worldEffect;
	private int speed;
	private int amount;
	private int range;
	private float offsetX;
	private float offsetY;
	private float offsetZ;
}
