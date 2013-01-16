package no.runsafe.framework.server;

import org.bukkit.Color;

import java.util.Map;

public class Serialization
{
	public static Map<String, Object> fixObjects(Map<String, Object> data)
	{
		for (String key : data.keySet())
			if (data.get(key) instanceof Color)
				data.put(key, new SerializableColor(((Color) data.get(key)).asRGB()));

		return data;
	}

	public static Map<String, Object> unFixObjects(Map<String, Object> data)
	{
		for (String key : data.keySet())
			if (data.get(key) instanceof SerializableColor)
				data.put(key, ((SerializableColor) data.get(key)).get());

		return data;
	}

}
