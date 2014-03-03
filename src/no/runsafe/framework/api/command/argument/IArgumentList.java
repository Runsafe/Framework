package no.runsafe.framework.api.command.argument;

import javax.annotation.Nullable;
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
