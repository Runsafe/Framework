package no.runsafe.framework.entity.event;

import no.runsafe.framework.event.IRunsafeEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public interface IEntityDeathEvent extends IRunsafeEvent
{
	public void OnEntityDeath(EntityDeathEvent event);
}
