package no.runsafe.framework.command;

import java.util.Collection;

public class RunsafePlayerCommand extends RunsafeCommand
{
	public RunsafePlayerCommand(String name, Collection<ICommand> subs, String... params)
	{
		super(name, subs, params);
	}

	@Override
	public boolean Execute(String[] args)
	{
		Console.write("This command cannot be used from the console.");
		return true;
	}
}
