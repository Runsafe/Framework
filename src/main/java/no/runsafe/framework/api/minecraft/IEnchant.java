package no.runsafe.framework.api.minecraft;

import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;

public interface IEnchant
{
	IEnchant power(int power);

	@SuppressWarnings("InstanceMethodNamingConvention")
	IEnchant max();

	IEnchant applyTo(IEnchantable target);

	int getId();

	String getName();

	int getMaxLevel();

	int getStartLevel();

	boolean isOn(IEnchantable target);

	boolean canCoexist(IEnchant enchantment);

	boolean canEnchant(IEnchantable target);

	int power();

	RunsafeEnchantment getEnchant();
}
