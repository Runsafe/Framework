package no.runsafe.framework.server.entity;

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

	private Entity entity;
}
