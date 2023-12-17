package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.ICreature;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class RunsafeCreature extends RunsafeLivingEntity implements ICreature
{
	public RunsafeCreature(Creature toWrap)
	{
		super(toWrap);
		creature = toWrap;
	}

	@Override
	public ILivingEntity getTarget()
	{
		return ObjectWrapper.convert(creature.getTarget());
	}

	@Override
	public void setTarget(ILivingEntity target)
	{
		creature.setTarget((LivingEntity) ObjectUnwrapper.convert(target));
	}

	private final Creature creature;
}
