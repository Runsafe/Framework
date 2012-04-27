package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.RunsafeWorld;
import org.bukkit.entity.Entity;

public class RunsafeEntity
{
	public RunsafeEntity(Entity toWrap)
	{
		entity = toWrap;
	}

    public Entity getRaw()
    {
        return entity;
    }

    public RunsafeWorld getWorld()
    {
        return new RunsafeWorld(entity.getWorld());
    }

	private Entity entity;
}
