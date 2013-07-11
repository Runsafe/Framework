package no.runsafe.framework.internal.database.jdbc;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.database.IQueryExecutor;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;
import no.runsafe.framework.api.database.IValue;
import no.runsafe.framework.internal.database.Row;
import no.runsafe.framework.internal.database.Set;
import no.runsafe.framework.internal.database.Value;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class QueryExecutor implements IQueryExecutor
{
	QueryExecutor(IOutput output)
	{
		this.output = output;
	}

	@Override
	public ISet Query(String query, Object... params)
	{
		try
		{
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++)
				statement.setObject(i + 1, params[i]);
			return getSet(statement);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Set.Empty;
		}
	}

	@Override
	public IRow QueryRow(String query, Object... params)
	{
		try
		{
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++)
				statement.setObject(i + 1, params[i]);
			ISet set = getSet(statement);
			if (set.isEmpty())
				return Row.Empty;
			return set.get(0);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Row.Empty;
		}
	}

	@Override
	public List<IValue> QueryColumn(String query, Object... params)
	{
		try
		{
			PreparedStatement statement = prepare(query);
			setParams(statement, params);
			return getValues(statement);
		}
		catch (SQLException e)
		{
			output.logException(e);
			return Lists.newArrayList();
		}
	}

	@Override
	public IValue QueryValue(String query, Object... params)
	{
		try
		{
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++)
				statement.setObject(i + 1, params[i]);
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
	}

	@Override
	public boolean Execute(String query, Object... params)
	{
		try
		{
			PreparedStatement statement = prepare(query);
			setParams(statement, params);
			output.finer("Running SQL: %s", statement);
			statement.execute();
			return true;
		}
		catch (SQLException e)
		{
			output.logException(e);
			return false;
		}
	}

	@Override
	public int Update(String query, Object... params)
	{
		try
		{
			PreparedStatement statement = prepare(query);
			setParams(statement, params);
			output.finer("Running SQL: %s", statement);
			return statement.executeUpdate();
		}
		catch (SQLException e)
		{
			output.logException(e);
			return -1;
		}
	}

	ISet getSet(PreparedStatement statement) throws SQLException
	{
		output.finer("Running SQL: %s", statement);
		ResultSet result = statement.executeQuery();
		if (!result.first())
			return Set.Empty;
		ResultSetMetaData meta = result.getMetaData();
		int cols = meta.getColumnCount();
		if (cols == 0)
			return Set.Empty;
		ArrayList<Row> results = new ArrayList<Row>();
		while (!result.isAfterLast())
		{
			HashMap<String, Object> row = new HashMap<String, Object>();
			for (int i = 0; i < cols; ++i)
				row.put(meta.getColumnName(i + 1), result.getObject(i + 1));
			results.add(new Row(row));
			result.next();
		}
		return new Set(results);
	}

	List<IValue> getValues(PreparedStatement statement) throws SQLException
	{
		output.finer("Running SQL: %s", statement);
		ResultSet result = statement.executeQuery();
		if (!result.first())
			return Lists.newArrayList();
		ResultSetMetaData meta = result.getMetaData();
		int cols = meta.getColumnCount();
		if (cols == 0)
			return Lists.newArrayList();
		ArrayList<IValue> results = new ArrayList<IValue>();
		while (!result.isAfterLast())
		{
			results.add(new Value(result.getObject(1)));
			result.next();
		}
		return results;
	}

	PreparedStatement prepare(String query) throws SQLException
	{
		Connection conn = getConnection();
		return conn.prepareStatement(query);
	}

	void setParams(PreparedStatement statement, Object... params) throws SQLException
	{
		for (int i = 0; i < params.length; i++)
		{
			if (params[i] instanceof DateTime)
				statement.setObject(i + 1, new Timestamp(((DateTime) params[i]).getMillis()));
			else
				statement.setObject(i + 1, params[i]);
		}
	}

	protected abstract Connection getConnection();

	final IOutput output;
}
