package no.runsafe.framework.internal.wrapper.chunk;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.Chunk;

import javax.annotation.Nullable;
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

	public RunsafeWorld getWorld()
	{
		return ObjectWrapper.convert(chunk.getWorld());
	}

	public RunsafeBlock getBlock(int i, int i1, int i2)
	{
		return ObjectWrapper.convert(chunk.getBlock(i, i1, i2));
	}

	@Nullable
	public List<RunsafeEntity> getEntities()
	{
		return ObjectWrapper.convert(chunk.getEntities());
	}

	public List<RunsafeBlockState> getTileEntities()
	{
		return ObjectWrapper.convert(chunk.getTileEntities());
	}

	@Deprecated
	public boolean isLoaded()
	{
		return !isUnloaded();
	}

	public boolean isUnloaded()
	{
		return !chunk.isLoaded();
	}

	public boolean load(boolean b)
	{
		return chunk.load(b);
	}

	public boolean load()
	{
		return chunk.load();
	}

	public boolean unload(boolean b, boolean b1)
	{
		return chunk.unload(b, b1);
	}

	public boolean unload(boolean b)
	{
		return chunk.unload(b);
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
