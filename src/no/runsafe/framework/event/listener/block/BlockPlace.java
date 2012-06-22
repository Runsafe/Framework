package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockPlaceEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener
{
    public BlockPlace(IBlockPlaceEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(BlockPlaceEvent event)
    {
        eventSubscriber.OnBlockPlaceEvent(new RunsafeBlockPlaceEvent(event));
    }

    private final IBlockPlaceEvent eventSubscriber;
}
