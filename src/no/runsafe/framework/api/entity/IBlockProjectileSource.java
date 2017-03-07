package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IProjectileSource;

public interface IBlockProjectileSource extends IProjectileSource
{
    IBlock getBlock();
}
