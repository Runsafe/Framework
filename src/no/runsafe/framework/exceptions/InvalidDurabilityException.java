package no.runsafe.framework.exceptions;

import org.bukkit.Material;

public class InvalidDurabilityException extends RuntimeException
{
	public InvalidDurabilityException(Material itemType, short durability)
	{
		material = itemType;
		this.durability = durability;
	}

	@Override
	public String getMessage()
	{
		return String.format("The material %s has a maximum durability of %d, but %d was supplied.", material.name(), material.getMaxDurability(), durability);
	}

	private final Material material;
	private final short durability;
}
