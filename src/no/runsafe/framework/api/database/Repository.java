package no.runsafe.framework.api.database;

/**
 * Base class for database repositories
 */
public abstract class Repository implements ISchemaChanges
{
	protected void onDatabaseReady()
	{
	}

	@Override
	public final void connect(IDatabase database)
	{
		this.database = database;
		onDatabaseReady();
	}

	protected IDatabase database;
}
