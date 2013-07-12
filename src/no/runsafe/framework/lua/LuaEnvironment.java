package no.runsafe.framework.lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaEnvironment
{
	static
	{
		LuaValue _G = JsePlatform.standardGlobals();
		_G.load(new Engine());
	}

	public static void loadFile(String file)
	{
		LuaEnvironment.global.get("dofile").call(LuaValue.valueOf(file));
	}

	public static Globals global;
	public static LuaValue env;
}
