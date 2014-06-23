package no.runsafe.framework.api;

import net.minecraft.server.v1_7_R3.NBTTagCompound;

public interface ITagObject
{
	NBTTagCompound getTagCompound();
	Object cloneWithNewCompound(NBTTagCompound compound);
}
