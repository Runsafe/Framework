package me.Kruithne.RMPF;

import org.bukkit.plugin.java.JavaPlugin;

public class RMPF extends JavaPlugin {
	
	private RMPFOutput output;

	public void onEnable()
	{
		this.output = new RMPFOutput(this.getServer(), this.getLogger());
		
		this.output.outputToConsole(RMPFConstants.frameworkLoaded);
	}
	
}
