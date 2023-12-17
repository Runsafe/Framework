package no.runsafe.framework.api;

import java.util.List;

public interface IKernel
{
	void addComponent(Object implOrInstance);

	<T> T getComponent(Class<T> type);

	<T> List<T> getComponents(Class<T> type);

	<T> T getInstance(Class<T> type);
}