package no.runsafe.framework.api.lua;

import org.luaj.vm2.LuaValue;

public interface IGlobal
{
	LuaValue get(int value);

	LuaValue get(LuaValue value);

	LuaValue get(String value);

	void loadFile(String file);
}
