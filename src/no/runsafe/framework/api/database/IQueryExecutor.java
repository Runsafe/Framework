package no.runsafe.framework.api.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import org.joda.time.DateTime;

import java.util.List;

public interface IQueryExecutor
{
	ISet query(String query, Object... params);
	IRow queryRow(String query, Object... params);
	List<String> queryStrings(String query, Object... params);
	List<Integer> queryIntegers(String query, Object... params);
	List<Long> queryLongs(String query, Object... params);
	List<Double> queryDoubles(String query, Object... params);
	List<Float> queryFloats(String query, Object... params);
	List<DateTime> queryDateTimes(String query, Object... params);
	List<IPlayer> queryPlayers(String query, Object... params);
	List<IWorld> queryWorlds(String query, Object... params);
	List<ILocation> queryLocations(String query, Object... params);
	boolean execute(String query, Object... params);
	int update(String query, Object... params);
	String queryString(String query, Object... params);
	Integer queryInteger(String query, Object... params);
	Long queryLong(String query, Object... params);
	Double queryDouble(String query, Object... params);
	Float queryFloat(String query, Object... params);
	DateTime queryDateTime(String query, Object... params);
	IPlayer queryPlayer(String query, Object... params);
	IWorld queryWorld(String query, Object... params);
	ILocation queryLocation(String query, Object... params);
	List<IValue> queryColumn(String query, Object... params);
	IValue queryValue(String query, Object... params);
}
