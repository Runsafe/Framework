package no.runsafe.framework.minecraft.player;

import org.apache.commons.lang.StringUtils;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class RunsafeAmbiguousPlayer extends RunsafePlayer
{
	public RunsafeAmbiguousPlayer(OfflinePlayer toWrap, List<String> ambiguous)
	{
		super(toWrap);
		ambiguity = ambiguous;
	}

	public RunsafeAmbiguousPlayer(List<RunsafePlayer> online)
	{
		super(online.get(0).getRawPlayer());
		ambiguity = new ArrayList<String>(online.size());
		for (RunsafePlayer option : online)
			ambiguity.add(option.getName());
	}

	public Iterable<String> getAmbiguity()
	{
		return ambiguity;
	}

	@Override
	public String toString()
	{
		if (ambiguity == null)
			return "No matches found";

		if (ambiguity.size() > 5)
			return String.format("Your enquiry matches &6%d&r players, please be more specific.", ambiguity.size());

		return String.format("Multiple matches found: &6%s&r.", StringUtils.join(ambiguity, "&r, &6"));
	}

	private final List<String> ambiguity;
}
