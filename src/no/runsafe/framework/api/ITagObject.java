package no.runsafe.framework.api;

import net.minecraft.server.v1_7_R1.NBTTagCompound;

public interface ITagObject
{
	NBTTagCompound getTagCompound();
	void setTagCompound(NBTTagCompound compound);
}
