package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class BukkitSpawnEgg extends RunsafeMeta
{
	protected BukkitSpawnEgg(ItemStack stack)
	{
		super(stack);
	}

	public RunsafeEntityType getEntityType()
	{
		return ObjectWrapper.convert(((SpawnEggMeta) itemStack).getSpawnedType());
	}
}
