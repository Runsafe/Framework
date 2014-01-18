package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public interface ILivingEntity extends IDamageable
{
	List<Buff> getActivePotionEffects();
	boolean getCanPickupItems();
	String getCustomName();
	RunsafeEntityEquipment getEquipment(); // ToDo: Framework.
	double getEyeHeight();
	double getEyeHeight(boolean ignoreSneaking);
	ILocation getEyeLocation();
	IPlayer getKiller();
	double getLastDamage();
	IEntity getLeashHolder();
	int getMaximumAir();
	int getMaximumNoDamageTicks();
	int getNoDamageTicks();
	int getRemainingAir();
	boolean getRemoveWhenFarAway();
	boolean hasLineOfSight(IEntity target);
	boolean hasPotionEffect(Buff type);
	boolean isCustomNameVisible();
	boolean isLeashed();
	@Nullable IEntity launchProjectile(ProjectileEntity launchEntity); // ToDo: IProjectile here.
	void addBuff(Buff buff);
	void removeBuff(Buff buff);
	void setCanPickupItems(boolean pickup);
	void setCustomName(String name);
	void setCustomNameVisible(boolean visible);
	void setLastDamage(double damage);
	boolean setLeashHolder(IEntity holder);
	void setMaximumAir(int ticks);
	void setMaximumNoDamageTicks(int ticks);
	void setNoDamageTicks(int ticks);
	void setRemainingAir(int ticks);
	void setRemoveWhenFarAway(boolean remove);

	// Runsafe
	void removeAllBuffs();
	IEntity launchEntity(RunsafeEntityType launchEntity);

	// Old stuff.
	//IBlock getTargetBlock();
	//RunsafeEntity Fire(ProjectileEntity projectileType);
	//List<IBlock> getLineOfSight(HashSet<Byte> transparent, int maxDistance);
	//IBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance);
	//List<IBlock> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance);
}
