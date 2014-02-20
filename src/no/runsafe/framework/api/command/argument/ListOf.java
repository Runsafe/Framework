package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import org.bukkit.craftbukkit.libs.joptsimple.internal.Strings;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ListOf<T extends ListOf.Compatible> extends TrailingArgument implements IValueExpander, ITabComplete
{
	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		return argument.getAlternatives(executor, partial);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		String[] values = LISTSEPARATOR.split(value);
		List<String> result = new ArrayList<String>(values.length);
		IServer server = InjectionPlugin.getGlobalComponent(IServer.class);
		for (String val : values)
		{
			String expanded = argument.expand(context, value);
			if (expanded != null)
				result.add(expanded);
		}
		return Strings.join(result, " ");
	}

	public interface Compatible extends IArgument, IValueExpander, ITabComplete
	{
	}

	public ListOf(T argument)
	{
		super(argument.toString());
		this.argument = argument;
	}

	private final T argument;
	static final Pattern LISTSEPARATOR = Pattern.compile("\\s+");
}
