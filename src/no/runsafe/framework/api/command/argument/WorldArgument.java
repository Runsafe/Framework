package no.runsafe.framework.api.command.argument;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeServer;

import javax.annotation.Nullable;
import java.util.List;

public class WorldArgument extends CommandArgumentSpecification implements ITabComplete
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
			RunsafeServer.InternalAPI.getWorlds(),
			new Function<IWorld, String>()
			{
				@Override
				public String apply(@Nullable IWorld IWorld)
				{
					assert IWorld != null;
					return IWorld.getName();
				}
			}
		);
	}

	private final boolean required;
}
