package no.runsafe.framework.internal.text;

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

	ANSIColour(int colourCode)
	{
		code = colourCode;
	}

	public int foreground()
	{
		return code + FOREGROUND_BLACK;
	}

	public int background()
	{
		return code + BACKGROUND_BLACK;
	}

	private final int code;
	private static final int FOREGROUND_BLACK = 30;
	private static final int BACKGROUND_BLACK = 40;
}
