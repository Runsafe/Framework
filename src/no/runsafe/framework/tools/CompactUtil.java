package no.runsafe.framework.tools;

import net.minecraft.server.v1_12_R1.NBTBase;
import net.minecraft.server.v1_12_R1.NBTCompressedStreamTools;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.Method;

public class CompactUtil
{
	public static void writeTag(DataOutput output, NBTBase tag)
	{
		try
		{
			Method method = NBTCompressedStreamTools.class.getDeclaredMethod("a", NBTBase.class, DataOutput.class);
			method.setAccessible(true);
			method.invoke(null, tag, output);
		}
		catch (Exception e)
		{
			// Welp!
		}
	}

	public static NBTBase readTag(DataInput input)
	{
		try {
			Method method = NBTCompressedStreamTools.class.getDeclaredMethod("a", DataInput.class, int.class);
			method.setAccessible(true);

			return (NBTBase) method.invoke(null, input, 0);
		}
		catch (Exception e)
		{
			// Welp!
		}

		return null;
	}
}
