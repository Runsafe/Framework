package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.database.IQueryExecutor;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.api.player.IPlayer;

import javax.activation.UnsupportedDataTypeException;
import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class QueryExecutorBase implements IQueryExecutor
{
	@Nonnull
	@Override
	public List<String> queryStrings(String query, Object... params)
	{
		List<String> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.String());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<Integer> queryIntegers(String query, Object... params) throws UnsupportedDataTypeException
	{
		List<Integer> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.Integer());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<Long> queryLongs(String query, Object... params) throws UnsupportedDataTypeException
	{
		List<Long> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.Long());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<Double> queryDoubles(String query, Object... params) throws UnsupportedDataTypeException
	{
		List<Double> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.Double());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<Float> queryFloats(String query, Object... params) throws UnsupportedDataTypeException
	{
		List<Float> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.Float());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<Instant> queryInstants(String query, Object... params)
	{
		List<Instant> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.Instant());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<IPlayer> queryPlayers(String query, Object... params)
	{
		List<IPlayer> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.Player());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<IWorld> queryWorlds(String query, Object... params)
	{
		List<IWorld> result = new ArrayList<>();
		for(IValue value : queryColumn(query, params))
		{
			result.add(value.World());
		}
		return result;
	}

	@Nonnull
	@Override
	public List<ILocation> queryLocations(String query, Object... params) throws UnsupportedDataTypeException
	{
		List<ILocation> result = new ArrayList<>();
		for(IRow row : query(query, params))
		{
			result.add(row.Location());
		}
		return result;
	}

	@Override
	public String queryString(String query, Object... params)
	{
		return queryValue(query, params).String();
	}

	@Override
	public Integer queryInteger(String query, Object... params) throws UnsupportedDataTypeException
	{
		return queryValue(query, params).Integer();
	}

	@Override
	public Long queryLong(String query, Object... params) throws UnsupportedDataTypeException
	{
		return queryValue(query, params).Long();
	}

	@Override
	public Double queryDouble(String query, Object... params) throws UnsupportedDataTypeException
	{
		return queryValue(query, params).Double();
	}

	@Override
	public Float queryFloat(String query, Object... params) throws UnsupportedDataTypeException
	{
		return queryValue(query, params).Float();
	}

	@Override
	public Instant queryInstant(String query, Object... params)
	{
		return queryValue(query, params).Instant();
	}

	@Override
	public IPlayer queryPlayer(String query, Object... params)
	{
		return queryValue(query, params).Player();
	}

	@Override
	public IWorld queryWorld(String query, Object... params)
	{
		return queryValue(query, params).World();
	}

	@Override
	public ILocation queryLocation(String query, Object... params) throws UnsupportedDataTypeException
	{
		return queryRow(query, params).Location();
	}
}
