package no.runsafe.framework.enchant;

import no.runsafe.framework.server.item.RunsafeItemStack;

public interface IEnchantable
{
	boolean enchanted();

	boolean enchanted(IEnchant enchant);

	IEnchantable enchant(IEnchant enchant);

	IEnchantable disenchant();

	IEnchantable disenchant(IEnchant enchant);

	RunsafeItemStack getItem();

	IEnchantable enchant(Iterable<IEnchant> enchants);
}

