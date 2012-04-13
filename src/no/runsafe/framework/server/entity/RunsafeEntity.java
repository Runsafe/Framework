package no.runsafe.framework.server.entity;

import org.bukkit.entity.Entity;

public class RunsafeEntity
{
	public RunsafeEntity(Entity toWrap)
	{
		entity = toWrap;
	}

	private Entity entity;
}
