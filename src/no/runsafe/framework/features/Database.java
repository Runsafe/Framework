package no.runsafe.framework.features;

import no.runsafe.framework.internal.database.SchemaUpdater;
import org.picocontainer.Startable;

public class Database implements Startable
{
	public Database(SchemaUpdater updater, no.runsafe.framework.internal.database.jdbc.Database database)
	{
		this.updater = updater;
		this.database = database;
	}

	@Override
	public void start()
	{
		updater.execute();
		database.open();
	}

	@Override
	public void stop()
	{
	}

	private final SchemaUpdater updater;
	private final no.runsafe.framework.internal.database.jdbc.Database database;
}
