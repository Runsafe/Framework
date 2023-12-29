package no.runsafe.framework.minecraft;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.configuration.FrameworkConfiguration;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.NotImplementedException;

import java.util.UUID;
import java.util.logging.Level;

public class RunsafeConsole implements ICommandExecutor
{
	public RunsafeConsole(IConsole output)
	{
		this.output = output;
		this.name = InjectionPlugin.getGlobalComponent(FrameworkConfiguration.class).getConfigValueAsString("console.name");
	}

	@Override
	public String getName()
	{
		return name;
	}

	/**
	* Gets the unique ID.
	* @return Zeroed out UUID.
	*/
	@Override
	public UUID getUniqueId()
	{
		return consoleUUID;
	}

	@Override
	public void sendMessage(String message)
	{
		output.logInformation(message);
	}

	@Override
	public void sendColouredMessage(String format, Object... params)
	{
		output.writeColoured(format, Level.INFO, params);
	}

	@Override
	public void sendComplexMessage(String message, String hoverText, String clickCommand)
	{
		if (message == null)
			return;

		if (hoverText != null)
			message += (" Hover Text: " + hoverText);

		if (clickCommand != null)
			message += (" Click Command: " + clickCommand);

		output.writeColoured(message, Level.INFO);
	}

	@Override
	public boolean hasPermission(String permission)
	{
		return true;
	}

	@Override
	public boolean performCommand(String command)
	{
		throw new NotImplementedException("It is not yet supported running commands as the console from code.");
	}

	/**
	 * Determines if two objects are the same console.
	 * Compares using their names.
	 * @param o Object to compare.
	 * @return True if and only if both objects have the same name.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;

		if(o == null)
			return false;

		if(o instanceof RunsafeConsole)
			return this.getName().equals(((RunsafeConsole) o).getName());

		return false;
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	private final UUID consoleUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
	private final IConsole output;
	private final String name;
}
