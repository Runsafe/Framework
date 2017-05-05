package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.AnimationType;

public class PacketAnimation extends RunsafePacket
{
	public PacketAnimation(IEntity selectedEntity, AnimationType animation)
	{
		setPacket(new PacketPlayOutAnimation(ObjectUnwrapper.getMinecraft(selectedEntity), animation.getValue()));
	}
}
