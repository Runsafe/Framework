package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.PacketPlayOutAnimation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.AnimationType;

public class PacketAnimation extends RunsafePacket
{
	public PacketAnimation(IEntity selectedEntity, AnimationType animation)
	{
		Entity entity = ObjectUnwrapper.getMinecraft(selectedEntity);
		if (entity == null)
			return;
		setPacket(new PacketPlayOutAnimation(entity, animation.getValue()));
	}
}
