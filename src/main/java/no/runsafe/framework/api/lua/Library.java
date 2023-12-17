package no.runsafe.framework.api.lua;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.internal.lua.GlobalEnvironment;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public abstract class Library extends OneArgFunction
{
	protected Library(RunsafePlugin plugin, String module)
	{
		namespace = plugin.getName();
		this.module = module;
		globals = GlobalEnvironment.get();
	}

	@Override
	public final LuaValue call(LuaValue environment)
	{
		LuaTable lib = getAPI();
		Debug.Global().debugFine("Adding module %s to plugin %s LUA API.", module, namespace);
		environment.get(namespace).set(module, getAPI());
		return lib;
	}

	protected abstract LuaTable getAPI();

	protected final IGlobal globals;
	protected final String namespace;
	protected final String module;
}
