package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IArgumentList extends Map<String, String>
{
	@Deprecated
	@Override
	boolean containsKey(Object key);

	@Nullable
	<T> T getValue(String param);
	boolean isAborted();
}
