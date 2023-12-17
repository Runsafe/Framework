package no.runsafe.framework.api.entity;

import net.minecraft.server.v1_12_R1.PathfinderGoal;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;
import org.bukkit.Material;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;

public interface ILivingEntity extends IDamageable, IProjectileSource
{
	IBlock getTargetBlock();
	RunsafeEntity Fire(ProjectileEntity projectileType);
	RunsafeEntity Launch(RunsafeEntityType entityType);
	void removeBuffs();
	RunsafeEntityEquipment getEquipment();
	double getEyeHeight();
	double getEyeHeight(boolean ignoreSneaking);
	ILocation getEyeLocation();
	List<IBlock> getBlocksInLineOfSight(HashSet<Material> transparent, int maxDistance);
	IBlock getTargetedBlock(HashSet<Material> transparent, int maxDistance);
	List<IBlock> getLastTwoTargetedBlocks(HashSet<Material> transparent, int maxDistance);
	int getRemainingAir();
	void setRemainingAir(int remainingAirTicks);
	int getMaximumAir();
	void setMaximumAir(int maximumAirTicks);
	int getMaximumNoDamageTicks();
	void setMaximumNoDamageTicks(int maximumNoDamageTicks);
	double getLastDamage();
	void setLastDamage(double damage);
	int getNoDamageTicks();
	void setNoDamageTicks(int noDamageTicks);
	IEntity getKiller();
	void addBuff(Buff buff);
	void removeBuff(Buff buff);
	IEntity getLeashHolder();
	void setLeashHolder(RunsafeEntity entity);
	boolean isLeashed();
	void setCustomName(String name);
	String getCustomName();
	@Nullable
	Sound getIdleSound();
	void stopPathfinding();
	void setNewPathfindingGoal(int goalNum, PathfinderGoal goal);
	void setNewPathfindingTarget(int priority, PathfinderGoal target);
	boolean getPersistance();
	void setPersistance(boolean persistance);
}
