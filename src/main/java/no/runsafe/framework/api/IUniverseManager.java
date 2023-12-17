package no.runsafe.framework.api;

import no.runsafe.framework.api.hook.IUniverseMapper;

import javax.annotation.Nullable;
import java.util.List;

public interface IUniverseManager
{
	@Nullable
	IUniverse getByName(String name);

	@Nullable
	IUniverse getByWorld(IWorld world);

	List<IWorld> getAllWorlds();

	@Nullable
	IWorld getWorld(String name);

	void addUniversesForMapper(IUniverseMapper mapper);

	void flush();
}
