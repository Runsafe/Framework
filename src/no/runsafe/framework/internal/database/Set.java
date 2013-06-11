package no.runsafe.framework.internal.database;

import java.util.ArrayList;
import java.util.Collection;

public final class Set extends ArrayList<Row>
{
	public Set(Collection<Row> dataSet)
	{
		this.addAll(dataSet);
	}
}
