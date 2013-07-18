package no.runsafe.framework.api.lua;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;

import java.util.ArrayList;
import java.util.List;

public class FunctionParameters
{
	public void addParameter(LuaValue value)
	{
		parameters.add(value);
	}

	private LuaValue getLuaValue(int index)
	{
		if (parameters.size() < index - 1)
			throw new LuaError("Function contains an invalid amount of parameters");

		return parameters.get(index);
	}

	public String getString(int index)
	{
		return getLuaValue(index).toString();
	}

	public Double getDouble(int index)
	{
		return getLuaValue(index).todouble();
	}

	public Integer getInt(int index)
	{
		return getLuaValue(index).toint();
	}

	public Boolean getBool(int index)
	{
		return getLuaValue(index).toboolean();
	}

	public Float getFloat(int index)
	{
		return getLuaValue(index).tofloat();
	}

	public Short getShort(int index)
	{
		return getLuaValue(index).toshort();
	}

	public Byte getByte(int index)
	{
		return getLuaValue(index).tobyte();
	}

	public RunsafePlayer getPlayer(int index)
	{
		RunsafePlayer player = RunsafeServer.Instance.getOfflinePlayerExact(getString(index));
		if (player == null)
			throw new LuaError(String.format("Argument %s at index %d is not a valid player.", getString(index), index));

		return player;
	}

	public RunsafeWorld getWorld(int index)
	{
		RunsafeWorld world = RunsafeServer.Instance.getWorld(getString(index));
		if (world == null)
			throw new LuaError(String.format("Argument %s at index %d is not a valid world.", getString(index), index));

		return world;
	}

	public RunsafeLocation getLocation(int index)
	{
		return getLocation(index, false);
	}

	public RunsafeLocation getLocation(int index, boolean hasPitchAndYaw)
	{
		float yaw = hasPitchAndYaw ? getFloat(index + 4) : 0;
		float pitch = hasPitchAndYaw ? getFloat(index + 5) : 0;
		return new RunsafeLocation(getWorld(index), getDouble(index + 1), getDouble(index + 2), getDouble(index + 3), yaw, pitch);
	}

	public boolean hasParameter(int index)
	{
		return parameters.size() >= index + 1;
	}

	private final List<LuaValue> parameters = new ArrayList<LuaValue>();
}
