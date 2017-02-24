package no.runsafe.framework.tools;

import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.io.ByteArrayOutputStream;
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
