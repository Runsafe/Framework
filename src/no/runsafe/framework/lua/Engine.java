package no.runsafe.framework.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public class Engine extends OneArgFunction
{
	@Override
	public LuaValue call(LuaValue env)
	{
		LuaEnvironment.global = env.checkglobals();
		LuaEnvironment.loadFile("plugins/runsafe/lua/middleclass.lua");

		return null;
	}
}
