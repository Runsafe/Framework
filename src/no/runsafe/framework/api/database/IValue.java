package no.runsafe.framework.api.database;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import javax.activation.UnsupportedDataTypeException;
import java.time.Instant;

public interface IValue extends IResult
{
	String String();
	Integer Integer() throws UnsupportedDataTypeException;
	Long Long() throws UnsupportedDataTypeException;
	Double Double() throws UnsupportedDataTypeException;
	Float Float() throws UnsupportedDataTypeException;
	Instant Instant();
	IPlayer Player();
	IWorld World();
}
