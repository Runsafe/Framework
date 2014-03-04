package no.runsafe.framework.api.command.argument;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IArgumentList
{
	@Deprecated
	boolean containsKey(Object key);

	@Deprecated
	int size();

	@Deprecated
	boolean isEmpty();

	@Deprecated
	boolean containsValue(Object value);

	@Deprecated
	String put(String key, String value);

	@Deprecated
	String remove(Object key);

	@Deprecated
	void putAll(Map<? extends String, ? extends String> m);

	@Deprecated
	void clear();

	@Deprecated
	Set<String> keySet();

	@Deprecated
	Collection<String> values();

	@Deprecated
	Set<Map.Entry<String, String>> entrySet();

	@Nullable
	String get(Object key);
	@Nullable
	<T> T getValue(String param);
	boolean isAborted();
}
