package no.runsafe.framework.api.lua;

import org.luaj.vm2.LuaValue;

public interface IGlobal
{
	LuaValue get(int key);

	LuaValue get(LuaValue key);

	LuaValue get(String key);

	void set(int key, LuaValue value);

	void set(LuaValue key, LuaValue value);

	void set(String key, LuaValue value);

	void loadFile(String file);
}
