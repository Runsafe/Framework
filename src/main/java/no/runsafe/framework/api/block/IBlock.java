package no.runsafe.framework.api.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.minecraft.Item;

@SuppressWarnings("InstanceMethodNamingConvention")
public interface IBlock extends IMetadata
{
	void set(Item type);
	IWorld getWorld();
	ILocation getLocation();
	Item getMaterial();
	void setMaterial(Item material);
	void breakNaturally();
	boolean is(Item type);
	boolean isAny(Item... type);
	boolean hasInterface();
	boolean isInteractBlock();
	boolean canPassThrough();
	boolean isHazardous();
	boolean isAir();
	boolean isWater();
	boolean isLava();
	boolean isAbleToFall();
	byte getData();
	void setData(byte data);
	int getRedstonePower();
}
