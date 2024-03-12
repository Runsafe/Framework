package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;

import java.util.*;

public class PlayerData
{
	private final Map<String, String> data = new HashMap<>();
	private final Set<String> filter;
	private final IPlayer player;
	private final ICommandExecutor context;

	public PlayerData(IPlayer player, ICommandExecutor context, String[] filter)
	{
		this.filter = new HashSet<>(Arrays.asList(filter));
		this.player = player;
		this.context = context;
	}

	public Map<String, String> getData()
	{
		return data;
	}

	public IPlayer getPlayer()
	{
		return player;
	}

	public ICommandExecutor getContext()
	{
		return context;
	}

	public interface PlayerDataSource
	{
		String run();
	}

	public void addData(String key, String value)
	{
		addData(key, () -> value);
	}

	public void addData(String key, PlayerDataSource source)
	{
		if (filter.isEmpty() || filter.contains(key) || filter.stream().anyMatch(key::startsWith))
		{
			String value = source.run();
			if (value != null)
			{
				data.put(key, value);
			}
		}
	}
}
