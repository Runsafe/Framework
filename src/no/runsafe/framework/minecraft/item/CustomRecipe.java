package no.runsafe.framework.minecraft.item;

import no.runsafe.framework.api.item.ICustomRecipe;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomRecipe implements ICustomRecipe
{
	public CustomRecipe(RunsafeMeta result)
	{
		this.result = result;
	}

	@Override
	public Map<Integer, RunsafeMeta> getRecipe()
	{
		return recipe;
	}

	@Override
	public void addIngredient(int slotID, RunsafeMeta item)
	{
		recipe.put(slotID, item);
	}

	@Override
	public RunsafeMeta getResult()
	{
		return result;
	}

	private final RunsafeMeta result;
	private final Map<Integer, RunsafeMeta> recipe = new HashMap<Integer, RunsafeMeta>(0);
}
