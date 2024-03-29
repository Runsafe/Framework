package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public abstract class BukkitSkull extends RunsafeMeta
{
	protected BukkitSkull(ItemStack stack)
	{
		super(stack);
	}

	@Override
	public SkullMeta getRawMeta()
	{
		return (SkullMeta) itemStack.getItemMeta();
	}

	public String getOwner()
	{
		return getRawMeta().getOwner();
	}

	public boolean hasOwner()
	{
		return getRawMeta().hasOwner();
	}

	public void setOwner(IPlayer owner)
	{
		SkullMeta meta = getRawMeta();
		if(meta.setOwningPlayer(ObjectUnwrapper.convert(owner)))
			itemStack.setItemMeta(meta);
	}
}
