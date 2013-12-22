package no.runsafe.framework.internal.lua;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.lua.IGlobal;
import no.runsafe.framework.api.lua.Library;
import no.runsafe.framework.internal.InjectionPlugin;
import org.apache.commons.io.FileUtils;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaTable;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PluginRunner
{
	public PluginRunner(IGlobal global, IDebug debugger, IConsole console, InjectionPlugin plugin)
	{
		this.global = global;
		this.debugger = debugger;
		this.console = console;
		this.plugin = plugin;
	}

	public void loadAPI()
	{
		List<Library> libraries = plugin.getComponents(Library.class);
		if (!libraries.isEmpty())
		{
			debugger.debugFine("Adding plugin namespace %s to LUA environment", plugin.getName());
			global.set(plugin.getName(), new LuaTable());
			for (Library library : libraries)
				GlobalEnvironment.global().load(library);
		}
	}

	public void loadScripts()
	{
		for (File script : getScripts())
			if (script.isFile())
			{
				console.logInformation("Loading script %s", script.getName());
				try
				{
					global.loadFile(script.getAbsolutePath());
				}
				catch (LuaError error)
				{
					console.logException(error);
				}
			}
	}

	private Collection<File> getScripts()
	{
		File data = plugin.getDataFolder();
		if (!(data.exists() && data.isDirectory()))
			return Collections.emptySet();

		File scripts = new File(data, "lua");
		if (!(scripts.exists() && scripts.isDirectory()))
			return Collections.emptySet();

		Collection<File> list = FileUtils.listFiles(scripts, new String[]{"lua"}, false);
		if (list == null)
			return Collections.emptySet();

		return list;
	}

	private final IGlobal global;
	private final IDebug debugger;
	private final IConsole console;
	private final InjectionPlugin plugin;
}
