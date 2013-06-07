package no.runsafe.framework.wrapper.metadata;

import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class RunsafeMetadata
{
	public RunsafeMetadata(Metadatable toWrap)
	{
		meta = toWrap;
	}

	public void setMetadata(String s, RunsafeMetadataValue metadataValue)
	{
		meta.setMetadata(s, metadataValue.getRaw());
	}

	public List<RunsafeMetadataValue> getMetadata(String s)
	{
		return RunsafeMetadataValue.convert(meta.getMetadata(s));
	}

	public boolean hasMetadata(String s)
	{
		return meta.hasMetadata(s);
	}

	public void removeMetadata(String s, Plugin plugin)
	{
		meta.removeMetadata(s, plugin);
	}

	private final Metadatable meta;
}
