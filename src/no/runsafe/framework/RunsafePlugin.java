package no.runsafe.framework;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;

public class RunsafePlugin extends JavaPlugin
{	
	@Override
	public void onEnable()
	{	
		container = new DefaultPicoContainer(new Caching());
		container.addComponent(this);
		container.addComponent(this.getServer());
		container.addComponent(this.getLogger());
		container.addComponent(RunsafeConfigurationHandler.class);
		container.addComponent(RunsafeOutputHandler.class);
		container.addComponent(RunsafeDatabaseHandler.class);
		container.addComponent(RunsafeTimerHandler.class);
		container.addComponent(DatabaseHelper.class);
		
		output = container.getComponent(IOutput.class);

		this.PluginSetup();
		
		output.outputDebugToConsole(String.format("Initiating plugin %s", this.getName()), Level.FINE);
		RegisterEvents();
		RegisterCommands();
		output.outputDebugToConsole(String.format("Registered %d event listeners", eventListeners.size()), Level.FINE);
		output.outputDebugToConsole(String.format("Initiation completed", this.getName()), Level.FINE);
		
		for(IPluginEnabled impl : container.getComponents(IPluginEnabled.class))
		{
			impl.OnPluginEnabled();
		}
	}
	
	@Override
	public void onDisable()
	{
		output.outputDebugToConsole(String.format("Deinitiating plugin %s", this.getName()), Level.FINE);
		UnregisterEvents();
		
		for(IPluginDisabled impl : container.getComponents(IPluginDisabled.class))
		{
			impl.OnPluginDisabled();
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		String command = cmd.getName().toLowerCase();
		if(commands.containsKey(command))
			return commands.get(command).onCommand(sender, cmd, label, args);
		
		return false;
	}
	
	protected void addComponent(Object implOrInstance)
	{
		output.outputDebugToConsole(String.format("Plugin %s added component %s", this.getName(), implOrInstance.getClass().getCanonicalName()), Level.FINE);
		container.addComponent(implOrInstance);
	}
	
	protected List<Listener> GetEvents()
	{
		return container.getComponents(Listener.class);
	}		

	protected List<RunsafeCommandHandler> GetCommands()
	{
		return container.getComponents(RunsafeCommandHandler.class);
	}
	
	protected void PluginSetup()
	{
	}
	
	private void RegisterEvents()
	{
		eventListeners = GetEvents();
		if(eventListeners != null && !eventListeners.isEmpty())
		{
			PluginManager pluginManager = this.getServer().getPluginManager();
			for (Listener listener : eventListeners) 
			{
				pluginManager.registerEvents(listener, this);
				output.outputDebugToConsole(String.format("Registered event listener %s", listener.getClass().getCanonicalName()), Level.FINER);
			}
		}		
	}
	
	private void RegisterCommands()
	{
		commands = new HashMap<String, RunsafeCommandHandler>();
		List<RunsafeCommandHandler> commandList = this.GetCommands();
		for(RunsafeCommandHandler handler : commandList)
		{
			PluginCommand command = getCommand(handler.getName());
			
			if(command == null)
				output.outputToConsole(String.format("Command not found: %s - does it exist in plugin.yml?", handler.getName()));
			else
				command.setExecutor(handler);
		}
	}
	
	private void UnregisterEvents() 
	{
		// Not supported by bukkit?!
	}
	
	protected DefaultPicoContainer container; 
	private List<Listener> eventListeners;
	private IOutput output;
	private HashMap<String, RunsafeCommandHandler> commands;
}
