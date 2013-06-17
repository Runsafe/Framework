package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.block.ISignChange;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public final class SignChange extends EventRouterBase<ISignChange, SignChangeEvent>
{
	public SignChange(IOutput output, IScheduler scheduler, ISignChange handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(SignChangeEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(SignChangeEvent event)
	{
		return handler.OnSignChange(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getBlock()),
			event.getLines()
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return ISignChange.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new SignChange(output, scheduler, (ISignChange) subscriber);
			}
		};
	}
}

