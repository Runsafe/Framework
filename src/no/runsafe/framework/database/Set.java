package no.runsafe.framework.database;

import java.util.ArrayList;
import java.util.Collection;

public class Set extends ArrayList<Row>
{
	public Set(Collection<Row> dataSet)
	{
		this.addAll(dataSet);
	}
}
