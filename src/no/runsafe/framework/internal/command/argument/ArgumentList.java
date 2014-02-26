package no.runsafe.framework.internal.command.argument;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.*;
import no.runsafe.framework.api.command.argument.Enum;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
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
		return getList(param);
	}

	@Nullable
	@Override
	public java.lang.Enum getEnum(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof Enum)
			return ((Enum) argument).getValue(parameterList);
		return null;
	}

	@Override
	@Nullable
	public <T> T getMappedValue(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<T>) argument).getValue(context, parameterList);
		return null;
	}

	@Nullable
	public Integer getInt(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<Integer>) argument).getValue(context, parameterList);
		return null;
	}

	@Nullable
	public Float getFloat(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument instanceof IValueProvider<?>)
			return ((IValueProvider<Float>) argument).getValue(context, parameterList);
		return null;
	}

	@Override
	public boolean isAborted()
	{
		if (containsValue(null))
			return true;

		for (IArgument argument : arguments.values())
			if (argument.isRequired() && argument instanceof IValueExpander && parameterList.get(argument.toString()) == null)
				return true;

		return false;
	}

	@Override
	@Nullable
	public <T> T getValue(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument == null || !(argument instanceof IValueProvider<?>))
			return null;
		return ((IValueProvider<T>) argument).getValue(context, parameterList);
	}

	@Override
	@Nonnull
	public <T> List<T> getList(String param)
	{
		IArgument argument = arguments.get(param);
		if (argument == null || !(argument instanceof IValueProvider<?>))
			return Collections.emptyList();

		String value = parameterList.get(param);
		if (value == null || value.isEmpty())
			return Collections.emptyList();

		String[] listEntries = argumentListSeparator.split(value);
		List<T> result = Lists.newArrayList();
		IValueProvider<T> provider = (IValueProvider<T>) argument;
		Map<String, String> holder = new HashMap<String, String>(1);
		for (String entry : listEntries)
		{
			holder.put(param, entry);
			T item = provider.getValue(context, holder);
			if (item != null)
				result.add(item);
		}
		return result;
	}

	@Nullable
	private final IPlayer context;
	private final Map<String, String> parameterList;
	private final Map<String, IArgument> arguments;
	private static Pattern argumentListSeparator = Pattern.compile("\\s+");
}
