package no.runsafe.framework.text;

import no.runsafe.framework.internal.text.ConsoleColour;
import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MethodNamesDifferingOnlyByCase")
public enum ChatColour
{
	BLACK('0', ChatColor.BLACK, ConsoleColour.BLACK),
	DARK_BLUE('1', ChatColor.DARK_BLUE, ConsoleColour.DARK_BLUE),
	DARK_GREEN('2', ChatColor.DARK_GREEN, ConsoleColour.DARK_GREEN),
	DARK_AQUA('3', ChatColor.DARK_AQUA, ConsoleColour.DARK_AQUA),
	DARK_RED('4', ChatColor.DARK_RED, ConsoleColour.DARK_RED),
	DARK_PURPLE('5', ChatColor.DARK_PURPLE, ConsoleColour.DARK_PURPLE),
	GOLD('6', ChatColor.GOLD, ConsoleColour.GOLD),
	GRAY('7', ChatColor.GRAY, ConsoleColour.GRAY),
	DARK_GRAY('8', ChatColor.DARK_GRAY, ConsoleColour.DARK_GRAY),
	BLUE('9', ChatColor.BLUE, ConsoleColour.BLUE),
	GREEN('a', ChatColor.GREEN, ConsoleColour.GREEN),
	AQUA('b', ChatColor.AQUA, ConsoleColour.AQUA),
	RED('c', ChatColor.RED, ConsoleColour.RED),
	LIGHT_PURPLE('d', ChatColor.LIGHT_PURPLE, ConsoleColour.LIGHT_PURPLE),
	YELLOW('e', ChatColor.YELLOW, ConsoleColour.YELLOW),
	WHITE('f', ChatColor.WHITE, ConsoleColour.WHITE),
	MAGIC('k', ChatColor.MAGIC, ConsoleColour.MAGIC),
	BOLD('l', ChatColor.BOLD, ConsoleColour.BOLD),
	STRIKETHROUGH('m', ChatColor.STRIKETHROUGH, ConsoleColour.STRIKETHROUGH),
	UNDERLINE('n', ChatColor.UNDERLINE, ConsoleColour.UNDERLINE),
	ITALIC('o', ChatColor.ITALIC, ConsoleColour.ITALIC),
	RESET('r', ChatColor.RESET, ConsoleColour.RESET);

	ChatColour(char colourCode, ChatColor bukkitColour, String ansiCode)
	{
		code = String.format("&%s", colourCode);
		bukkitCode = bukkitColour.toString();
		consoleCode = ansiCode;
	}

	@Override
	public String toString()
	{
		return code;
	}

	@SuppressWarnings("HardcodedFileSeparator")
	public Pattern toPattern()
	{
		return Pattern.compile("(?<!\\\\)" + code);
	}

	public String toConsole()
	{
		return consoleCode;
	}

	public String toBukkit()
	{
		return bukkitCode;
	}

	@SuppressWarnings("HardcodedFileSeparator")
	public static String Escape(String message)
	{
		return CODE_ANY.matcher(message).replaceAll("\\\\$1");
	}

	public static String ToMinecraft(String input)
	{
		String message = input;
		message = CODE_DARK_GREEN.matcher(message).replaceAll(DARK_GREEN.toBukkit());
		message = CODE_DARK_BLUE.matcher(message).replaceAll(DARK_BLUE.toBukkit());
		message = CODE_BLACK.matcher(message).replaceAll(BLACK.toBukkit());
		message = CODE_DARK_AQUA.matcher(message).replaceAll(DARK_AQUA.toBukkit());
		message = CODE_DARK_RED.matcher(message).replaceAll(DARK_RED.toBukkit());
		message = CODE_DARK_PURPLE.matcher(message).replaceAll(DARK_PURPLE.toBukkit());
		message = CODE_GOLD.matcher(message).replaceAll(GOLD.toBukkit());
		message = CODE_GRAY.matcher(message).replaceAll(GRAY.toBukkit());
		message = CODE_DARK_GRAY.matcher(message).replaceAll(DARK_GRAY.toBukkit());
		message = CODE_BLUE.matcher(message).replaceAll(BLUE.toBukkit());
		message = CODE_GREEN.matcher(message).replaceAll(GREEN.toBukkit());
		message = CODE_AQUA.matcher(message).replaceAll(AQUA.toBukkit());
		message = CODE_RED.matcher(message).replaceAll(RED.toBukkit());
		message = CODE_LIGHT_PURPLE.matcher(message).replaceAll(LIGHT_PURPLE.toBukkit());
		message = CODE_YELLOW.matcher(message).replaceAll(YELLOW.toBukkit());
		message = CODE_WHITE.matcher(message).replaceAll(WHITE.toBukkit());
		message = CODE_MAGIC.matcher(message).replaceAll(MAGIC.toBukkit());
		message = CODE_BOLD.matcher(message).replaceAll(BOLD.toBukkit());
		message = CODE_STRIKETHROUGH.matcher(message).replaceAll(STRIKETHROUGH.toBukkit());
		message = CODE_UNDERLINE.matcher(message).replaceAll(UNDERLINE.toBukkit());
		message = CODE_ITALIC.matcher(message).replaceAll(ITALIC.toBukkit());
		message = CODE_RESET.matcher(message).replaceAll(RESET.toBukkit());
		message = CODE_ESCAPED.matcher(message).replaceAll("$1");
		return message;
	}

