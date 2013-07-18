package no.runsafe.framework.api.minecraft;

import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;

public interface IEnchant
{
	IEnchant power(int power);

	IEnchant max();

	IEnchant applyTo(IEnchantable target);

	int getId();

	String getName();

	int getMaxLevel();

	int getStartLevel();

	boolean canCoexist(IEnchant enchantment);

	boolean canEnchant(IEnchantable target);

	int power();

	RunsafeEnchantment getEnchant();
}
