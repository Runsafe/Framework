package me.Kruithne.RMPF;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;

public class RunsafePlugin extends JavaPlugin
{	
	@Override
	public void onEnable()
	{
		container = new DefaultPicoContainer();
		container.addComponent(this);
		container.addComponent(this.getServer());
		container.addComponent(this.getLogger());
		container.addComponent(RunsafeConfigurationHandler.class);
		container.addComponent(RunsafeOutputHandler.class);
		container.addComponent(RunsafeDatabaseHandler.class);
		container.addComponent(RunsafeTimerHandler.class);
		
		output = container.getComponent(IOutput.class);
		output.outputToConsole("Console message test");
		output.outputToServer("Server broadcast test");
		output.setDebugLevel(Level.FINE);
		output.outputDebugToConsole("Debug message test 1", Level.FINE);
		output.outputDebugToConsole("Debug message test 2", Level.FINER);
		output.outputDebugToConsole("Debug message test 3", Level.INFO);
		
		this.PluginSetup();
		
		output.outputDebugToConsole(String.format("Initiating plugin %s", this.getName()), Level.FINE);
		RegisterEvents();
		RegisterCommands();
		output.outputDebugToConsole(String.format("Registered %d event listeners", eventListeners.size()), Level.FINE);
		output.outputDebugToConsole(String.format("Initiation completed", this.getName()), Level.FINE);
	}
	
	@Override
	public void onDisable()
	{
		output.outputDebugToConsole(String.format("Deinitiating plugin %s", this.getName()), Level.FINE);
		UnregisterEvents();
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
//		CommandMap commandMap = GetCommandMap();
//		if(commandMap == null)
//		{
//			this.getLogger().info("Unable to get command map");
//			return;
//		}
//		this.getLogger().info("registering commands");
		commands = new HashMap<String, RunsafeCommandHandler>();
		List<RunsafeCommandHandler> commandList = this.GetCommands();
		for(RunsafeCommandHandler handler : commandList)
		{
			getCommand(handler.getName()).setExecutor(handler);
		}
//		if(commandList != null && !commandList.isEmpty())
//		{
//			for (RunsafeCommandHandler handler : commandList)
//			{
//				commandMap.register(handler.getName(), handler);
//				getCommand(handler.getName()).setExecutor(handler);
//				//for (String alias : handler.getCommandWithAliases())
//				//{
//				//	commands.put(alias.toLowerCase(), handler);
//				//}
//			}
//		}
	}
	
//	private CommandMap GetCommandMap()
//	{
//		try 
//		{
//			Field field = SimplePluginManager.class.getDeclaredField("commandMap");
//			field.setAccessible(true);
//			return (CommandMap)(field.get(getServer().getPluginManager()));
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	private void UnregisterEvents() 
	{
		// Not supported by bukkit?!
	}
	
	protected DefaultPicoContainer container; 
	private List<Listener> eventListeners;
	private IOutput output;
	private HashMap<String, RunsafeCommandHandler> commands;
}
