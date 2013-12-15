package no.runsafe.framework.internal.lua;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.InjectionPlugin;
import org.apache.commons.io.FileUtils;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collection;

@SuppressWarnings("InstanceMethodNamingConvention")
public class GlobalEnvironment implements Startable
{
	public static GlobalEnvironment get()
	{
		return InjectionPlugin.getGlobalComponent(GlobalEnvironment.class);
	}

	public static Globals global()
	{
		return InjectionPlugin.getGlobalComponent(GlobalEnvironment.class).globals;
	}

	public GlobalEnvironment(IConsole console)
	{
		this.console = console;
	}

	public LuaValue get(int value)
	{
		return globals.get(value);
	}

	public LuaValue get(LuaValue value)
	{
		return globals.get(value);
	}

	public LuaValue get(String value)
	{
		return globals.get(value);
	}

	public void loadFile(String file)
	{
		console.logInformation("Loading script %s", file);
		try
		{
			globals.get("dofile").call(LuaValue.valueOf(file));
		}
		catch (LuaError error)
		{
			console.logException(error);
		}
	}

	@Override
	public void start()
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

	@Override
	public void stop()
	{
	}

	private class Bootstrap extends OneArgFunction
	{
		Bootstrap()
		{
		}

		@Nullable
		@Override
		public LuaValue call(LuaValue env)
		{
			globals = env.checkglobals();
			return null;
		}
	}

	private Globals globals;
	private final IConsole console;
}
