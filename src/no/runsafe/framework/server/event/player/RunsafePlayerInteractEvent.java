package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.event.CancellableEvent;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RunsafePlayerInteractEvent extends RunsafePlayerEvent implements CancellableEvent
{
    public RunsafePlayerInteractEvent(PlayerInteractEvent toWrap)
    {
        super(toWrap);
        event = toWrap;
    }

    public Action getAction()
    {
        return event.getAction();
    }

    public Block getBlock()
    {
        return event.getClickedBlock();
    }

    public ItemStack getItemStack()
    {
        return event.getItem();
    }

    @Override
    public boolean getCancelled()
    {
        return event.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel)
    {
        event.setCancelled(cancel);
    }

    private PlayerInteractEvent event;
}
