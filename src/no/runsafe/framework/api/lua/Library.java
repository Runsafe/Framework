package no.runsafe.framework.api.lua;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.minecraft.RunsafeServer;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public abstract class Library extends OneArgFunction
{
	protected Library(RunsafePlugin plugin, String module)
	{
		namespace = plugin.getName();
		this.module = module;
	}

	@Override
	public final LuaValue call(LuaValue environment)
	{
		LuaTable lib = getAPI();
		RunsafeServer.Instance.getDebugger().debugFine("Adding module %s to plugin %s LUA API.", module, namespace);
		environment.get(namespace).set(module, getAPI());
		return lib;
	}

	protected abstract LuaTable getAPI();

	private final String namespace;
	private final String module;
}
