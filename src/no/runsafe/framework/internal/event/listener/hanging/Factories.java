package no.runsafe.framework.internal.event.listener.hanging;

import no.runsafe.framework.internal.event.EventEngine;

public final class Factories
{
	public static void Register()
	{
		EventEngine.Register(ItemFramePlace.Factory());
		EventEngine.Register(PaintingPlace.Factory());
	}
}
