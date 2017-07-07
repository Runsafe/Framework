package no.runsafe.framework.api;

import net.minecraft.server.v1_8_R3.NBTTagCompound;

public interface ITagObject
{
	boolean hasTagKey(String key);
	String getTagCompoundValue(String key);
	void setTagCompound(String key, String value);
	NBTTagCompound getTagCompound();
	Object cloneWithNewCompound(NBTTagCompound compound);
}
