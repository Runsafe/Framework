package no.runsafe.framework.api.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.minecraft.IAnimalTamer;

public interface IPlayer extends
	ILivingEntity, IServerOperator, IAnimalTamer, IPlayerGameplay, IPlayerInventory, IPlayerKinematics,
	IPlayerPermissions, IPlayerControl, IPlayerVisibility, IPlayerUniverse, IPlayerNotification, ICommandExecutor,
	IPlayerNetwork
{
	String getPrettyName();
	void setPlayerListName(String name);
	String getPlayerListName();
	IEntity getLeftShoulderEntity();
	IEntity getRightShoulderEntity();
	void setLeftShoulderEntity(IEntity entity);
	void setRightShoulderEntity(IEntity entity);
	void setFacing(ILocation location);
}
