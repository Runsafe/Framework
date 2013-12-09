package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.ISchemaChanges;
import no.runsafe.framework.api.database.ITransaction;
import org.picocontainer.Startable;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

/**
 * This class handles database schema updates
 */
@SuppressWarnings("OverloadedVarargsMethod")
public final class SchemaUpdater implements Startable
{
	/**
	 * This is needed for pico to not throw exceptions
	 *
	 * @param db     The database handler
	 * @param output The console to log information to
	 */
	public SchemaUpdater(IDatabase db, IConsole output)
	{
		this(db, output, new ISchemaChanges[0]);
	}

	/**
	 * @param db             The database handler
	 * @param output         The console to log information to
	 * @param schemaUpdaters Schema updaters
	 */
	public SchemaUpdater(IDatabase db, IConsole output, ISchemaChanges... schemaUpdaters)
	{
		this.schemaUpdaters = schemaUpdaters;
		database = db;
		console = output;
		if (SchemaUpdater.uninitialized)
			Initialize(db);
	}

	private static void Initialize(IDatabase database)
	{
		database.Execute(
			"CREATE TABLE IF NOT EXISTS runsafe_schema (" +
				"`table` varchar(255) NOT NULL," +
				"`revision` int(11) NOT NULL," +
				"PRIMARY KEY (`table`)" +
				')'
		);
		SchemaUpdater.uninitialized = false;
	}

	int getRevision(String table)
	{
		Integer revision = database.QueryInteger("SELECT `revision` FROM runsafe_schema WHERE `table`=?", table);
		return revision == null ? 0 : revision;
	}

	void setRevision(String table, int revision)
	{
		database.Update(
			"INSERT INTO runsafe_schema (`table`,`revision`) VALUES (?,?)" +
				"ON DUPLICATE KEY UPDATE `revision`=VALUES(`revision`)",
			table, revision
		);
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

	@SuppressWarnings("MethodWithMultipleLoops")
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

	private int executeSchemaChanges(String tableName, int oldRevision, int newRevision, Iterable<String> queries)
	{
		ITransaction transaction = database.Isolate();
		console.logInformation("Updating table %s from revision %d to revision %d", tableName, oldRevision, newRevision);
		for (String sql : queries)
		{
			if (!transaction.Execute(sql))
			{
				console.writeColoured("Failed executing query:\n%s", Level.INFO, sql);
				console.writeColoured("&cRolling back transaction..", Level.INFO);
				transaction.Rollback();
				return oldRevision;
			}
		}
		transaction.Commit();
		return newRevision;
	}

	private final IDatabase database;
	private final IConsole console;
	private final ISchemaChanges[] schemaUpdaters;
	private static boolean uninitialized = true;
}
