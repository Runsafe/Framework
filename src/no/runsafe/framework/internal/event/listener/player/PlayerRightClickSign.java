package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerRightClickSign;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.block.RunsafeSign;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class PlayerRightClickSign extends EventRouterBase<IPlayerRightClickSign, PlayerInteractEvent>
{
	public PlayerRightClickSign(IOutput output, IScheduler scheduler, IPlayerRightClickSign handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerInteractEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerInteractEvent event)
	{
		return (event.getAction() != Action.RIGHT_CLICK_BLOCK)
			|| event.getClickedBlock() == null
			|| !(event.getClickedBlock().getState() instanceof Sign)
			|| handler.OnPlayerRightClickSign(
					ObjectWrapper.convert(event.getPlayer()),
					ObjectWrapper.convert(event.getItem()),
					(RunsafeSign)ObjectWrapper.convert(event.getClickedBlock().getState())
				);

	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerRightClickSign.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerRightClickSign(output, scheduler, (IPlayerRightClickSign) subscriber);
			}
		};
	}
}
