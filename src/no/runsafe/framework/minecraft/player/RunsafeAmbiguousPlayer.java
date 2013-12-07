package no.runsafe.framework.minecraft.player;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.player.IAmbiguousPlayer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class RunsafeAmbiguousPlayer extends RunsafePlayer implements IAmbiguousPlayer
{
	public RunsafeAmbiguousPlayer(OfflinePlayer toWrap, List<String> ambiguous)
	{
		super(toWrap);
		ambiguity = ambiguous;
	}

	public RunsafeAmbiguousPlayer(List<IPlayer> online)
	{
		super(((BukkitPlayer) online.get(0)).getRawPlayer());
		ambiguity = new ArrayList<String>(online.size());
		for (IPlayer option : online)
			ambiguity.add(option.getName());
	}

	@Override
	public Iterable<String> getAmbiguity()
	{
		return ImmutableList.copyOf(ambiguity);
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
