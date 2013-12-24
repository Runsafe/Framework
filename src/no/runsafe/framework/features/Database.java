package no.runsafe.framework.features;

import no.runsafe.framework.internal.database.SchemaUpdater;
import org.picocontainer.Startable;

public class Database implements Startable
{
	public Database(SchemaUpdater updater)
	{
		this.updater = updater;
	}

	@Override
	public void start()
	{
		updater.execute();
	}

	@Override
	public void stop()
	{
	}

	private final SchemaUpdater updater;
}
