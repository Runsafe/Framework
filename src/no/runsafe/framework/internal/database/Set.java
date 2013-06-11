package no.runsafe.framework.internal.database;

import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;

import java.util.ArrayList;
import java.util.Collection;

public final class Set extends ArrayList<IRow> implements ISet
{
	public Set(Collection<Row> dataSet)
	{
		this.addAll(dataSet);
	}
}
