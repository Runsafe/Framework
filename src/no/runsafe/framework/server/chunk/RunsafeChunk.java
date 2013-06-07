package no.runsafe.framework.server.chunk;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.Chunk;

import java.util.List;

public class RunsafeChunk
{
	public RunsafeChunk(Chunk toWrap)
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

	//RunsafeChunkSnapshot getChunkSnapshot();

	//RunsafeChunkSnapshot getChunkSnapshot(boolean b, boolean b1, boolean b2);

	public List<RunsafeEntity> getEntities()
	{
		try
		{
			return ObjectWrapper.convert(chunk.getEntities());
		}
		catch (NullPointerException npe)
		{
			return null;
		}
	}

	public List<RunsafeBlockState> getTileEntities()
	{
		return ObjectWrapper.convert(chunk.getTileEntities());
	}

	public boolean isLoaded()
	{
		return chunk.isLoaded();
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

	private final Chunk chunk;
}
