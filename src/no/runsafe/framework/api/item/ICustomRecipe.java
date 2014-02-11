package no.runsafe.framework.api.item;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.util.Map;

public interface ICustomRecipe
{
	RunsafeMeta getResult();
	Map<Integer, RunsafeMeta> getRecipe();
	void addIngredient(int slotID, RunsafeMeta item);
	void setResult(RunsafeMeta result);
}
