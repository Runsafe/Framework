package no.runsafe.framework.api.database;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.joda.time.DateTime;

public interface IRow
{
	String String(String column);
	Integer Integer(String column);
	Long Long(String column);
	Double Double(String column);
	Float Float(String column);
	DateTime DateTime(String column);
	RunsafeLocation Location();
	RunsafeLocation Location(String world, String x, String y, String z);
	RunsafeLocation Location(String world, String x, String y, String z, String yaw, String pitch);
	RunsafeWorld World(String column);
	RunsafePlayer Player(String column);
}
