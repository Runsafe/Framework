package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class Duration extends CommandArgumentSpecification<java.time.Duration>
{
	public Duration()
	{
		this("duration");
	}

	public Duration(String name)
	{
		super(name);
	}

	@Override
	public java.time.Duration getValue(IPlayer context, Map<String, String> params)
	{
		String param = params.get(name);
		if (param == null || param.isEmpty())
			return defaultValue;

		param = param.toLowerCase();
		if (!param.matches("^[0-9]+[y|wdhms]$"))
		{
			sendInvalidInputMessage(context);
			return null;
		}

		char timeType = param.charAt(param.length() - 1);
		long duration;
		try
		{
			duration = Long.parseLong(StringUtils.substring(param, 0, param.length() - 1));
		}
		catch (NumberFormatException e)
		{
			sendInvalidInputMessage(context);
			return null;
		}

		switch (timeType)
		{
			case 's': return java.time.Duration.ofSeconds(duration);
			case 'm': return java.time.Duration.ofMinutes(duration);
			case 'h': return java.time.Duration.ofHours(duration);
			case 'd': return java.time.Duration.ofDays(duration);
			case 'w': return java.time.Duration.ofDays(duration * 7);
			case 'y': return java.time.Duration.ofDays(duration * 365);
		}

		sendInvalidInputMessage(context);
		return null;
	}

	private void sendInvalidInputMessage(IPlayer player)
	{
		if (player != null)
			player.sendColouredMessage("&cUnrecognized time format, use &ry/w/d/h/m/s");
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}
}