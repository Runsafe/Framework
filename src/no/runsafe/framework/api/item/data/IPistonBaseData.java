package no.runsafe.framework.api.item.data;

public interface IPistonBaseData extends IItemData, IDirectional, IRedstone
{
	boolean isSticky();
	void setPowered(boolean powered);
}
