package no.runsafe.framework.api.item.data;

public interface ICakeData extends IItemData
{
	int getSlicesEaten();
	int getSlicesRemaining();
	void setSlicesEaten(int slicesEaten);
	void setSlicesRemaining(int slicesRemaining);
}
