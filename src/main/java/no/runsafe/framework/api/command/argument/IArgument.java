package no.runsafe.framework.api.command.argument;

public interface IArgument extends CharSequence
{
	boolean isRequired();
	boolean isWhitespaceInclusive();
}
