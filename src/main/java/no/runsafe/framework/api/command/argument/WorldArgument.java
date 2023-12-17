package no.runsafe.framework.api.command.argument;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.IUniverseManager;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.brane.Multiverse;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class WorldArgument extends CommandArgumentSpecification<IWorld> implements ListOf.Compatible<IWorld>
{
	public WorldArgument()
	{
		this("world");
	}

	public WorldArgument(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		return Lists.transform(
			Multiverse.getInstance().getAllWorlds(),
			new Function<IWorld, String>()
			{
				@Override
				public String apply(@Nullable IWorld world)
				{
					assert world != null;
					return world.getName();
				}
			}
		);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return null;

		String filter = value.toLowerCase();
		String partialMatch = null;

		for (IWorld world : Multiverse.getInstance().getAllWorlds())
		{
			String worldName = world.getName();

			if (worldName.equalsIgnoreCase(filter))
				return worldName;

			if (world.getName().toLowerCase().startsWith(filter))
				partialMatch = world.getName();
		}

		return partialMatch;
	}

	@Override
	public IWorld getValue(IPlayer context, Map<String, String> params)
	{
		String param = params.get(name);
		if (param != null && !param.isEmpty())
			return InjectionPlugin.getGlobalComponent(IUniverseManager.class).getWorld(params.get(name));
		return defaultValue;
	}
}
