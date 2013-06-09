package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.wrapper.item.meta.BukkitSkull;
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
