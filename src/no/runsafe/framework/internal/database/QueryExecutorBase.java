package no.runsafe.framework.internal.database;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.database.IQueryExecutor;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.api.player.IPlayer;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("AnonymousInnerClass")
public abstract class QueryExecutorBase implements IQueryExecutor
{
	@Override
	public List<String> QueryStrings(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, String>()
			{
				@Override
				public String apply(@Nullable IValue value)
				{
					assert value != null;
					return value.String();
				}
			}
		);
	}

	@Override
	public List<Integer> QueryIntegers(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, Integer>()
			{
				@Override
				public Integer apply(@Nullable IValue value)
				{
					assert value != null;
					return value.Integer();
				}
			}
		);
	}

	@Override
	public List<Long> QueryLongs(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, Long>()
			{
				@Override
				public Long apply(@Nullable IValue value)
				{
					assert value != null;
					return value.Long();
				}
			}
		);
	}

	@Override
	public List<Double> QueryDoubles(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, Double>()
			{
				@Override
				public Double apply(@Nullable IValue value)
				{
					assert value != null;
					return value.Double();
				}
			}
		);
	}

	@Override
	public List<Float> QueryFloats(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, Float>()
			{
				@Override
				public Float apply(@Nullable IValue value)
				{
					assert value != null;
					return value.Float();
				}
			}
		);
	}

	@Override
	public List<DateTime> QueryDateTimes(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, DateTime>()
			{
				@Override
				public DateTime apply(@Nullable IValue value)
				{
					assert value != null;
					return value.DateTime();
				}
			}
		);
	}

	@Override
	public List<IPlayer> QueryPlayers(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, IPlayer>()
			{
				@Override
				public IPlayer apply(@Nullable IValue value)
				{
					assert value != null;
					return value.Player();
				}
			}
		);
	}

	@Override
	public List<IWorld> QueryWorlds(String query, Object... params)
	{
		return Lists.transform(
			QueryColumn(query, params),
			new Function<IValue, IWorld>()
			{
				@Override
				public IWorld apply(@Nullable IValue value)
				{
					assert value != null;
					return value.World();
				}
			}
		);
	}

	@Override
	public List<ILocation> QueryLocations(String query, Object... params)
	{
		return Lists.transform(
			Query(query, params),
			new Function<IRow, ILocation>()
			{
				@Override
				public ILocation apply(@Nullable IRow row)
				{
					assert row != null;
					return row.Location();
				}
			}
		);
	}

	@Override
	public String QueryString(String query, Object... params)
	{
		return QueryValue(query, params).String();
	}

	@Override
	public Integer QueryInteger(String query, Object... params)
	{
		return QueryValue(query, params).Integer();
	}

	@Override
	public Long QueryLong(String query, Object... params)
	{
		return QueryValue(query, params).Long();
	}

	@Override
	public Double QueryDouble(String query, Object... params)
	{
		return QueryValue(query, params).Double();
	}

	@Override
	public Float QueryFloat(String query, Object... params)
	{
		return QueryValue(query, params).Float();
	}

	@Override
	public DateTime QueryDateTime(String query, Object... params)
	{
		return QueryValue(query, params).DateTime();
	}

	@Override
	public IPlayer QueryPlayer(String query, Object... params)
	{
		return QueryValue(query, params).Player();
	}

	@Override
	public IWorld QueryWorld(String query, Object... params)
	{
		return QueryValue(query, params).World();
	}

	@Override
	public ILocation QueryLocation(String query, Object... params)
	{
		return QueryRow(query, params).Location();
	}
}
