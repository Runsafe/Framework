package no.runsafe.framework.minecraft.metadata;

import no.runsafe.framework.api.metadata.IMetadataValue;
import no.runsafe.framework.internal.wrapper.IWrapper;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class RunsafeMetadataValue implements IMetadataValue, IWrapper<MetadataValue>
{
	public RunsafeMetadataValue(MetadataValue toWrap)
	{
		value = toWrap;
	}

	@Override
	public boolean asBoolean()
	{
		return value.asBoolean();
	}

	@Override
	public byte asByte()
	{
		return value.asByte();
	}

	@Override
	public double asDouble()
	{
		return value.asDouble();
	}

	@Override
	public float asFloat()
	{
		return value.asFloat();
	}

	@Override
	public int asInt()
	{
		return value.asInt();
	}

	@Override
	public long asLong()
	{
		return value.asLong();
	}

	@Override
	public short asShort()
	{
		return value.asShort();
	}

	@Override
	public String asString()
	{
		return value.asString();
	}

	@Override
	public Plugin getOwningPlugin()
	{
		return value.getOwningPlugin();
	}

	@Override
	public void invalidate()
	{
		value.invalidate();
	}

	@Override
	public Object value()
	{
		return value.value();
	}

	@Override
	public MetadataValue getRaw()
	{
		return value;
	}

	private final MetadataValue value;
}
