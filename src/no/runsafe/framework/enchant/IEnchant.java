package no.runsafe.framework.enchant;

import no.runsafe.framework.server.enchantment.RunsafeEnchantment;

public interface IEnchant
{
	public IEnchant power(int power);

	public IEnchant max();

	public IEnchant applyTo(IEnchantable target);

	public int getId();

	public String getName();

	public int getMaxLevel();

	public int getStartLevel();

	public boolean canCoexist(IEnchant enchantment);

	public boolean canEnchant(IEnchantable target);

	int power();

	RunsafeEnchantment getEnchant();
}
