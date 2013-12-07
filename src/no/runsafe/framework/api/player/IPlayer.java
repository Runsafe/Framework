package no.runsafe.framework.api.player;

import no.runsafe.framework.api.minecraft.IAnimalTamer;

public interface IPlayer extends
	IServerOperator, IAnimalTamer, IPlayerGameplay, IPlayerInventory, IPlayerKinematics,
	IPlayerPermissions, IPlayerControl, IPlayerVisibility, IPlayerUniverse, IPlayerNotification
{
	String getPrettyName();
	void setPlayerListName(String playerName);
}
