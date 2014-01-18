package no.runsafe.framework.internal.text;

import org.bukkit.ChatColor;

import java.util.regex.Pattern;

public final class ConsoleColour
{
	private ConsoleColour()
	{
	}

	public static String FromMinecraft(String input)
	{
		String message = input;
		message = BUKKIT_DARK_GREEN.matcher(message).replaceAll(DARK_GREEN);
		message = BUKKIT_DARK_BLUE.matcher(message).replaceAll(DARK_BLUE);
		message = BUKKIT_BLACK.matcher(message).replaceAll(BLACK);
		message = BUKKIT_DARK_AQUA.matcher(message).replaceAll(DARK_AQUA);
		message = BUKKIT_DARK_RED.matcher(message).replaceAll(DARK_RED);
		message = BUKKIT_DARK_PURPLE.matcher(message).replaceAll(DARK_PURPLE);
		message = BUKKIT_GOLD.matcher(message).replaceAll(GOLD);
		message = BUKKIT_GRAY.matcher(message).replaceAll(GRAY);
		message = BUKKIT_DARK_GRAY.matcher(message).replaceAll(DARK_GRAY);
		message = BUKKIT_BLUE.matcher(message).replaceAll(BLUE);
		message = BUKKIT_GREEN.matcher(message).replaceAll(GREEN);
		message = BUKKIT_AQUA.matcher(message).replaceAll(AQUA);
		message = BUKKIT_RED.matcher(message).replaceAll(RED);
		message = BUKKIT_LIGHT_PURPLE.matcher(message).replaceAll(LIGHT_PURPLE);
		message = BUKKIT_YELLOW.matcher(message).replaceAll(YELLOW);
		message = BUKKIT_WHITE.matcher(message).replaceAll(WHITE);
		message = BUKKIT_MAGIC.matcher(message).replaceAll(MAGIC);
		message = BUKKIT_BOLD.matcher(message).replaceAll(BOLD);
		message = BUKKIT_STRIKETHROUGH.matcher(message).replaceAll(STRIKETHROUGH);
		message = BUKKIT_UNDERLINE.matcher(message).replaceAll(UNDERLINE);
		message = BUKKIT_ITALIC.matcher(message).replaceAll(ITALIC);
		message = BUKKIT_RESET.matcher(message).replaceAll(RESET);
		return message + RESET;
	}

	private static final Pattern BUKKIT_DARK_GREEN = Pattern.compile(ChatColor.DARK_GREEN.toString());
	private static final Pattern BUKKIT_DARK_BLUE = Pattern.compile(ChatColor.DARK_BLUE.toString());
	private static final Pattern BUKKIT_BLACK = Pattern.compile(ChatColor.BLACK.toString());
	private static final Pattern BUKKIT_DARK_AQUA = Pattern.compile(ChatColor.DARK_AQUA.toString());
	private static final Pattern BUKKIT_DARK_RED = Pattern.compile(ChatColor.DARK_RED.toString());
	private static final Pattern BUKKIT_DARK_PURPLE = Pattern.compile(ChatColor.DARK_PURPLE.toString());
	private static final Pattern BUKKIT_GOLD = Pattern.compile(ChatColor.GOLD.toString());
	private static final Pattern BUKKIT_GRAY = Pattern.compile(ChatColor.GRAY.toString());
	private static final Pattern BUKKIT_DARK_GRAY = Pattern.compile(ChatColor.DARK_GRAY.toString());
	private static final Pattern BUKKIT_BLUE = Pattern.compile(ChatColor.BLUE.toString());
	private static final Pattern BUKKIT_GREEN = Pattern.compile(ChatColor.GREEN.toString());
	private static final Pattern BUKKIT_AQUA = Pattern.compile(ChatColor.AQUA.toString());
	private static final Pattern BUKKIT_RED = Pattern.compile(ChatColor.RED.toString());
	private static final Pattern BUKKIT_LIGHT_PURPLE = Pattern.compile(ChatColor.LIGHT_PURPLE.toString());
	private static final Pattern BUKKIT_YELLOW = Pattern.compile(ChatColor.YELLOW.toString());
	private static final Pattern BUKKIT_WHITE = Pattern.compile(ChatColor.WHITE.toString());
	private static final Pattern BUKKIT_MAGIC = Pattern.compile(ChatColor.MAGIC.toString());
	private static final Pattern BUKKIT_BOLD = Pattern.compile(ChatColor.BOLD.toString());
	private static final Pattern BUKKIT_STRIKETHROUGH = Pattern.compile(ChatColor.STRIKETHROUGH.toString());
	private static final Pattern BUKKIT_UNDERLINE = Pattern.compile(ChatColor.UNDERLINE.toString());
	private static final Pattern BUKKIT_ITALIC = Pattern.compile(ChatColor.ITALIC.toString());
	private static final Pattern BUKKIT_RESET = Pattern.compile(ChatColor.RESET.toString());
	public static final String DARK_GREEN = ANSIRendition.Clear().faint().foreground(ANSIColour.Green).toString();
	public static final String DARK_BLUE = ANSIRendition.Clear().faint().foreground(ANSIColour.Blue).toString();
	public static final String BLACK = ANSIRendition.Clear().foreground(ANSIColour.Black).toString();
	public static final String DARK_AQUA = ANSIRendition.Clear().faint().foreground(ANSIColour.Cyan).toString();
	public static final String DARK_RED = ANSIRendition.Clear().faint().foreground(ANSIColour.Red).toString();
	public static final String DARK_PURPLE = ANSIRendition.Clear().faint().foreground(ANSIColour.Magenta).toString();
	public static final String GOLD = ANSIRendition.Clear().faint().foreground(ANSIColour.Yellow).toString();
	public static final String GRAY = ANSIRendition.Clear().foreground(ANSIColour.White).toString();
	public static final String DARK_GRAY = ANSIRendition.Clear().faint().foreground(ANSIColour.White).faint().toString();
	public static final String BLUE = ANSIRendition.Clear().foreground(ANSIColour.Blue).bright().toString();
	public static final String GREEN = ANSIRendition.Clear().foreground(ANSIColour.Green).bright().toString();
	public static final String AQUA = ANSIRendition.Clear().foreground(ANSIColour.Cyan).bright().toString();
	public static final String RED = ANSIRendition.Clear().foreground(ANSIColour.Red).bright().toString();
	public static final String LIGHT_PURPLE = ANSIRendition.Clear().foreground(ANSIColour.Magenta).bright().toString();
	public static final String YELLOW = ANSIRendition.Clear().foreground(ANSIColour.Yellow).bright().toString();
	public static final String WHITE = ANSIRendition.Clear().bright().foreground(ANSIColour.White).toString();
	public static final String MAGIC = ANSIRendition.Clear().foreground(ANSIColour.Black).background(ANSIColour.White).bright().reverse().toString();
	public static final String BOLD = ANSIRendition.Clear().bright().toString();
	public static final String STRIKETHROUGH = ANSIRendition.Clear().crossedOut().toString();
	public static final String UNDERLINE = ANSIRendition.Clear().underline().toString();
	public static final String ITALIC = ANSIRendition.Clear().italic().toString();
	public static final String RESET = ANSIRendition.Clear().toString();
}
