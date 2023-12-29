package no.runsafe.framework.api;

public interface IOutput
{
	void broadcastColoured(String format, Object... params);
	void broadcastComplex(String message, String hoverText, String clickCommand);
}