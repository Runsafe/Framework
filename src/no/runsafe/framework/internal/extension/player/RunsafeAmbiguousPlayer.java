package no.runsafe.framework.internal.extension.player;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.player.IAmbiguousPlayer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import org.apache.commons.lang.StringUtils;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class RunsafeAmbiguousPlayer extends RunsafePlayer implements IAmbiguousPlayer
{
	public RunsafeAmbiguousPlayer(OfflinePlayer toWrap, Iterable<String> ambiguous)
	{
		super(toWrap);
		ambiguity = Lists.newArrayList(ambiguous);
	}

	public RunsafeAmbiguousPlayer(List<IPlayer> online)
	{
		super((OfflinePlayer) ObjectUnwrapper.convert(online.get(0)));
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
