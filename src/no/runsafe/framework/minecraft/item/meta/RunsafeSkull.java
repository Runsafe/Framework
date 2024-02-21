package no.runsafe.framework.minecraft.item.meta;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.internal.wrapper.item.meta.BukkitSkull;
import org.bukkit.inventory.ItemStack;

public class RunsafeSkull extends BukkitSkull
{
	public RunsafeSkull(ItemStack stack)
	{
		super(stack);
	}

	public void setPlayer(IPlayer owner)
	{
		setOwner(owner);
	}

	public IPlayer getPlayer()
	{
		return Player.Get().getExact(getOwner());
	}
}
