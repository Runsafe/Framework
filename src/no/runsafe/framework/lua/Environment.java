package no.runsafe.framework.lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class Environment
{
	static
	{
		LuaValue _G = JsePlatform.standardGlobals();
		_G.load(new Engine());
	}

	public static Globals global;
}
