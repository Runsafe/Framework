package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.ILocation;
import org.bukkit.Location;
import org.bukkit.TravelAgent;

public abstract class BukkitTravelAgent
{
	protected BukkitTravelAgent(TravelAgent travelAgent)
	{
		this.travelAgent = travelAgent;
	}

	public boolean createPortal(ILocation location)
	{
		return travelAgent.createPortal((Location) ObjectUnwrapper.convert(location));
	}

	public ILocation findOrCreate(ILocation location)
	{
		return ObjectWrapper.convert(travelAgent.findOrCreate((Location) ObjectUnwrapper.convert(location)));
	}

	public ILocation findPortal(ILocation location)
	{
		return ObjectWrapper.convert(travelAgent.findPortal((Location) ObjectUnwrapper.convert(location)));
	}

	public boolean getCanCreatePortal()
	{
		return travelAgent.getCanCreatePortal();
	}

	public int getSearchRadius()
	{
		return travelAgent.getSearchRadius();
	}

	public void setCanCreatePortal(boolean create)
	{
		travelAgent.setCanCreatePortal(create);
	}

	public BukkitTravelAgent setCreationRadius(int radius)
	{
		travelAgent.setCreationRadius(radius);
		return this;
	}

	public BukkitTravelAgent setSearchRadius(int radius)
	{
		travelAgent.setSearchRadius(radius);
		return this;
	}

	public TravelAgent getRaw()
	{
		return travelAgent;
	}

	protected final TravelAgent travelAgent;
}
