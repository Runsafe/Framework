package no.runsafe.framework.text;

public class ANSIRendition
{
	public static ANSIRendition Modify()
	{
		return new ANSIRendition();
	}

	public static ANSIRendition Clear()
	{
		return new ANSIRendition().Reset();
	}

	public ANSIRendition Reset()
	{
		reset = true;
		return this;
	}

	public ANSIRendition Bright()
	{
		bright = true;
		faint = false;
		return this;
	}

	public ANSIRendition Faint()
	{
		faint = true;
		bright = false;
		return this;
	}

	public ANSIRendition Italic()
	{
		italic = true;
		return this;
	}

	public ANSIRendition Underline()
	{
		underline = true;
		return this;
	}

	public ANSIRendition Reverse()
	{
		reverse = true;
		return this;
	}

	public ANSIRendition CrossedOut()
	{
		crossed = true;
		return this;
	}

	public ANSIRendition Foreground(ANSIColour colour)
	{
		foreground = colour.Foreground();
		return this;
	}

	public ANSIRendition Background(ANSIColour colour)
	{
		background = colour.Background();
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
		code.append("m");
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
