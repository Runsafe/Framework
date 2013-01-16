package no.runsafe.framework.server;

import org.bukkit.Color;

public class SerializableColor implements java.io.Serializable
{
	public SerializableColor(int rgb)
	{
		this.rgb = rgb;
	}

	public Color get()
	{
		return Color.fromRGB(rgb);
	}

	private int rgb;
}
