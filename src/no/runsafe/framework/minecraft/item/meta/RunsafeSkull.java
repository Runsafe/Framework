package no.runsafe.framework.minecraft.item.meta;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.internal.wrapper.item.meta.BukkitSkull;
import org.bukkit.inventory.ItemStack;

public class RunsafeSkull extends BukkitSkull
{
	public RunsafeSkull(ItemStack stack)
	{
		super(stack);
	}

	public boolean setPlayer(IPlayer owner)
	{
		return setOwner(owner.getName());
	}

	public IPlayer getPlayer()
	{
		return RunsafeServer.Instance.getOfflinePlayerExact(getOwner());
	}
}
