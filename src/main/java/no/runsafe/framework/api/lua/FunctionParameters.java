package no.runsafe.framework.api.lua;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.internal.brane.Multiverse;
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

	public int parameterCount()
	{
		return parameters.size();
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

	public IPlayer getPlayer(int index)
	{
		IPlayer player = Player.Get().getExact(getString(index));
		if (player == null)
			throw new LuaError(String.format("CommandArgumentSpecification %s at index %d is not a valid player.", getString(index), index));

		return player;
	}

	public IWorld getWorld(int index)
	{
		IWorld world = Multiverse.getInstance().getWorld(getString(index));
		if (world == null)
			throw new LuaError(String.format("CommandArgumentSpecification %s at index %d is not a valid world.", getString(index), index));

		return world;
	}

	public ILocation getLocation(int index)
	{
		return getLocation(index, false);
	}

	public ILocation getLocation(int index, boolean hasPitchAndYaw)
	{
		float yaw = hasPitchAndYaw ? getFloat(index + 4) : 0.0f;
		float pitch = hasPitchAndYaw ? getFloat(index + 5) : 0.0f;
		return getWorld(index).getLocation(getDouble(index + 1), getDouble(index + 2), getDouble(index + 3), yaw, pitch);
	}

	public boolean hasParameter(int index)
	{
		return parameters.size() >= index + 1;
	}

	private final List<LuaValue> parameters = new ArrayList<LuaValue>(0);
}
