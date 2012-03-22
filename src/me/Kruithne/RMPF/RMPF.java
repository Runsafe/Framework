package me.Kruithne.RMPF;

import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;

public abstract class RMPF extends JavaPlugin
{	
	public RMPF()
	{
		container = new DefaultPicoContainer();
		container.addComponent(this);
		container.addComponent(this.getServer());
		container.addComponent(this.getLogger());
		container.addComponent(RMPFOutput.class);
		container.addComponent(RMPFDatabase.class);
		container.addComponent(RMPFTimedEventHandler.class);
		container.addComponent(RMPFConfiguration.class);
		
		this.PluginSetup();
	}
	
	@Override
	public void onEnable()
	{
		RegisterEvents();
	}
	
	@Override
	public void onDisable()
	{
		UnregisterEvents();
	}
	
	protected List<Listener> GetEvents()
	{
		return container.getComponents(Listener.class);
	}		

	protected abstract void PluginSetup();
	
	private void RegisterEvents()
	{
		eventListeners = GetEvents();
		if(eventListeners != null && !eventListeners.isEmpty())
		{
			PluginManager pluginManager = this.getServer().getPluginManager();
			for (Listener listener : eventListeners) 
			{
				pluginManager.registerEvents(listener, this);
			}
		}		
	}
	
	private void UnregisterEvents() 
	{
		// Not supported by bukkit?!
	}
	
	protected DefaultPicoContainer container; 
	private List<Listener> eventListeners;
}
