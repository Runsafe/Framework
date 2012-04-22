package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockRedstoneEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockRedstoneEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class BlockRedstone implements Listener
{
    public BlockRedstone(IBlockRedstoneEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(BlockRedstoneEvent event)
    {
        eventSubscriber.OnBlockRedstoneEvent(new RunsafeBlockRedstoneEvent(event));
    }

    private IBlockRedstoneEvent eventSubscriber;
}
