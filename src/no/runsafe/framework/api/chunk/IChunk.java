package no.runsafe.framework.api.chunk;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;

import javax.annotation.Nonnull;
import java.util.List;

public interface IChunk
{
	int getX();
	int getZ();
	@Nonnull
	IWorld getWorld();
	@Nonnull
	IBlock getBlock(int i, int i1, int i2);
	@Nonnull
	List<RunsafeEntity> getEntities();
	boolean isUnloaded();
	boolean load();
}
