package no.runsafe.framework.api.event;

import org.bukkit.map.MapView;

public interface IMapInitializeEvent extends IRunsafeEvent
{
	void OnMapInitialize(MapView mapView);
}
