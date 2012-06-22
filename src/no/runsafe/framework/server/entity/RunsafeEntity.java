package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.RunsafeWorld;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class RunsafeEntity {

	public static List<RunsafeEntity> convert(Entity[] entities) {
		ArrayList<RunsafeEntity> result = new ArrayList<RunsafeEntity>();
		for(Entity entity : entities)
			result.add(new RunsafeEntity(entity));
		return result;
	}

	public RunsafeEntity(Entity toWrap) {
		entity = toWrap;
	}

	public Entity getRaw() {
		return entity;
	}

	public RunsafeWorld getWorld() {
		return new RunsafeWorld(entity.getWorld());
	}

	private final Entity entity;
}
