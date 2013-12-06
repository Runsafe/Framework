package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.item.RunsafeItemStack;
import org.bukkit.inventory.Recipe;

public abstract class BukkitRecipe
{
	protected BukkitRecipe(Recipe toWrap)
	{
		recipe = toWrap;
	}

	public RunsafeItemStack getResult()
	{
		return ObjectWrapper.convert(recipe.getResult());
	}

	protected final Recipe recipe;
}
