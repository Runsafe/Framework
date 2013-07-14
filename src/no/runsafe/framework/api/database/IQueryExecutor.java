package no.runsafe.framework.api.database;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
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
	List<RunsafePlayer> QueryPlayers(String query, Object... params);
	List<RunsafeWorld> QueryWorlds(String query, Object... params);
	List<RunsafeLocation> QueryLocations(String query, Object... params);
	boolean Execute(String query, Object... params);
	int Update(String query, Object... params);
	String QueryString(String query, Object... params);
	Integer QueryInteger(String query, Object... params);
	Long QueryLong(String query, Object... params);
	Double QueryDouble(String query, Object... params);
	Float QueryFloat(String query, Object... params);
	DateTime QueryDateTime(String query, Object... params);
	RunsafePlayer QueryPlayer(String query, Object... params);
	RunsafeWorld QueryWorld(String query, Object... params);
	RunsafeLocation QueryLocation(String query, Object... params);
}
