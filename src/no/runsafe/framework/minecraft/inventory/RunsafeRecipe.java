package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitRecipe;
import org.bukkit.inventory.Recipe;

public class RunsafeRecipe extends BukkitRecipe
{
	public RunsafeRecipe(Recipe toWrap)
	{
		super(toWrap);
	}
}
