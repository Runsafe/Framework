package no.runsafe.framework.enchant;

import no.runsafe.framework.server.item.meta.RunsafeMeta;

public interface IEnchantable
{
	boolean enchanted();

	boolean enchanted(IEnchant enchant);

	IEnchantable enchant(IEnchant enchant);

	IEnchantable disenchant();

	IEnchantable disenchant(IEnchant enchant);

	RunsafeMeta getItem();

	IEnchantable enchant(Iterable<IEnchant> enchants);
}

