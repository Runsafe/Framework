package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.ISchemaUpdate;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.ISchemaChanges;
import no.runsafe.framework.api.database.ITransaction;

import java.util.logging.Level;

/**
 * This class handles database schema updates
 */
@SuppressWarnings("OverloadedVarargsMethod")
public final class SchemaUpdater
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
		database.execute(
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
		Integer revision = database.queryInteger("SELECT `revision` FROM runsafe_schema WHERE `table`=?", table);
		return revision == null ? 0 : revision;
	}

	void setRevision(String table, int revision)
	{
		database.update(
			"INSERT INTO runsafe_schema (`table`,`revision`) VALUES (?,?)" +
				"ON DUPLICATE KEY UPDATE `revision`=VALUES(`revision`)",
			table, revision
		);
	}

	public void execute()
	{
		if (schemaUpdaters != null && schemaUpdaters.length > 0)
			executeSchemaChanges();
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	private void executeSchemaChanges()
	{
		for (ISchemaChanges changes : schemaUpdaters)
		{
			int revision = getRevision(changes.getTableName());
			ISchemaUpdate queries = changes.getSchemaUpdateQueries();
			//.getQueries();
			for (Integer rev : queries.getRevisions())
			{
				if (rev > revision)
				{
					revision = executeSchemaChanges(changes.getTableName(), revision, rev, queries.getStatements(rev));

					// update failed, abort now
					if (revision < rev)
						break;
				}
			}
			setRevision(changes.getTableName(), revision);
		}
	}

	private int executeSchemaChanges(String tableName, int oldRevision, int newRevision, Iterable<String> queries)
	{
		ITransaction transaction = database.isolate();
		console.logInformation("Updating table %s from revision %d to revision %d", tableName, oldRevision, newRevision);
		for (String sql : queries)
		{
			if (!transaction.execute(sql))
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
