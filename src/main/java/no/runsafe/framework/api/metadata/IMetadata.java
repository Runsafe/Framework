package no.runsafe.framework.api.metadata;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public interface IMetadata
{
	List<MetadataValue> getMetadata(String key);
	boolean hasMetadata(String key);
	void removeMetadata(String key, Plugin plugin);
	void setMetadata(String key, MetadataValue value);
}