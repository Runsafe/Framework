package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public final class Set implements ISet
{
	public static final ISet Empty = new EmptySet();

	public Set(Collection<IRow> dataSet)
	{
		addAll(dataSet);
	}

	@Override
	public int size()
	{
		return list.size();
	}

	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return list.contains(o);
	}

	@Nonnull
	@Override
	public Iterator<IRow> iterator()
	{
		return list.iterator();
	}

	@Nonnull
	@Override
	public Object[] toArray()
	{
		return list.toArray();
	}

	@Nonnull
	@Override
	public <T> T[] toArray(@Nonnull T[] a)
	{
		return list.toArray(a);
	}

	@Override
	public boolean add(IRow iRow)
	{
		return list.add(iRow);
	}

	@Override
	public boolean remove(Object o)
	{
		return list.remove(o);
	}

	@Override
	public boolean containsAll(@Nonnull Collection<?> collection)
	{
		return list.containsAll(collection);
	}

	@Override
	public boolean addAll(@Nonnull Collection<? extends IRow> collection)
	{
		return list.addAll(collection);
	}

	@Override
	public boolean addAll(int index, @Nonnull Collection<? extends IRow> collection)
	{
		return list.addAll(index, collection);
	}

	@Override
	public boolean removeAll(@Nonnull Collection<?> collection)
	{
		return list.removeAll(collection);
	}

	@Override
	public boolean retainAll(@Nonnull Collection<?> collection)
	{
		return list.retainAll(collection);
	}

	@Override
	public void clear()
	{
		list.clear();
	}

	@Override
	public IRow get(int index)
	{
		return list.get(index);
	}

	@Override
	public IRow set(int index, IRow element)
	{
		return list.set(index, element);
	}

	@Override
	public void add(int index, IRow element)
	{
		list.add(index, element);
	}

	@Override
	public IRow remove(int index)
	{
		return list.remove(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return list.lastIndexOf(o);
	}

	@Nonnull
	@Override
	public ListIterator<IRow> listIterator()
	{
		return list.listIterator();
	}

	@Nonnull
	@Override
	public ListIterator<IRow> listIterator(int index)
	{
		return list.listIterator(index);
	}

	@Nonnull
	@Override
	public List<IRow> subList(int fromIndex, int toIndex)
	{
		return list.subList(fromIndex, toIndex);
	}

	@SuppressWarnings("MethodReturnAlwaysConstant")
	private static class EmptySet implements ISet
	{

		public static final Object[] OBJECTS = new Object[0];

		EmptySet()
		{
		}

		@Override
		public int size()
		{
			return 0;
		}

		@Override
		public boolean isEmpty()
		{
			return true;
		}

		@Override
		public boolean contains(Object o)
		{
			return false;
		}

		@Nonnull
		@Override
		public Iterator<IRow> iterator()
		{
			return Collections.emptyIterator();
		}

		@Nonnull
		@Override
		public Object[] toArray()
		{
			return OBJECTS;
		}

		@Nonnull
		@Override
		public <T> T[] toArray(@Nonnull T[] a)
		{
			return a;
		}

		@Override
		public boolean add(IRow e)
		{
			return false;
		}

		@Override
		public boolean remove(Object o)
		{
			return false;
		}

		@Override
		public boolean containsAll(@Nonnull Collection<?> collection)
		{
			return false;
		}

		@Override
		public boolean addAll(@Nonnull Collection<? extends IRow> collection)
		{
			return false;
		}

		@Override
		public boolean addAll(int index, @Nonnull Collection<? extends IRow> collection)
		{
			return false;
		}

		@Override
		public boolean removeAll(@Nonnull Collection<?> collection)
		{
			return false;
		}

		@Override
		public boolean retainAll(@Nonnull Collection<?> collection)
		{
			return false;
		}

		@Override
		public void clear()
		{
		}

		@Override
		@Nullable
		public IRow get(int index)
		{
			return Row.Empty;
		}

		@Override
		@Nullable
		public IRow set(int index, IRow element)
		{
			return null;
		}

		@Override
		public void add(int index, IRow element)
		{
		}

		@Override
		@Nullable
		public IRow remove(int index)
		{
			return null;
		}

		@Override
		public int indexOf(Object o)
		{
			return -1;
		}

		@Override
		public int lastIndexOf(Object o)
		{
			return -1;
		}

		@Nonnull
		@Override
		public ListIterator<IRow> listIterator()
		{
			return Collections.<IRow>emptyList().listIterator();
		}

		@Nonnull
		@Override
		public ListIterator<IRow> listIterator(int index)
		{
			return listIterator();
		}

		@Nonnull
		@Override
		public List<IRow> subList(int fromIndex, int toIndex)
		{
			return Collections.emptyList();
		}
	}

	private final ArrayList<IRow> list = new ArrayList<>(0);
}
