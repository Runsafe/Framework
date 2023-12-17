package no.runsafe.framework.tools;

import net.minecraft.server.v1_12_R1.*;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;

import java.io.*;
import java.math.BigInteger;

public class EntityCompacter
{
	public static String convertEntityToString(ILivingEntity livingEntity)
	{
		EntityLiving entity = (EntityLiving) ObjectUnwrapper.getMinecraft(livingEntity);
		NBTTagCompound compound = new NBTTagCompound();
		entity.b(compound);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutput = new DataOutputStream(outputStream);

		CompactUtil.writeTag(dataOutput, compound);
		return new BigInteger(1, outputStream.toByteArray()).toString(32);
	}

	public static void spawnEntityFromString(Class<?> entityClass, ILocation location, String data)
	{
		byte[] bytes = new BigInteger(data, 32).toByteArray();

		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bis);

		NBTTagCompound compound = (NBTTagCompound) CompactUtil.readTag(dis);
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
}
