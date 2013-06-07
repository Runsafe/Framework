package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeHanging;
import org.bukkit.Art;
import org.bukkit.entity.Painting;

public class BukkitPainting extends RunsafeHanging
{
	public BukkitPainting(Painting toWrap)
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

	protected final Painting painting;
}
