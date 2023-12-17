package no.runsafe.framework.api.entity;

public interface IAgeable
{
	boolean canBreed();
	int getAge();
	boolean getAgeLock();
	boolean isAdult();
	void setAdult();
	void setAge(int age);
	void setAgeLock(boolean lock);
	void setBaby();
	void setBreed(boolean breed);
}
