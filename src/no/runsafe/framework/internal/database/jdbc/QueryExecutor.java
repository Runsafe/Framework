package no.runsafe.framework.internal.database.jdbc;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;
import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.database.QueryExecutorBase;
import no.runsafe.framework.internal.database.Row;
import no.runsafe.framework.internal.database.Set;
import no.runsafe.framework.internal.database.Value;
import org.joda.time.ReadableInstant;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

abstract class QueryExecutor extends QueryExecutorBase
{
	QueryExecutor(IConsole output, IDebug debugger)
	{
		this.output = output;
		this.debugger = debugger;
	}

	@Nonnull
	@Override
	public ISet query(String query, Object... params)
	{
		PreparedStatement statement = null;
		try
		{
			statement = prepare(query, params);
			if (statement == null)
				return Set.Empty;
			return getSet(statement);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Set.Empty;
		}
		finally
		{
			close(statement);
		}
	}

	@Override
	public boolean execute(String query, Object... params)
	{
		PreparedStatement statement = null;
		try
		{
			statement = prepare(query, params);
			if (statement == null)
				return false;
			debugger.debugFiner("Running SQL: %s", statement);
			statement.execute();
			return true;
		}
		catch (SQLException e)
		{
			output.logException(e);
			return false;
		}
		finally
		{
			close(statement);
		}
	}

	@Override
	public int update(String query, Object... params)
	{
		PreparedStatement statement = null;
		try
		{
			statement = prepare(query, params);
			if (statement == null)
				return -1;
			debugger.debugFiner("Running SQL: %s", statement);
			return statement.executeUpdate();
		}
		catch (SQLException e)
		{
			output.logException(e);
			return -1;
		}
		finally
		{
			close(statement);
		}
	}

	@Nonnull
	@Override
	public IRow queryRow(String query, Object... params)
	{
		PreparedStatement statement = null;
		try
		{
			statement = prepare(query, params);
			if (statement == null)
				return Row.Empty;
			ISet set = getSet(statement);
			return set.get(0);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Row.Empty;
		}
		finally
		{
			close(statement);
		}
	}

	@Override
	public List<IValue> queryColumn(String query, Object... params)
	{
		PreparedStatement statement = null;
		try
		{
			statement = prepare(query, params);
			if (statement == null)
				return Collections.emptyList();
			return getValues(statement);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Collections.emptyList();
		}
		finally
		{
			close(statement);
		}
	}

	@Override
	public IValue queryValue(String query, Object... params)
	{
		PreparedStatement statement = null;
		try
		{
			statement = prepare(query, params);
			if (statement == null)
				return Value.Empty;
			List<IValue> set = getValues(statement);
			if (set.isEmpty())
				return Value.Empty;
			return set.get(0);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Value.Empty;
		}
		finally
		{
			close(statement);
		}
	}

	@Nullable
	PreparedStatement prepare(String query, Object... params) throws SQLException
	{
		Connection conn = getConnection();
		if (conn == null)
			return null;

		PreparedStatement statement = conn.prepareStatement(query);
		setParams(statement, params);
		return statement;
	}

	ISet getSet(PreparedStatement statement) throws SQLException
	{
		debugger.debugFiner("Running SQL: %s", statement);
		ResultSet result = statement.executeQuery();
		if (!result.first())
			return Set.Empty;
		ResultSetMetaData meta = result.getMetaData();
		int cols = meta.getColumnCount();
		if (cols == 0)
			return Set.Empty;
		ArrayList<IRow> results = new ArrayList<IRow>(1);
		while (!result.isAfterLast())
		{
			results.add(readRow(meta, result));
			result.next();
		}
		return new Set(results);
	}

	List<IValue> getValues(PreparedStatement statement) throws SQLException
	{
		debugger.debugFiner("Running SQL: %s", statement);
		ResultSet result = statement.executeQuery();
		if (!result.first())
			return Lists.newArrayList();
		ResultSetMetaData meta = result.getMetaData();
		int cols = meta.getColumnCount();
		if (cols == 0)
			return Lists.newArrayList();
		List<IValue> results = new ArrayList<IValue>(1);
		while (!result.isAfterLast())
		{
			results.add(readValue(result));
			result.next();
		}
		return results;
	}

	abstract void close(PreparedStatement statement);

	static IRow readRow(ResultSetMetaData meta, ResultSet result) throws SQLException
	{
		int cols = meta.getColumnCount();
		HashMap<String, Object> row = new HashMap<String, Object>(cols);
		for (int i = 0; i < cols; ++i)
			row.put(meta.getColumnName(i + 1), result.getObject(i + 1));
		return new Row(row);
	}

	static IValue readValue(ResultSet result) throws SQLException
	{
		return new Value(result.getObject(1));
	}

	static void setParams(PreparedStatement statement, Object... params) throws SQLException
	{
		for (int i = 0; i < params.length; i++)
		{
			if (params[i] instanceof ReadableInstant)
				statement.setObject(i + 1, new Timestamp(((ReadableInstant) params[i]).getMillis()));
			else if (params[i] instanceof IPlayer)
				statement.setObject(i + 1, ((IPlayer) params[i]).getUniqueId().toString());
			else
				statement.setObject(i + 1, params[i]);
		}
	}

	protected abstract Connection getConnection();

	protected final IConsole output;
	protected final IDebug debugger;
}
