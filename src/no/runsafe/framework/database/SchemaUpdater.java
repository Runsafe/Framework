package no.runsafe.framework.database;

import no.runsafe.framework.output.IOutput;
import org.picocontainer.Startable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public final class SchemaUpdater implements Startable
{
	public SchemaUpdater(IDatabase db, IOutput output)
	{
		this(db, output, null);
	}

	public SchemaUpdater(IDatabase db, IOutput output, ISchemaChanges[] schemaUpdaters)
	{
		this.schemaUpdaters = schemaUpdaters;
		database = db;
		console = output;
		try
		{
			PreparedStatement create = database.prepare(
				"CREATE TABLE IF NOT EXISTS runsafe_schema (" +
					"`table` varchar(255) NOT NULL," +
					"`revision` int(11) NOT NULL," +
					"PRIMARY KEY (`table`)" +
					")"
			);
			create.execute();
			create.close();
		}
		catch (SQLException e)
		{
			console.logException(e);
		}
	}

	public int getRevision(String table)
	{
		PreparedStatement select = database.prepare("SELECT `revision` FROM runsafe_schema WHERE `table`=?");
		try
		{
			select.setString(1, table);
			ResultSet result = select.executeQuery();
			int rev = -1;
			if (result == null || result.wasNull())
				return 0;
			if (result.first())
				rev = result.getInt(1);
			result.close();
			select.close();
			return rev;
		}
		catch (SQLException e)
		{
			console.logException(e);
		}
		return -1;
	}

	public void setRevision(String table, int revision)
	{
		PreparedStatement update = database.prepare(
			"INSERT INTO runsafe_schema (`table`,`revision`) VALUES (?,?)" +
				"ON DUPLICATE KEY UPDATE `revision`=VALUES(`revision`)"
		);
		try
		{
			update.setString(1, table);
			update.setInt(2, revision);
			update.execute();
			update.close();
		}
		catch (SQLException e)
		{
			console.logException(e);
		}
	}

	@Override
	public void start()
	{
		if (schemaUpdaters != null && schemaUpdaters.length > 0)
			executeSchemaChanges();
	}

	@Override
	public void stop()
	{
	}

	private void executeSchemaChanges()
	{
		for (ISchemaChanges changes : schemaUpdaters)
		{
			int revision = getRevision(changes.getTableName());
			HashMap<Integer, List<String>> queries = changes.getSchemaUpdateQueries();
			for (Integer rev : queries.keySet())
			{
				if (rev > revision)
				{
					revision = executeSchemaChanges(changes.getTableName(), revision, rev, queries.get(rev));

					// Update failed, abort now
					if (revision < rev)
						break;
				}
			}
			setRevision(changes.getTableName(), revision);
		}
	}

	private int executeSchemaChanges(String tableName, int oldRevision, int newRevision, List<String> queries)
	{
		String sqlQuery = null;
		Connection transaction = database.beginTransaction();
		try
		{
			console.write(String.format("Updating table %s from revision %d to revision %d", tableName, oldRevision, newRevision));
			for (String sql : queries)
			{
				sqlQuery = sql;
				PreparedStatement query = transaction.prepareStatement(sql);
				query.execute();
			}
			database.commitTransaction(transaction);
			return newRevision;
		}
		catch (SQLException e)
		{
			console.logException(e);
			console.writeColoured("Failed executing query:\n%s", sqlQuery);
			console.writeColoured("&cRolling back transaction..");
			try
			{
				transaction.rollback();
			}
			catch (SQLException e1)
			{
				console.writeColoured("&4Failed rolling back transaction!");
				console.logException(e1);
			}
		}
		return oldRevision;
	}


	private final IDatabase database;
	private final IOutput console;
	private final ISchemaChanges[] schemaUpdaters;
}
