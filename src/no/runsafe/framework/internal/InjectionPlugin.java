package no.runsafe.framework.internal;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.plugin.IPluginDisabled;
import no.runsafe.framework.api.event.plugin.IPluginEnabled;
import no.runsafe.framework.internal.command.CommandEngine;
import no.runsafe.framework.internal.configuration.Configuration;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import no.runsafe.framework.internal.database.SchemaUpdater;
import no.runsafe.framework.internal.database.jdbc.Database;
import no.runsafe.framework.internal.event.EventEngine;
import no.runsafe.framework.internal.lua.Environment;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base plugin class containing all the injection handling code
 */
@SuppressWarnings("OverlyCoupledClass")
public abstract class InjectionPlugin extends JavaPlugin implements IKernel
{
	public static final Map<String, InjectionPlugin> Instances = new HashMap<String, InjectionPlugin>(1);

	/**
	 * get the first implementation of a given API from any plugin
	 *
	 * @param apiType The interface specification needed
	 * @return The first available implementation of the interface
	 */
	@Nullable
	public static <T> T getFirstPluginAPI(Class<T> apiType)
	{
		for (InjectionPlugin plugin : Instances.values())
		{
			T instance = plugin.getComponent(apiType);
			if (instance != null)
				return instance;
		}
		return null;
	}

	/**
	 * get all implementations of a given API from all plugins
	 *
	 * @param apiType The interface specification needed
	 * @return The first available implementation of the interface
	 */
	public static <T> List<T> getPluginAPI(Class<T> apiType)
	{
		List<T> results = new ArrayList<T>(1);
		for (InjectionPlugin plugin : Instances.values())
		{
			List<T> instance = plugin.getComponents(apiType);
			if (instance != null)
				results.addAll(instance);
		}
		return results;
	}

	@Override
	public final void addComponent(Object implOrInstance)
	{
		output.finer(
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
		output.finer("Got request for all instances of %s", type.getCanonicalName());
		return container.getComponents(type);
	}

	@Override
	public final void onEnable()
	{
		initializePlugin();
		container.start();
		output.fine("Plugin initialized.");

		for (IPluginEnabled impl : getComponents(IPluginEnabled.class))
			impl.OnPluginEnabled();
		output.fine("Plugin enabled event executed.");
	}

	@Override
	public final void onDisable()
	{
		output.fine("Disabling plugin %s", getName());
		for (IPluginDisabled impl : getComponents(IPluginDisabled.class))
			impl.OnPluginDisabled();
	}

	@SuppressWarnings("NonThreadSafeLazyInitialization")
	protected void initializePlugin()
	{
		if (container != null)
			return;

		Instances.put(getName(), this);
		if (RunsafeServer.Instance == null)
			RunsafeServer.Instance = new RunsafeServer(getServer());

		container = new DefaultPicoContainer(new Caching());
		addStandardComponents();
	}

	@SuppressWarnings("OverlyCoupledMethod")
	private void addStandardComponents()
	{
		container.addComponent(this);
		container.addComponent(ConfigurationEngine.class);
		container.addComponent(getServer().getPluginManager());
		container.addComponent(new RunsafeServer(getServer()));
		container.addComponent(getLogger());
		container.addComponent(Configuration.class);
		container.addComponent(Broadcaster.class);
		container.addComponent(Database.class);
		container.addComponent(new Scheduler(getServer().getScheduler(), this));
		container.addComponent(SchemaUpdater.class);
		container.addComponent(EventEngine.class);
		container.addComponent(CommandEngine.class);
		container.addComponent(HookEngine.class);
		container.addComponent(VersionEngine.class);
		container.addComponent(Environment.class);
	}

	private DefaultPicoContainer container;
	protected IOutput output;
}
