package no.runsafe.framework.api.filesystem;

import java.io.File;
import java.util.List;

public interface IPluginDataFile
{
	List<String> getLines();
	File getRawFile();
}
