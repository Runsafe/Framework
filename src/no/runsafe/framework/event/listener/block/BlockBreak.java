package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockBreakEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener
{
    public BlockBreak(IBlockBreakEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(BlockBreakEvent event)
    {
        eventSubscriber.OnBlockBreakEvent(new RunsafeBlockBreakEvent(event));
    }

    private IBlockBreakEvent eventSubscriber;
}
