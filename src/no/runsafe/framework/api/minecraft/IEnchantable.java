package no.runsafe.framework.api.minecraft;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public interface IEnchantable
{
	boolean enchanted();

	boolean enchanted(IEnchant enchant);

	//Only apply enchant if it's valid
	IEnchantable enchant(IEnchant enchant);

	//Allow for applying invalid enchants
	IEnchantable enchantUnsafe(IEnchant enchant);

	IEnchantable disenchant();

	IEnchantable disenchant(IEnchant enchant);

	RunsafeMeta getItem();

	//Only apply enchants if they're valid
	IEnchantable enchant(Iterable<IEnchant> enchants);

	//Allow for applying invalid enchants
	IEnchantable enchantUnsafe(Iterable<IEnchant> enchants);
}

