package no.runsafe.framework.api.database;

/**
 * Base class for database repositories, providing methods for converting SQL Timestamp to and from Joda DateTime
 */
public abstract class Repository implements ISchemaChanges
{
	@SuppressWarnings("NoopMethodInAbstractClass")
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
