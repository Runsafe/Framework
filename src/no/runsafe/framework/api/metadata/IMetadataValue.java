package no.runsafe.framework.api.metadata;

import org.bukkit.plugin.Plugin;

public interface IMetadataValue
{
	boolean asBoolean();
	byte asByte();
	double asDouble();
	float asFloat();
	int asInt();
	long asLong();
	short asShort();
	String asString();
	Plugin getOwningPlugin();
	void invalidate();
	Object value();
}
