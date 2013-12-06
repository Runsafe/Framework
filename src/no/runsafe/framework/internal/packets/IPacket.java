package no.runsafe.framework.internal.packets;

import java.util.HashMap;

public interface IPacket
{
	HashMap<String, Object> prepareData();
}