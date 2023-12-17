package no.runsafe.framework.internal.text;

public final class ANSIRendition
{
	public static ANSIRendition Modify()
	{
		return new ANSIRendition();
	}

	public static ANSIRendition Clear()
	{
		return new ANSIRendition().reset();
	}

	public ANSIRendition reset()
	{
		reset = true;
		return this;
	}

	public ANSIRendition bright()
	{
		bright = true;
		faint = false;
		return this;
	}

	public ANSIRendition faint()
	{
		faint = true;
		bright = false;
		return this;
	}

	public ANSIRendition italic()
	{
		italic = true;
		return this;
	}

	public ANSIRendition underline()
	{
		underline = true;
		return this;
	}

	public ANSIRendition reverse()
	{
		reverse = true;
		return this;
	}

	public ANSIRendition crossedOut()
	{
		crossed = true;
		return this;
	}

	public ANSIRendition foreground(ANSIColour colour)
	{
		foreground = colour.foreground();
		return this;
	}

	public ANSIRendition background(ANSIColour colour)
	{
		background = colour.background();
		return this;
	}

	@Override
	public String toString()
	{
		StringBuilder code = new StringBuilder("\033[");
		if (reset)
			code.append(format(RESET));
		if (bright)
			code.append(format(BRIGHT));
		if (faint)
			code.append(format(FAINT));
		if (italic)
			code.append(format(ITALIC));
		if (underline)
			code.append(format(UNDERLINE));
		if (reverse)
			code.append(format(REVERSE));
		if (crossed)
			code.append(format(CROSSED_OUT));
		if (foreground >= 0)
			code.append(format(foreground));
		if (background >= 0)
			code.append(format(background));
		code.append('m');
		return code.toString();
	}

	private String format(int code)
	{
		if (appended)
			return String.format(";%d", code);
		appended = true;
		return String.format("%d", code);
	}

	private static final int RESET = 0;
	private static final int BRIGHT = 1;
	private static final int FAINT = 2;
	private static final int ITALIC = 3;
	private static final int UNDERLINE = 4;
	private static final int REVERSE = 7;
	private static final int CROSSED_OUT = 9;

	private boolean reset;
	private boolean bright;
	private boolean faint;
	private boolean italic;
	private boolean underline;
	private boolean reverse;
	private boolean crossed;
	private int foreground = -1;
	private int background = -1;
	private boolean appended;
}
