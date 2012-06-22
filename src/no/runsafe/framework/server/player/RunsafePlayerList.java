package no.runsafe.framework.server.player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class RunsafePlayerList implements Set<RunsafePlayer>
{
	public RunsafePlayerList(Set<Player> players)
	{
		playerSet = players;
	}

	@Override
	public int size()
	{
		return playerSet.size();
	}

	@Override
	public boolean isEmpty()
	{
		return playerSet.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		if(o instanceof RunsafePlayer)
			return playerSet.contains(((RunsafePlayer)o).getRaw());

		return playerSet.contains(o);
	}

	@Override
	public Iterator<RunsafePlayer> iterator()
	{
		ArrayList<RunsafePlayer> list = new ArrayList<RunsafePlayer>();
		for(Player player : playerSet)
			list.add(new RunsafePlayer(player));

		return list.iterator();
	}

	@Override
	public Object[] toArray()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(RunsafePlayer runsafePlayer)
	{
		return playerSet.add((Player)runsafePlayer.getRaw());
	}

	@Override
	public boolean remove(Object o)
	{
		if(o instanceof RunsafePlayer)
			return playerSet.remove(((RunsafePlayer)o).getRaw());

		return playerSet.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends RunsafePlayer> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear()
	{
		playerSet.clear();
	}

	private final Set<Player> playerSet;
}
