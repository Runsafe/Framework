package no.runsafe.framework.tools;

import net.minecraft.server.v1_7_R1.*;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;

public class EntityCompacter
{
	public static String convertEntityToString(EntityLiving entity)
	{
		NBTTagCompound compound = new NBTTagCompound();
		entity.b(compound);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutput = new DataOutputStream(outputStream);

		writeTag(dataOutput, compound);
		return new BigInteger(1, outputStream.toByteArray()).toString(32);
	}

	public static void spawnEntityFromString(Class<?> entityClass, ILocation location, String data)
	{
		byte[] bytes = new BigInteger(data, 32).toByteArray();

		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bis);

		NBTTagCompound compound = (NBTTagCompound) readTag(dis);
		World world = ObjectUnwrapper.getMinecraft(location.getWorld());
		if (world == null)
			return;

		try
		{
			EntityLiving entity = (EntityLiving) entityClass.getConstructor(World.class).newInstance(world);
			entity.a(compound);
			entity.setPosition(location.getX(), location.getY(), location.getZ());
			world.addEntity(entity);
		}
		catch (Exception e)
		{
			// Welp!
		}
	}

	private static void writeTag(DataOutput output, NBTBase tag)
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
