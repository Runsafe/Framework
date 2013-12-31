package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public final class Set extends ArrayList<IRow> implements ISet
{
	public static final ISet Empty = new EmptySet();

	public Set(Collection<IRow> dataSet)
	{
		addAll(dataSet);
	}

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
			return Collections.<IRow>emptyList().iterator();
		}

		@Nonnull
		@Override
		public Object[] toArray()
		{
			return OBJECTS;
		}

		@Nonnull
		@Override
		public <T> T[] toArray(T[] a)
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
		public boolean containsAll(Collection<?> c)
		{
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends IRow> c)
		{
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends IRow> c)
		{
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c)
		{
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c)
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
}
