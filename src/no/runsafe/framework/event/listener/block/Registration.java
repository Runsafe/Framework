package no.runsafe.framework.event.listener.block;

public final class Registration
{
	public static void Run()
	{
		BlockBreak.Register();
		BlockBreakListener.Register();
		BlockDispense.Register();
		BlockDispenseListener.Register();
		BlockPlace.Register();
		BlockPlaceListener.Register();
		BlockRedstone.Register();
		BlockRedstoneListener.Register();
		SignChange.Register();
	}
}
