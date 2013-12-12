package no.runsafe.framework.internal;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.plugin.IPluginDisabled;
import no.runsafe.framework.api.event.plugin.IPluginEnabled;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.files.PluginFileManager;
import no.runsafe.framework.internal.command.CommandEngine;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import no.runsafe.framework.internal.database.SchemaUpdater;
import no.runsafe.framework.internal.database.jdbc.Database;
import no.runsafe.framework.internal.event.EventEngine;
import no.runsafe.framework.internal.log.*;
import no.runsafe.framework.internal.lua.Environment;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;
import org.picocontainer.Startable;
import org.picocontainer.lifecycle.LifecycleState;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base plugin class containing all the injection handling code
 */
@SuppressWarnings("OverlyCoupledClass")
public abstract class InjectionPlugin extends JavaPlugin implements IKernel, Startable, LifecycleState
{
	public static final Map<String, InjectionPlugin> Instances = new HashMap<String, InjectionPlugin>(1);

	public static <T> T getGlobalComponent(Class<T> type)
	{
		return globalContainer.getComponent(type);
	}

	protected InjectionPlugin()
	{
		container = new PicoBuilder(globalContainer).withCaching().build();
	}

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
			bootStrap();

		if (!Instances.containsKey(getName()))
			Instances.put(getName(), this);

		if (instanceIsNew)
			addStandardComponents();
	}

	private void bootStrap()
	{
		globalContainer.addComponent(getServer().getPluginManager());
		globalContainer.addComponent(new RunsafeServer(getServer()));
		globalContainer.addComponent(Multiverse.class);
		globalContainer.addComponent(Player.class);
		globalContainer.addComponent(LogFileHandler.class);
		uninitialized = false;
	}

	@SuppressWarnings("OverlyCoupledMethod")
	private void addStandardComponents()
	{
		container.setLifecycleState(this);
		container.addComponent(this);
		container.addComponent(ConfigurationEngine.class);
		container.addComponent(Console.class);
		container.addComponent(Broadcaster.class);
		container.addComponent(Debug.class);
		container.addComponent(Protocol.class);
		container.addComponent(Database.class);
		container.addComponent(new Scheduler(getServer().getScheduler(), this));
		container.addComponent(SchemaUpdater.class);
		container.addComponent(EventEngine.class);
		container.addComponent(CommandEngine.class);
		container.addComponent(HookEngine.class);
		container.addComponent(VersionEngine.class);
		container.addComponent(Environment.class);
		container.addComponent(PluginFileManager.class);
		container.addComponent(MultiverseLoader.class);
		instanceIsNew = false;
	}

	private final MutablePicoContainer container;
	private boolean instanceIsNew = true;
	private boolean engineStarted = false;
	protected IDebug output;

	private static final MutablePicoContainer globalContainer;
	private static boolean uninitialized = true;

	static
	{
		globalContainer = new PicoBuilder().withCaching().build();
	}

	@Override
	public void start()
	{
		engineStarted = true;
		output.debugFine("Plugin engine startup detected.");
	}

	@Override
	public void stop()
	{
		engineStarted = false;
		output.debugFiner("Plugin engine stop requested.");
	}

	@Override
	public void removingComponent()
	{
		output.debugFiner("Plugin engine component removal detected.");
	}

	@Override
	public void starting()
	{
		output.debugFiner("Plugin engine start detected.");
	}

	@Override
	public void stopping()
	{
		output.debugFiner("Plugin engine stop detected.");
	}

	@Override
	public void stopped()
	{
		output.debugFiner("Plugin engine stopped.");
	}

	@Override
	public boolean isStarted()
	{
		return engineStarted;
	}

	@Override
	public void disposing()
	{
		output.debugFiner("Plugin engine disposal detected.");
	}

	@Override
	public void disposed()
	{
		output.debugFiner("Plugin engine disposed.");
	}

	@Override
	public boolean isDisposed()
	{
		return false;
	}

	@Override
	public boolean isStopped()
	{
		return !engineStarted;
	}
}
