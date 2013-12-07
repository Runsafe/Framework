package no.runsafe.framework.api.database;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import org.joda.time.DateTime;

public interface IRow extends IResult
{
	String String(String column);
	Integer Integer(String column);
	Long Long(String column);
	Double Double(String column);
	Float Float(String column);
	DateTime DateTime(String column);
	RunsafeLocation Location();
	RunsafeLocation Location(String world, String x, String y, String z);
	@SuppressWarnings("MethodWithTooManyParameters")
	RunsafeLocation Location(String world, String x, String y, String z, String yaw, String pitch);
	RunsafeWorld World(String column);
	IPlayer Player(String column);
}
