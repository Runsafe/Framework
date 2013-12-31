package no.runsafe.framework.api.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import org.joda.time.DateTime;

import java.util.List;

public interface IQueryExecutor
{
	ISet Query(String query, Object... params);
	IRow QueryRow(String query, Object... params);
	List<String> QueryStrings(String query, Object... params);
	List<Integer> QueryIntegers(String query, Object... params);
	List<Long> QueryLongs(String query, Object... params);
	List<Double> QueryDoubles(String query, Object... params);
	List<Float> QueryFloats(String query, Object... params);
	List<DateTime> QueryDateTimes(String query, Object... params);
	List<IPlayer> QueryPlayers(String query, Object... params);
	List<IWorld> QueryWorlds(String query, Object... params);
	List<ILocation> QueryLocations(String query, Object... params);
	boolean Execute(String query, Object... params);
	int Update(String query, Object... params);
	String QueryString(String query, Object... params);
	Integer QueryInteger(String query, Object... params);
	Long QueryLong(String query, Object... params);
	Double QueryDouble(String query, Object... params);
	Float QueryFloat(String query, Object... params);
	DateTime QueryDateTime(String query, Object... params);
	IPlayer QueryPlayer(String query, Object... params);
	IWorld QueryWorld(String query, Object... params);
	ILocation QueryLocation(String query, Object... params);

	List<IValue> QueryColumn(String query, Object... params);

	IValue QueryValue(String query, Object... params);
}
