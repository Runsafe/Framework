package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockDispenseEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockDispenseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class BlockDispense implements Listener
{
    public BlockDispense(IBlockDispenseEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(BlockDispenseEvent event)
    {
        eventSubscriber.OnBlockDispenseEvent(new RunsafeBlockDispenseEvent(event));
    }

    private IBlockDispenseEvent eventSubscriber;
}
