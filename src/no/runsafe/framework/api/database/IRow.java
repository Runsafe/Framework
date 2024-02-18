package no.runsafe.framework.api.database;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import javax.activation.UnsupportedDataTypeException;
import java.time.Instant;

public interface IRow extends IResult
{
	String String(String column);
	Integer Integer(String column) throws UnsupportedDataTypeException;
	Long Long(String column) throws UnsupportedDataTypeException;
	Double Double(String column) throws UnsupportedDataTypeException;
	Float Float(String column) throws UnsupportedDataTypeException;
	Instant Instant(String column);
	ILocation Location() throws UnsupportedDataTypeException;
	ILocation Location(String world, String x, String y, String z) throws UnsupportedDataTypeException;
	@SuppressWarnings("MethodWithTooManyParameters")
	ILocation Location(String world, String x, String y, String z, String yaw, String pitch) throws UnsupportedDataTypeException;
	IWorld World(String column);
	IPlayer Player(String column);
	Boolean Boolean(String column) throws UnsupportedDataTypeException;
}
