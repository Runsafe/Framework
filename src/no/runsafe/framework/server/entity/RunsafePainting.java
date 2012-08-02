package no.runsafe.framework.server.entity;

import org.bukkit.Art;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Painting;

public class RunsafePainting extends RunsafeEntity
{
	public RunsafePainting(Painting toWrap)
	{
		super(toWrap);
		painting = toWrap;
	}

	public String getArt()
	{
		return painting.getArt().name();
	}

	public void setArt(String name)
	{
		painting.setArt(Art.getByName(name));
	}

	public void setArt(int id)
	{
		painting.setArt(Art.getById(id));
	}

	private Painting painting;
}
