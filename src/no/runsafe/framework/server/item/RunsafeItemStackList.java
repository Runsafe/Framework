package no.runsafe.framework.server.item;

import com.mysql.jdbc.NotImplemented;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Deprecated
public class RunsafeItemStackList implements List<RunsafeItemStack>
{
	public RunsafeItemStackList(List<ItemStack> stacks)
	{
		itemStacks = stacks;
	}

	@Override
	public int size()
	{
		return itemStacks.size();
	}

	@Override
	public boolean isEmpty()
	{
		return itemStacks.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		if (o instanceof RunsafeItemStack)
			return itemStacks.contains(((RunsafeItemStack) o).getRaw());
		return itemStacks.contains(o);
	}

	@Override
	public Iterator<RunsafeItemStack> iterator()
	{
		throw new NoSuchMethodError();
	}

	@Override
	public Object[] toArray()
	{
		throw new NoSuchMethodError();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public boolean add(RunsafeItemStack runsafeItemStack)
	{
		return itemStacks.add(runsafeItemStack.getRaw());
	}

	@Override
	public boolean remove(Object o)
	{
		if (o instanceof RunsafeItemStack)
			return itemStacks.remove(((RunsafeItemStack) o).getRaw());
		else
			return itemStacks.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public boolean addAll(Collection<? extends RunsafeItemStack> c)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public boolean addAll(int index, Collection<? extends RunsafeItemStack> c)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public void clear()
	{
		itemStacks.clear();
	}

	@Override
	public RunsafeItemStack get(int index)
	{
		return new RunsafeItemStack(itemStacks.get(index));
	}

	@Override
	public RunsafeItemStack set(int index, RunsafeItemStack element)
	{
		ItemStack stack = itemStacks.set(index, element.getRaw());
		if (stack == null)
			return null;
		return new RunsafeItemStack(stack);
	}

	@Override
	public void add(int index, RunsafeItemStack element)
	{
		itemStacks.add(index, element.getRaw());
	}

	@Override
	public RunsafeItemStack remove(int index)
	{
		ItemStack stack = itemStacks.remove(index);
		if (stack == null)
			return null;
		return new RunsafeItemStack(stack);
	}

	@Override
	public int indexOf(Object o)
	{
		if (o instanceof RunsafeItemStack)
			return itemStacks.indexOf(((RunsafeItemStack) o).getRaw());
		return itemStacks.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o)
	{
		if (o instanceof RunsafeItemStack)
			return itemStacks.lastIndexOf(((RunsafeItemStack) o).getRaw());
		return itemStacks.lastIndexOf(o);
	}

	@Override
	public ListIterator<RunsafeItemStack> listIterator()
	{
		throw new NoSuchMethodError();
	}

	@Override
	public ListIterator<RunsafeItemStack> listIterator(int index)
	{
		throw new NoSuchMethodError();
	}

	@Override
	public List<RunsafeItemStack> subList(int fromIndex, int toIndex)
	{
		throw new NoSuchMethodError();
	}

	private final List<ItemStack> itemStacks;
}
