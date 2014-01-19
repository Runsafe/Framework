package no.runsafe.framework.api.item.data;

public interface IFlowerPotData extends IItemData
{
	IItemData getContents();
	void setContents(IItemData data);
}
