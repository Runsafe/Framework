package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;

import java.util.HashSet;
import java.util.List;

public interface ILivingEntity extends IEntity
{
	IBlock getTarget();

	RunsafeEntity Fire(ProjectileEntity projectileType);

	RunsafeEntity Launch(RunsafeEntityType entityType);

	void removeBuffs();

	double getHealth();

	void setHealth(double health);

	RunsafeEntityEquipment getEquipment();

	double getMaxHealth();

	double getEyeHeight();

	double getEyeHeight(boolean b);

	RunsafeLocation getEyeLocation();

	List<IBlock> getLineOfSight(HashSet<Byte> transparent, int maxDistance);

	IBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance);

	List<IBlock> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance);

	int getRemainingAir();

	void setRemainingAir(int i);

	int getMaximumAir();

	void setMaximumAir(int i);

	void damage(double damage);

	void damage(double damage, RunsafeEntity source);

	int getMaximumNoDamageTicks();

	void setMaximumNoDamageTicks(int i);

	double getLastDamage();

	void setLastDamage(double damage);

	int getNoDamageTicks();

	void setNoDamageTicks(int i);

	IPlayer getKiller();

	void addBuff(Buff buff);

	void removeBuff(Buff buff);
}
