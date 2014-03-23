package no.runsafe.framework.tools;

import net.minecraft.server.v1_7_R1.EntityLiving;
import net.minecraft.server.v1_7_R1.ItemStack;
import net.minecraft.server.v1_7_R1.NBTTagCompound;
import net.minecraft.server.v1_7_R1.World;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;

public class ItemCompacter
{
	public static String convertToString(RunsafeMeta item)
	{
		ItemStack itemStack = (ItemStack) ObjectUnwrapper.getMinecraft(item);
		NBTTagCompound compound = new NBTTagCompound();
		itemStack.save(compound);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutput = new DataOutputStream(outputStream);

		CompactUtil.writeTag(dataOutput, compound);
		return new BigInteger(1, outputStream.toByteArray()).toString(32);
	}
}
