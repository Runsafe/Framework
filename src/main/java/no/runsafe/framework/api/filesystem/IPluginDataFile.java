package no.runsafe.framework.api.filesystem;

import java.io.File;
import java.util.List;

public interface IPluginDataFile
{
	List<String> getLines();
	void writeLines(List<String> lines);
	File getRawFile();
}
