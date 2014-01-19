package no.runsafe.framework.api.item;

import no.runsafe.framework.api.minecraft.IEnchantable;

public interface IItemStack extends IEnchantable
{
	IItemStack clone();
	boolean equals(Object obj);
	int getAmount();
	// I
}
