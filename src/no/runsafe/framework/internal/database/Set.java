package no.runsafe.framework.internal.database;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;

import javax.activity.InvalidActivityException;
import javax.annotation.Nullable;
import java.util.*;

@SuppressWarnings("NullableProblems")
public final class Set extends ArrayList<IRow> implements ISet
{
	public static final ISet Empty = new EmptySet();

	public Set(Collection<Row> dataSet)
	{
		addAll(dataSet);
	}

	@SuppressWarnings({"MethodReturnAlwaysConstant", "OverlyComplexAnonymousInnerClass"})
	private static class EmptySet implements ISet
	{
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
					throw new NoSuchElementException("There are no rows");
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
			return null;
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
					throw new NoSuchElementException("There are no rows");
				}

				@Override
				public boolean hasPrevious()
				{
					return false;
				}

				@Override
				@Nullable
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
				public void set(IRow e)
				{
				}

				@Override
				public void add(IRow e)
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
}
