package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;

public abstract class BukkitMinecart extends RunsafeEntity
{
	protected BukkitMinecart(Minecart toWrap)
	{
		super(toWrap);
		minecart = toWrap;
	}

	/**
	 * Gets the display block if there is one.
	 * @return Display block.
	 */
	public MaterialData getDisplayBlock()
	{
		return minecart.getDisplayBlock();
	}

	/**
	 * Gets how far up or down the display block is offset.
	 * @return Display block's offset.
	 */
	public int getDisplayBlockOffset()
	{
		return minecart.getDisplayBlockOffset();
	}

	/**
	 * Sets the block to display.
	 * @param displayBlock Block to display inside the minecart.
	 */
	public void setDisplayBlock(MaterialData displayBlock)
	{
		minecart.setDisplayBlock(displayBlock);
	}

	/**
	 * Set the display block's offset.
	 * At zero the display block is sitting on the ground.
	 * 8 is what's normal for regular block carrying minecarts.
	 * @param displayBlockOffset Distance up or down to display the minecart block.
	 */
	public void setDisplayBlockOffset(int displayBlockOffset)
	{
		minecart.setDisplayBlockOffset(displayBlockOffset);
	}

	@Override
	public Minecart getRaw()
	{
		return minecart;
	}

	protected final Minecart minecart;
}
