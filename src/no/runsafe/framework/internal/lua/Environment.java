package no.runsafe.framework.internal.lua;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IServerReady;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.lua.Library;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.internal.log.Debug;
import org.apache.commons.io.FileUtils;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Environment implements Startable, IServerReady
{
	@SuppressWarnings("PublicField")
	public static Globals global;

	static
	{
		JsePlatform.standardGlobals().load(new Bootstrap());
		File source = new File(new File("plugins", "runsafe"), "lua");
		if (source.exists() && source.isDirectory())
		{
			Collection<File> scripts = FileUtils.listFiles(source, new String[]{"lua"}, false);
			for (File script : scripts)
				loadFile(script.getAbsolutePath());
		}
	}

	@SuppressWarnings("StaticVariableUsedBeforeInitialization")
	public static void loadFile(String file)
	{
		IConsole console = Console.Global();
		console.logInformation("Loading script %s", file);
		try
		{
			global.get("dofile").call(LuaValue.valueOf(file));
		}
		catch (LuaError error)
		{
			console.logException(error);
		}
	}

	public Environment(InjectionPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void start()
	{
		loadAPI();
	}

	@Override
	public void stop()
	{
	}

	@Override
	public void OnServerReady()
	{
		loadScripts();
	}

	private void loadAPI()
	{
		List<Library> libraries = plugin.getComponents(Library.class);
		if (!libraries.isEmpty())
		{
//			Debug.Global().debugFine("Adding plugin namespace %s to LUA environment", plugin.getName());
			global.set(plugin.getName(), new LuaTable());
			for (Library library : libraries)
				global.load(library);
		}
	}

	private void loadScripts()
	{
		for (File script : getScripts())
			if (script.isFile())
				loadFile(script.getAbsolutePath());
	}

	private Collection<File> getScripts()
	{
		File data = plugin.getDataFolder();
		if (!data.exists() || !data.isDirectory())
			return Collections.emptySet();

		File scripts = new File(data, "lua");
		if (!scripts.exists() || !scripts.isDirectory())
			return Collections.emptySet();

		Collection<File> list = FileUtils.listFiles(scripts, new String[]{"lua"}, false);
		if (list == null)
			return Collections.emptySet();

		return list;
	}

	private static class Bootstrap extends OneArgFunction
	{
		Bootstrap()
		{
		}

		@Nullable
		@Override
		public LuaValue call(LuaValue env)
		{
			global = env.checkglobals();
			return null;
		}
	}

	private final InjectionPlugin plugin;
}
