package no.runsafe.framework.enchant;

import no.runsafe.framework.server.item.RunsafeItemStack;

import java.util.List;

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

