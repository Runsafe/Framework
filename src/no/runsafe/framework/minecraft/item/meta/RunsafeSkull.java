package no.runsafe.framework.minecraft.item.meta;

import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.item.meta.BukkitSkull;
import org.bukkit.inventory.ItemStack;

public class RunsafeSkull extends BukkitSkull
{
	public RunsafeSkull(ItemStack stack)
	{
		super(stack);
	}

	public boolean setPlayer(RunsafePlayer owner)
	{
		return setOwner(owner.getName());
	}

	public RunsafePlayer getPlayer()
	{
		return RunsafeServer.Instance.getOfflinePlayerExact(getOwner());
	}
}
