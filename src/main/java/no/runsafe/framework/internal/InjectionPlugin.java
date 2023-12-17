package no.runsafe.framework.internal;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.plugin.IPluginDisabled;
import no.runsafe.framework.api.event.plugin.IPluginEnabled;
import no.runsafe.framework.api.hook.IGlobalPluginAPI;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.brane.Multiverse;
import no.runsafe.framework.internal.command.Engine;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import no.runsafe.framework.internal.configuration.FrameworkConfiguration;
import no.runsafe.framework.internal.database.SchemaUpdater;
import no.runsafe.framework.internal.database.jdbc.Database;
import no.runsafe.framework.internal.event.BukkitEventMapper;
import no.runsafe.framework.internal.hooks.HookEngine;
import no.runsafe.framework.internal.hooks.PlayerExtensions;
import no.runsafe.framework.internal.log.*;
import no.runsafe.framework.internal.lua.GlobalEnvironment;
import no.runsafe.framework.internal.lua.PluginRunner;
import no.runsafe.framework.internal.reporting.ErrorReportingQueue;
import no.runsafe.framework.internal.text.GlobalLocale;
import no.runsafe.framework.internal.text.Localization;
import no.runsafe.framework.internal.extension.RunsafeServer;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Base plugin class containing all the injection handling code
 */
@SuppressWarnings("OverlyCoupledClass")
public abstract class InjectionPlugin extends JavaPlugin implements IKernel
{
	public static <T> T getGlobalComponent(Class<T> type)
	{
		return globalContainer.getComponent(type);
	}

	protected static void exportAPI(Object implOrInstance)
	{
		globalContainer.addComponent(implOrInstance);
	}

	protected InjectionPlugin()
	{
		container = new PicoBuilder(globalContainer).withCaching().withLifecycle().build();
	}

	/**
	 * get the first implementation of a given API from any plugin
	 *
	 * @param apiType The interface specification needed
	 * @return The first available implementation of the interface
	 */
	@Nullable
	@Deprecated
	public static <T> T getFirstPluginAPI(Class<T> apiType)
	{
		for (IKernel kernel : pluginContainer.getComponents(IKernel.class))
		{
			T instance = kernel.getComponent(apiType);
			if (instance != null)
				return instance;
		}
		return null;
	}

	/**
	 * get all implementations of a given API from all plugins
	 *
	 * @param apiType The interface specification needed
	 */
	public static <T> List<T> getPluginAPI(Class<T> apiType)
	{
		List<T> results = new ArrayList<T>(1);
		for (IKernel kernel : pluginContainer.getComponents(IKernel.class))
		{
			List<T> instance = kernel.getComponents(apiType);
			if (instance != null)
				results.addAll(instance);
		}
		return results;
	}

	@Override
	public final void addComponent(Object implOrInstance)
	{
		if (output != null)
			output.debugFiner(
				"Plugin %s added component %s",
				getName(),
				implOrInstance instanceof Class<?>
					? ((Class<?>) implOrInstance).getCanonicalName()
					: implOrInstance.getClass().getCanonicalName()
			);
		container.addComponent(implOrInstance);
	}

	@Override
	public final <T> T getComponent(Class<T> type)
	{
		return container.getComponent(type);
	}

	@Override
	public final <T> T getInstance(Class<T> type)
	{
		container.addComponent(type);
		T instance = container.getComponent(type);
		container.removeComponent(type);
		return instance;
	}

	@Override
	public final <T> List<T> getComponents(Class<T> type)
	{
		output.debugFiner("Got request for all instances of %s", type.getCanonicalName());
		return container.getComponents(type);
	}

	@Override
	public final void onEnable()
	{
		initializePlugin();
		output.debugFine("Starting container");
		container.start();
		output.debugFine("Plugin initialized.");

		for (IPluginEnabled impl : getComponents(IPluginEnabled.class))
			impl.OnPluginEnabled();
		output.debugFine("Plugin enabled event executed.");

		for(IGlobalPluginAPI api : getComponents(IGlobalPluginAPI.class))
		{
			output.debugFine("Exporting API " + api.getClass().getSimpleName());
			exportAPI(api);
		}
	}

	@Override
	public final void onDisable()
	{
		output.debugFine("Disabling plugin %s", getName());
		for (IPluginDisabled impl : getComponents(IPluginDisabled.class))
			impl.OnPluginDisabled();
	}

	protected void initializePlugin()
	{
		if (uninitialized)
			addGlobalDefaultComponents(getServer());

		if (instanceIsNew)
		{
			pluginContainer.addComponent(this);
			addPluginStandardComponents();
		}
	}

	@SuppressWarnings("CallToPrintStackTrace")
	private static void addGlobalDefaultComponents(Server bukkit)
	{
		globalContainer.addComponent(FrameworkConfiguration.class);
		globalContainer.addComponent(bukkit.getPluginManager());
		globalContainer.addComponent(new RunsafeServer(bukkit));
		globalContainer.addComponent(Multiverse.class);
		globalContainer.addComponent(Player.class);
		globalContainer.addComponent(FileManager.class);
		globalContainer.addComponent(HookEngine.class);
		globalContainer.addComponent(GlobalEnvironment.class);
		globalContainer.addComponent(GlobalLocale.class);
		globalContainer.addComponent(Root.class);
		globalContainer.addComponent(PlayerExtensions.class);
		try
		{
			globalContainer.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		uninitialized = false;
	}

	@SuppressWarnings("OverlyCoupledMethod")
	private void addPluginStandardComponents()
	{
		instanceIsNew = false;

		// Upstream objects
		container.addComponent(this);
		container.addComponent(getServer().getScheduler());

		// Core engines
		container.addComponent(ConfigurationEngine.class);
		container.addComponent(Database.class);
		container.addComponent(SchemaUpdater.class);
		container.addComponent(BukkitEventMapper.class);
		container.addComponent(Engine.class);
		container.addComponent(Scheduler.class);
		container.addComponent(Localization.class);

		// Logging/output facilities
		container.addComponent(ErrorReportingQueue.class);
		container.addComponent(Console.class);
		container.addComponent(Broadcaster.class);
		container.addComponent(Debug.class);
		container.addComponent(Protocol.class);

		// Lua script extension
		container.addComponent(PluginRunner.class);
	}

	private final MutablePicoContainer container;
	private boolean instanceIsNew = true;
	protected IDebug output;

	protected static final MutablePicoContainer globalContainer;
	protected static final MutablePicoContainer pluginContainer;
	private static boolean uninitialized = true;

	static
	{
		globalContainer = new PicoBuilder().withCaching().withLifecycle().build();
		pluginContainer = new PicoBuilder(globalContainer).withCaching().withLifecycle().addChildToParent().build();
	}
}
