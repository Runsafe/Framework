package no.runsafe.framework.internal.database;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;

import java.util.*;

public final class Set extends ArrayList<IRow> implements ISet
{
	public final static ISet Empty = new EmptySet();

	private static class EmptySet implements ISet
	{
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

		@Override
		public Iterator<IRow> iterator()
		{
			return new Iterator<IRow>()
			{
				@Override
				public boolean hasNext()
				{
					return false;
				}

				@Override
				public IRow next()
				{
					return null;
				}

				@Override
				public void remove()
				{
				}
			};
		}

		@Override
		public Object[] toArray()
		{
			return new Object[0];
		}

		@Override
		public <T> T[] toArray(T[] a)
		{
			return a;
		}

		@Override
		public boolean add(IRow iRow)
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
		public IRow get(int index)
		{
			return null;
		}

		@Override
		public IRow set(int index, IRow element)
		{
			return null;
		}

		@Override
		public void add(int index, IRow element)
		{
		}

		@Override
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

		@Override
		public ListIterator<IRow> listIterator()
		{
			return new ListIterator<IRow>()
			{
				@Override
				public boolean hasNext()
				{
					return false;
				}

				@Override
				public IRow next()
				{
					return null;
				}

				@Override
				public boolean hasPrevious()
				{
					return false;
				}

				@Override
				public IRow previous()
				{
					return null;
				}

				@Override
				public int nextIndex()
				{
					return 0;
				}

				@Override
				public int previousIndex()
				{
					return 0;
				}

				@Override
				public void remove()
				{
				}

				@Override
				public void set(IRow iRow)
				{
				}

				@Override
				public void add(IRow iRow)
				{
				}
			};
		}

		@Override
		public ListIterator<IRow> listIterator(int index)
		{
			return listIterator();
		}

		@Override
		public List<IRow> subList(int fromIndex, int toIndex)
		{
			return Lists.newArrayList();
		}
	}

	public Set(Collection<Row> dataSet)
	{
		this.addAll(dataSet);
	}
}
