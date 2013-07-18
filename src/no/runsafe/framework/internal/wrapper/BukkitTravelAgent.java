package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.minecraft.RunsafeLocation;
import org.bukkit.TravelAgent;

public abstract class BukkitTravelAgent
{
	protected BukkitTravelAgent(TravelAgent travelAgent)
	{
		this.travelAgent = travelAgent;
	}

	public boolean createPortal(RunsafeLocation location)
	{
		return travelAgent.createPortal(location.getRaw());
	}

	public RunsafeLocation findOrCreate(RunsafeLocation location)
	{
		return ObjectWrapper.convert(travelAgent.findOrCreate(location.getRaw()));
	}

	public RunsafeLocation findPortal(RunsafeLocation location)
	{
		return ObjectWrapper.convert(travelAgent.findPortal(location.getRaw()));
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
