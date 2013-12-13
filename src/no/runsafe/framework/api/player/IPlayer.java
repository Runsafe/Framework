package no.runsafe.framework.api.player;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.minecraft.IAnimalTamer;

public interface IPlayer extends
	ILivingEntity, IServerOperator, IAnimalTamer, IPlayerGameplay, IPlayerInventory, IPlayerKinematics,
	IPlayerPermissions, IPlayerControl, IPlayerVisibility, IPlayerUniverse, IPlayerNotification, ICommandExecutor,
	IPlayerNetwork
{
	String getPrettyName();
	void setPlayerListName(String playerName);
	String getPlayerListName();
}
