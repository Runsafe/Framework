package no.runsafe.framework.wrapper;

import no.runsafe.framework.server.RunsafeLocation;
import org.bukkit.TravelAgent;

public abstract class BukkitTravelAgent
{
	public BukkitTravelAgent(TravelAgent travelAgent)
	{
		this.travelAgent = travelAgent;
	}

	public boolean createPortal(RunsafeLocation location)
	{
		return this.travelAgent.createPortal(location.getRaw());
	}

	public RunsafeLocation findOrCreate(RunsafeLocation location)
	{
		return ObjectWrapper.convert(this.travelAgent.findOrCreate(location.getRaw()));
	}

	public RunsafeLocation findPortal(RunsafeLocation location)
	{
		return ObjectWrapper.convert(this.travelAgent.findPortal(location.getRaw()));
	}

	public boolean getCanCreatePortal()
	{
		return this.travelAgent.getCanCreatePortal();
	}

	public int getSearchRadius()
	{
		return this.travelAgent.getSearchRadius();
	}

	public void setCanCreatePortal(boolean create)
	{
		this.travelAgent.setCanCreatePortal(create);
	}

	public BukkitTravelAgent setCreationRadius(int radius)
	{
		this.travelAgent.setCreationRadius(radius);
		return this;
	}

	public BukkitTravelAgent setSearchRadius(int radius)
	{
		this.travelAgent.setSearchRadius(radius);
		return this;
	}

	public TravelAgent getRaw()
	{
		return this.travelAgent;
	}

	protected final TravelAgent travelAgent;
}
