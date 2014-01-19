package no.runsafe.framework.api.item.data;

public interface IPistonExtensionData extends IItemData, IAttachable
{
	boolean isSticky();
	void setSticky(boolean sticky);
}
