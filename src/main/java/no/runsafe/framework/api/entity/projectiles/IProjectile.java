package no.runsafe.framework.api.entity.projectiles;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.entity.IProjectileSource;
import no.runsafe.framework.api.player.IPlayer;

public interface IProjectile extends IEntity
{
	IBlock getImpaledBlock();

	IPlayer getShootingPlayer();

	ILivingEntity getShootingEntity();

	IProjectileSource getShooter();

	void setShooter(ILivingEntity livingEntity);

	boolean getBounce();

	void setBounce(boolean bounce);

	boolean isOnGround();
}
