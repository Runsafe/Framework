package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.ISignChange;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange extends EventRouterBase<ISignChange, SignChangeEvent>
{
	public SignChange(IOutput output, IScheduler scheduler, ISignChange handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(SignChangeEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(SignChangeEvent event)
	{
		return handler.OnSignChange(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getBlock()),
			event.getLines()
		);
	}

	public static void Register()
	{
		EventEngine.Register(ISignChange.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new SignChange(output, scheduler, (ISignChange) subscriber);
			}
		});
	}
}

