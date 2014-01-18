package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.*;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

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
	public boolean isEmpty()
	{
		return parameterList.isEmpty();
	}

	@Override
	public boolean containsKey(Object key)
	{
		return parameterList.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value)
	{
		return parameterList.containsValue(value);
	}

	@Override
	public String get(Object key)
	{
		return parameterList.get(key);
	}

	@Nullable
	@Override
	public String put(String key, String value)
	{
		return null;
	}

	@Nullable
	@Override
	public String remove(Object key)
	{
		return null;
	}

	@Override
	public void putAll(@Nonnull Map<? extends String, ? extends String> m)
	{
	}

	@Override
	public void clear()
	{
	}

	@Nonnull
	@Override
	public Set<String> keySet()
	{
		return parameterList.keySet();
	}

	@Nonnull
	@Override
	public Collection<String> values()
	{
		return parameterList.values();
	}

	@Nonnull
	@Override
	public Set<Entry<String, String>> entrySet()
	{
		return parameterList.entrySet();
	}

	@Nullable
	@Override
	public IWorld getWorld(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<IWorld>) argument).getValue(context, parameterList);
		return null;
	}

	@Nullable
	@Override
	public IPlayer getPlayer(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<IPlayer>) argument).getValue(context, parameterList);
		return null;
	}

	@Nullable
	@Override
	public List<IPlayer> getPlayers(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<List<IPlayer>>) argument).getValue(context, parameterList);
		return null;
	}

	@Nullable
	@Override
	public Enum<?> getEnum(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<Enum<?>>) argument).getValue(context, parameterList);
		return null;
	}

	@Nullable
	public <T> T getMappedValue(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<T>) argument).getValue(context, parameterList);
		return null;
	}

	@Override
	public boolean isAborted()
	{
		if(containsValue(null))
			return true;

		for (IArgument argument : arguments.values())
			if (argument instanceof IValueExpander && parameterList.get(argument.toString()) == null)
				return true;

		return false;
	}

	@Nullable
	private final IPlayer context;
	private final Map<String, String> parameterList;
	private final Map<String, IArgument> arguments;
}
