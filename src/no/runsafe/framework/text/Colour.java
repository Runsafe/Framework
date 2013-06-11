package no.runsafe.framework.text;

public enum Colour
{
	Black(0),
	Red(1),
	Green(2),
	Yellow(3),
	Blue(4),
	Magenta(5),
	Cyan(6),
	White(7);

	private Colour(int code)
	{
		this.code = code;
	}

	public int Foreground()
	{
		return code + 30;
	}

	public int Background()
	{
		return code + 40;
	}

	private final int code;
}
