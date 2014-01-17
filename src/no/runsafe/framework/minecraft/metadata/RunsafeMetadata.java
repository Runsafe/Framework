package no.runsafe.framework.minecraft.metadata;

import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.metadata.IMetadataValue;
import no.runsafe.framework.internal.wrapper.IWrapper;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class RunsafeMetadata implements IMetadata, IWrapper<Metadatable>
{
	public RunsafeMetadata(Metadatable toWrap)
	{
		meta = toWrap;
	}

	@Override
	public List<IMetadataValue> getMetadata(String key)
	{
		return ObjectWrapper.convert(meta.getMetadata(key));
	}

	@Override
	public boolean hasMetadata(String key)
	{
		return meta.hasMetadata(key);
	}

	@Override
	public void removeMetadata(String key, Plugin plugin)
	{
		meta.removeMetadata(key, plugin);
	}

	@Override
	public void setMetadata(String key, IMetadataValue value)
	{
		meta.setMetadata(key, (MetadataValue) ObjectUnwrapper.convert(value));
	}

	@Override
	public Metadatable getRaw()
	{
		return meta;
	}

	private final Metadatable meta;
}
