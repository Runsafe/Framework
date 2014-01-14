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

public class WorldArgument extends CommandArgumentSpecification implements ITabComplete, IValueExpander
{
	public WorldArgument()
	{
		this(true);
	}

	public WorldArgument(boolean required)
	{
		super("world");
		this.required = required;
	}

	@Override
	public boolean isRequired()
	{
		return required;
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
	public String expand(ICommandExecutor context, String value)
	{
		for (IWorld world : Multiverse.getInstance().getAllWorlds())
			if (world.getName().toLowerCase().startsWith(value.toLowerCase()))
				return world.getName();

		return null;
	}

	public IWorld getValue(IPlayer context, Map<String, String> params)
	{
		return InjectionPlugin.getGlobalComponent(IUniverseManager.class).getWorld(params.get(name));
	}

	private final boolean required;
}
