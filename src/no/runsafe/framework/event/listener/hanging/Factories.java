package no.runsafe.framework.event.listener.hanging;

import no.runsafe.framework.event.EventEngine;

public class Factories
{
	public static void Register()
	{
		EventEngine.Register(ItemFramePlace.Factory());
		EventEngine.Register(PaintingPlace.Factory());
	}
}
