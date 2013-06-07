package no.runsafe.framework.wrapper.metadata;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class RunsafeMetadataValue
{
	public RunsafeMetadataValue(MetadataValue toWrap)
	{
		dataValue = toWrap;
	}

	public Object value()
	{
		return dataValue.value();
	}

	public int asInt()
	{
		return dataValue.asInt();
	}

	public float asFloat()
	{
		return dataValue.asFloat();
	}

	public double asDouble()
	{
		return dataValue.asDouble();
	}

	public long asLong()
	{
		return dataValue.asLong();
	}

	public short asShort()
	{
		return dataValue.asShort();
	}

	public byte asByte()
	{
		return dataValue.asByte();
	}

	public boolean asBoolean()
	{
		return dataValue.asBoolean();
	}

	public String asString()
	{
		return dataValue.asString();
	}

	public Plugin getOwningPlugin()
	{
		return dataValue.getOwningPlugin();
	}

	public void invalidate()
	{
		dataValue.invalidate();
	}

	public MetadataValue getRaw()
	{
		return dataValue;
	}

	private final MetadataValue dataValue;

	public static List<RunsafeMetadataValue> convert(List<MetadataValue> metadata)
	{
		if(metadata == null)
			return null;

		ArrayList<RunsafeMetadataValue> data = new ArrayList<RunsafeMetadataValue>();
		for(MetadataValue value : metadata)
			data.add(new RunsafeMetadataValue(value));
		return data;
	}
}
