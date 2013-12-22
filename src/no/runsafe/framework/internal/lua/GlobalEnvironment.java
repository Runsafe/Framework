package no.runsafe.framework.internal.lua;

import net.minecraft.util.org.apache.commons.io.FileUtils;
import no.runsafe.framework.api.lua.IGlobal;
import no.runsafe.framework.internal.InjectionPlugin;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collection;

public class GlobalEnvironment implements Startable, IGlobal
{
	public static IGlobal get()
	{
		return InjectionPlugin.getGlobalComponent(GlobalEnvironment.class);
	}

	public static Globals global()
	{
		return InjectionPlugin.getGlobalComponent(GlobalEnvironment.class).globals;
	}

	@Override
	public LuaValue get(int key)
	{
		return globals.get(key);
	}

	@Override
	public LuaValue get(LuaValue key)
	{
		return globals.get(key);
	}

	@Override
	public LuaValue get(String key)
	{
		return globals.get(key);
	}

	@Override
	public void set(int key, LuaValue value)
	{
		globals.set(key, value);
	}

	@Override
	public void set(String key, LuaValue value)
	{
		globals.set(key, value);
	}

	@Override
	public void set(LuaValue key, LuaValue value)
	{
		globals.set(key, value);
	}

	@Override
	public void loadFile(String file)
	{
		globals.get("dofile").call(LuaValue.valueOf(file));
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
}
