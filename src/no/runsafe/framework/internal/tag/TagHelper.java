package no.runsafe.framework.internal.tag;

import net.minecraft.server.v1_7_R1.NBTTagCompound;
import no.runsafe.framework.internal.wrapper.IWrapper;

import java.lang.reflect.Field;

public final class TagHelper
{
	private TagHelper()
	{}

	public static NBTTagCompound getCompound(Object object)
	{
		if (object instanceof IWrapper)
			return getCompoundFromRunsafeWrapper((IWrapper<?>) object);

		if (object.getClass().getName().startsWith("Craft"))
			return getCompoundFromBukkitWrapper(object);

		return getCompoundFromNMS(object);
	}

	public static void setCompound(Object object, NBTTagCompound compound)
	{
		if (object instanceof IWrapper)
		{
			setNMSObjectCompound(getCompoundFromRunsafeWrapper((IWrapper<?>) object), compound);
			return;
		}

		if (object.getClass().getName().startsWith("Craft"))
		{
			setNMSObjectCompound(getCompoundFromBukkitWrapper(object), compound);
			return;
		}

		setNMSObjectCompound(object, compound);
	}

	private static NBTTagCompound getCompoundFromRunsafeWrapper(IWrapper<?> wrapper)
	{
		try
		{
			return getCompoundFromBukkitWrapper(wrapper.getClass().getMethod("getRaw").invoke(wrapper));
		}
		catch (Exception e)
		{
			return null;
		}
	}

	private static NBTTagCompound getCompoundFromBukkitWrapper(Object bukkitWrapper)
	{
		if (bukkitWrapper == null)
			return null;

		try
		{
			Field handleField = bukkitWrapper.getClass().getDeclaredField("handle");
			handleField.setAccessible(true);
			return getCompoundFromNMS(handleField.get(bukkitWrapper));
		}
		catch (Exception e)
		{
			return null;
		}
	}

	private static NBTTagCompound getCompoundFromNMS(Object rawObject)
	{
		if (rawObject == null)
			return null;

		try
		{
			Field tagField = rawObject.getClass().getDeclaredField("tag");
			tagField.setAccessible(true);
			Object tagObject = tagField.get(rawObject);

			if (tagObject instanceof NBTTagCompound)
				return (NBTTagCompound) tagObject;

			return null;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	private static void setNMSObjectCompound(Object nmsObject, NBTTagCompound compound)
	{
		if (nmsObject == null)
			return;

		try
		{
			Field tagField = nmsObject.getClass().getDeclaredField("tag");
			tagField.setAccessible(true);
			tagField.set(nmsObject, compound);
		}
		catch (Exception e)
		{
			// Ignore.
		}
	}
}
