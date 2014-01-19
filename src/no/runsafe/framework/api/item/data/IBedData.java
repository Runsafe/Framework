package no.runsafe.framework.api.item.data;

public interface IBedData extends IItemData, IDirectional
{
	boolean isHeadOfBed();
	void setHeadOfBed(boolean isHeadOfBed);
}
