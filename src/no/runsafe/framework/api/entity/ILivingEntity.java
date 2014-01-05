package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;

import java.util.HashSet;
import java.util.List;

public interface ILivingEntity extends IEntity
{
	RunsafeEntity Fire(ProjectileEntity projectileType);

	RunsafeEntity Launch(RunsafeEntityType entityType);

	void removeBuffs();

	double getHealth();

	void setHealth(double health);

	RunsafeEntityEquipment getEquipment();

	double getMaxHealth();

	double getEyeHeight();

	double getEyeHeight(boolean b);

	ILocation getEyeLocation();

	List<IBlock> getLineOfSight(HashSet<Byte> transparent, int maxDistance);

	IBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance);

	List<IBlock> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance);

	int getRemainingAir();

	void setRemainingAir(int i);

	int getMaximumAir();

	void setMaximumAir(int i);

	void damage(double damage);

	void damage(double damage, IEntity source);

	int getMaximumNoDamageTicks();

	void setMaximumNoDamageTicks(int i);

	double getLastDamage();

	void setLastDamage(double damage);

	int getNoDamageTicks();

	void setNoDamageTicks(int i);

	IEntity getKiller();

	void addBuff(Buff buff);

	void removeBuff(Buff buff);
}
