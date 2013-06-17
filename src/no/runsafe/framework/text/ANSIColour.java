package no.runsafe.framework.text;

public enum ANSIColour
{
	Black(0),
	Red(1),
	Green(2),
	Yellow(3),
	Blue(4),
	Magenta(5),
	Cyan(6),
	White(7);

	private ANSIColour(int code)
	{
		this.code = code;
	}

	public int foreground()
	{
		return code + 30;
	}

	public int background()
	{
		return code + 40;
	}

	private final int code;
}
