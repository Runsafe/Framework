package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitPainting;
import org.bukkit.Art;
import org.bukkit.entity.Painting;

public class RunsafePainting extends BukkitPainting
{
	public RunsafePainting(Painting toWrap)
	{
		super(toWrap);
	}

	public void NextArt()
	{
		int oldId = painting.getArt().getId();
		int newId = (oldId + 1) % Art.values().length;
		while (!painting.setArt(Art.getById(newId)) && newId != oldId)
			newId = (newId + 1) % Art.values().length;
	}

	public void PrevArt()
	{
		int oldId = painting.getArt().getId();
		int newId = oldId - 1;
		if (newId < 1)
			newId = Art.values().length;
		while (!painting.setArt(Art.getById(newId)) && newId != oldId)
		{
			newId--;
			if (newId < 1)
				newId = Art.values().length;
		}
	}
}
