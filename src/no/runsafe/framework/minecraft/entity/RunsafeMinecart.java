package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitMinecart;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;

public class RunsafeMinecart extends BukkitMinecart
{
	public RunsafeMinecart(Minecart toWrap)
	{
		super(toWrap);
	}

	/**
	 * Sets the block to display.
	 * @param displayBlock Block to display inside the minecart.
	 */
	public void setDisplayBlock(org.bukkit.Material displayBlock)
	{
		minecart.setDisplayBlock(new MaterialData(displayBlock));
	}
}