	public static String ToConsole(String message)
	{
		message = CODE_DARK_GREEN.matcher(message).replaceAll(DARK_GREEN.toConsole());
		message = CODE_DARK_BLUE.matcher(message).replaceAll(DARK_BLUE.toConsole());
		message = CODE_BLACK.matcher(message).replaceAll(BLACK.toConsole());
		message = CODE_DARK_AQUA.matcher(message).replaceAll(DARK_AQUA.toConsole());
		message = CODE_DARK_RED.matcher(message).replaceAll(DARK_RED.toConsole());
		message = CODE_DARK_PURPLE.matcher(message).replaceAll(DARK_PURPLE.toConsole());
		message = CODE_GOLD.matcher(message).replaceAll(GOLD.toConsole());
		message = CODE_GRAY.matcher(message).replaceAll(GRAY.toConsole());
		message = CODE_DARK_GRAY.matcher(message).replaceAll(DARK_GRAY.toConsole());
		message = CODE_BLUE.matcher(message).replaceAll(BLUE.toConsole());
		message = CODE_GREEN.matcher(message).replaceAll(GREEN.toConsole());
		message = CODE_AQUA.matcher(message).replaceAll(AQUA.toConsole());
		message = CODE_RED.matcher(message).replaceAll(RED.toConsole());
		message = CODE_LIGHT_PURPLE.matcher(message).replaceAll(LIGHT_PURPLE.toConsole());
		message = CODE_YELLOW.matcher(message).replaceAll(YELLOW.toConsole());
		message = CODE_WHITE.matcher(message).replaceAll(WHITE.toConsole());
		message = CODE_MAGIC.matcher(message).replaceAll(MAGIC.toConsole());
		message = CODE_BOLD.matcher(message).replaceAll(BOLD.toConsole());
		message = CODE_STRIKETHROUGH.matcher(message).replaceAll(STRIKETHROUGH.toConsole());
		message = CODE_UNDERLINE.matcher(message).replaceAll(UNDERLINE.toConsole());
		message = CODE_ITALIC.matcher(message).replaceAll(ITALIC.toConsole());
		message = CODE_RESET.matcher(message).replaceAll(RESET.toConsole());
		message = CODE_ESCAPED.matcher(message).replaceAll("$1");
		return message + RESET.toConsole();
	}

	public static String Strip(String message)
	{
		while (true)
		{
			Matcher matcher = CODE_ANY.matcher(message);
			if (!matcher.find())
				break;
			message = matcher.replaceAll("");
		}
		return message;
	}

	private final String code;
	private final String bukkitCode;
	private final String consoleCode;

	private static final Pattern CODE_ESCAPED = Pattern.compile("\\\\(&[0-9a-fk-or])");
	private static final Pattern CODE_ANY = Pattern.compile("(?<!\\\\)(&[0-9a-fk-or])");
	private static final Pattern CODE_BLACK = BLACK.toPattern();
	private static final Pattern CODE_DARK_GREEN = DARK_GREEN.toPattern();
	private static final Pattern CODE_DARK_BLUE = DARK_BLUE.toPattern();
	private static final Pattern CODE_DARK_AQUA = DARK_AQUA.toPattern();
	private static final Pattern CODE_DARK_RED = DARK_RED.toPattern();
	private static final Pattern CODE_DARK_PURPLE = DARK_PURPLE.toPattern();
	private static final Pattern CODE_GOLD = GOLD.toPattern();
	private static final Pattern CODE_GRAY = GRAY.toPattern();
	private static final Pattern CODE_DARK_GRAY = DARK_GRAY.toPattern();
	private static final Pattern CODE_BLUE = BLUE.toPattern();
	private static final Pattern CODE_GREEN = GREEN.toPattern();
	private static final Pattern CODE_AQUA = AQUA.toPattern();
	private static final Pattern CODE_RED = RED.toPattern();
	private static final Pattern CODE_LIGHT_PURPLE = LIGHT_PURPLE.toPattern();
	private static final Pattern CODE_YELLOW = YELLOW.toPattern();
	private static final Pattern CODE_WHITE = WHITE.toPattern();
	private static final Pattern CODE_MAGIC = MAGIC.toPattern();
	private static final Pattern CODE_BOLD = BOLD.toPattern();
	private static final Pattern CODE_STRIKETHROUGH = STRIKETHROUGH.toPattern();
	private static final Pattern CODE_UNDERLINE = UNDERLINE.toPattern();
	private static final Pattern CODE_ITALIC = ITALIC.toPattern();
	private static final Pattern CODE_RESET = RESET.toPattern();
}
