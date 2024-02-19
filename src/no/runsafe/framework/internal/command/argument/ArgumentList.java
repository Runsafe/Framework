package no.runsafe.framework.internal.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.IValueExpander;
import no.runsafe.framework.api.command.argument.IValueProvider;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ArgumentList implements IArgumentList
{
	public ArgumentList(ICommandExecutor context, Map<String, IArgument> arguments, Map<String, String> parameterList)
	{
		this.context = context instanceof IPlayer ? (IPlayer) context : null;
		this.arguments = Collections.unmodifiableMap(arguments);
		this.parameterList = Collections.unmodifiableMap(parameterList);
	}

	@Override
	public int size()
	{
		return parameterList.size();
	}

	@Override
	@Deprecated
	public String get(Object key)
	{
		return parameterList.get(key);
	}

	@Override
	public boolean has(String param)
	{
		return parameterList.containsKey(param);
	}

	@Override
	@Nonnull
	public Set<Map.Entry<String, String>> entrySet()
	{
		return parameterList.entrySet();
	}

	@Override
	public boolean isAborted()
	{
		if (parameterList.containsValue(null))
			return true;

		for (IArgument argument : arguments.values())
			if (argument.isRequired() && argument instanceof IValueExpander && parameterList.get(argument.toString()) == null)
				return true;

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Nullable
	public <T> T getValue(String param)
	{
		IArgument argument = arguments.get(param);
		if (!(argument instanceof IValueProvider<?>))
			return null;
		return ((IValueProvider<T>) argument).getValue(context, parameterList);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Nonnull
	public <T> T getRequired(String param)
	{
		return ((IValueProvider<T>) arguments.get(param)).getValue(context, parameterList);
	}

	@Nullable
	private final IPlayer context;
	private final Map<String, String> parameterList;
	private final Map<String, IArgument> arguments;
	private static final Pattern argumentListSeparator = Pattern.compile("\\s+");
}
