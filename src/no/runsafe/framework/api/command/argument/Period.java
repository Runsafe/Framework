package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;
import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.Map;

public class Period extends CommandArgumentSpecification<Duration>
{
	public Period()
	{
		this("duration");
	}

	public Period(String name)
	{
		super(name);
	}

	@Override
	public Duration getValue(IPlayer context, Map<String, String> params)
	{
		String param = params.get(name);
		if (param == null || param.isEmpty())
			return defaultValue;
		try
		{
			org.joda.time.Period duration = timeParser.parsePeriod(params.get(name));
			return duration.toStandardDuration();
		}
		catch (IllegalArgumentException e)
		{
			if (context != null)
				context.sendMessage("Unrecognized time format, use y/w/d/h/m/s");
			return null;
		}
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	private final static PeriodFormatter timeParser;

	static
	{
		timeParser = new PeriodFormatterBuilder()
			.printZeroRarelyFirst().appendYears().appendSuffix("y")
			.printZeroRarelyFirst().appendWeeks().appendSuffix("w", "weeks")
			.printZeroRarelyFirst().appendDays().appendSuffix("d")
			.printZeroRarelyFirst().appendHours().appendSuffix("h")
			.printZeroRarelyFirst().appendMinutes().appendSuffix("m")
			.printZeroRarelyFirst().appendSeconds().appendSuffix("s")
			.toFormatter();
	}
}
