package no.runsafe.framework.api.item.data;

public interface ITripwireData extends IItemData
{
	boolean isActivated();
	boolean isObjectTriggering();
	void setActivated(boolean activated);
	void setObjectTriggering(boolean triggering);
}
