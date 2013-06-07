package no.runsafe.framework.server;

import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.TravelAgent;

public class RunsafeTravelAgent
{
	public RunsafeTravelAgent(TravelAgent travelAgent)
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

	public RunsafeTravelAgent setCreationRadius(int radius)
	{
		this.travelAgent.setCreationRadius(radius);
		return this;
	}

	public RunsafeTravelAgent setSearchRadius(int radius)
	{
		this.travelAgent.setSearchRadius(radius);
		return this;
	}

	public TravelAgent getRaw()
	{
		return this.travelAgent;
	}

	private final TravelAgent travelAgent;
}
