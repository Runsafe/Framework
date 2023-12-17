package no.runsafe.framework.internal.wrapper.metadata;

import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.internal.wrapper.IWrapper;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class BukkitMetadata implements IMetadata, IWrapper<Metadatable>
{
	public BukkitMetadata(Metadatable toWrap)
	{
		meta = toWrap;
	}

	@Override
	public List<MetadataValue> getMetadata(String key)
	{
		return meta.getMetadata(key);
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
	public void setMetadata(String key, MetadataValue value)
	{
		meta.setMetadata(key, value);
	}

	@Override
	public Metadatable getRaw()
	{
		return meta;
	}

	private final Metadatable meta;
}
