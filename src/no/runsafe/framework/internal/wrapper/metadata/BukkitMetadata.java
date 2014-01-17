package no.runsafe.framework.internal.wrapper.metadata;

import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.internal.wrapper.IWrapper;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class BukkitMetadata implements IMetadata, IWrapper<Metadatable>
{
	public BukkitMetadata(Metadatable toWrap)
	{
		meta = toWrap;
	}

	public void setMetadata(String s, BukkitMetadataValue metadataValue)
	{
		meta.setMetadata(s, metadataValue.getRaw());
	}

	public List<BukkitMetadataValue> getMetadata(String s)
	{
		return BukkitMetadataValue.convert(meta.getMetadata(s));
	}

	@Override
	public boolean hasMetadata(String s)
	{
		return meta.hasMetadata(s);
	}

	public void removeMetadata(String s, Plugin plugin)
	{
		meta.removeMetadata(s, plugin);
	}

	@Override
	public Metadatable getRaw()
	{
		return meta;
	}

	private final Metadatable meta;
}
