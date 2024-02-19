package no.runsafe.framework.internal.wrapper.chunk;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.block.BukkitBlockState;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.Chunk;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class BukkitChunk
{
	protected BukkitChunk(Chunk toWrap)
	{
		chunk = toWrap;
	}

	public int getX()
	{
		return chunk.getX();
	}

	public int getZ()
	{
		return chunk.getZ();
	}

	@Nonnull
	public IWorld getWorld()
	{
		return ObjectWrapper.convert(chunk.getWorld());
	}

	@SuppressWarnings("DataFlowIssue")
	@Nonnull
	public IBlock getBlock(int i, int i1, int i2)
	{
		Block block = chunk.getBlock(i, i1, i2);
		if (block == null)
			throw new RuntimeException("Block not found in chunk");

		return ObjectWrapper.convert(block);
	}

	@Nonnull
	public List<RunsafeEntity> getEntities()
	{
		return ObjectWrapper.convert(chunk.getEntities());
	}

	@Nonnull
	public List<BukkitBlockState> getTileEntities()
	{
		return ObjectWrapper.convert(chunk.getTileEntities());
	}

	public boolean isUnloaded()
	{
		return !chunk.isLoaded();
	}

	public boolean load(boolean generate)
	{
		return chunk.load(generate);
	}

	public boolean load()
	{
		return chunk.load();
	}

	public boolean unload(boolean save, boolean safe)
	{
		return chunk.unload(save, safe);
	}

	public boolean unload(boolean save)
	{
		return chunk.unload(save);
	}

	public boolean unload()
	{
		return chunk.unload();
	}

	public Chunk getRaw()
	{
		return chunk;
	}

	protected final Chunk chunk;
}
