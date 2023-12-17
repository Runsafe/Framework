package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeHanging;
import org.bukkit.Art;
import org.bukkit.entity.Painting;

public abstract class BukkitPainting extends RunsafeHanging
{
	protected BukkitPainting(Painting toWrap)
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

	@Override
	public Painting getRaw()
	{
		return painting;
	}

	protected final Painting painting;
}
