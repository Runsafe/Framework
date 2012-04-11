package no.runsafe.framework.entity.event;

import no.runsafe.framework.event.IRunsafeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface IEntityDamageByEntityEvent extends IRunsafeEvent
{
	void OnEntityDamageByEntity(EntityDamageByEntityEvent event);
}
