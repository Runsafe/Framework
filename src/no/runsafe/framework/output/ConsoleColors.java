package no.runsafe.framework.output;

import org.bukkit.ChatColor;

import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This was taken from CommandHelper
// Original code: https://github.com/sk89q/commandhelper/blob/master/src/main/java/com/laytonsmith/PureUtilities/TermColors.java
public class ConsoleColors {
	public static String FromMinecraft(String message) {
		return message
				.replaceAll(ChatColor.RED.toString(), RED)
				.replaceAll(ChatColor.GREEN.toString(), GREEN)
				.replaceAll(ChatColor.BLUE.toString(), BLUE)
				.replaceAll(ChatColor.YELLOW.toString(), YELLOW)
				.replaceAll(ChatColor.AQUA.toString(), CYAN)
				.replaceAll(ChatColor.LIGHT_PURPLE.toString(), MAGENTA)
				.replaceAll(ChatColor.BLACK.toString(), BLACK)
				.replaceAll(ChatColor.WHITE.toString(), WHITE)
				+ reset;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	private @interface color {
	}

	/*
	 * Standard foreground colors
	 */
	@color
	public static final String RED = color(Color.RED);
	@color
	public static final String GREEN = color(Color.GREEN);
	@color
	public static final String BLUE = color(Color.BLUE);
	@color
	public static final String YELLOW = color(Color.YELLOW);
	@color
	public static final String CYAN = color(Color.CYAN);
	@color
	public static final String MAGENTA = color(Color.MAGENTA);
	@color
	public static final String BLACK = color(Color.BLACK);
	@color
	public static final String WHITE = color(Color.WHITE);

	public static final String reset = "\033[0m";

	public static String color(Color c) {
		return color(c, false, true);
	}

	private static String color(Color c, boolean bright, boolean foreground) {
		int color = 37;
		if(c.equals(Color.RED)) {
			color = 31;
		} else if(c.equals(Color.GREEN)) {
			color = 32;
		} else if(c.equals(Color.BLUE)) {
			color = 34;
		} else if(c.equals(Color.YELLOW)) {
			color = 33;
		} else if(c.equals(Color.CYAN)) {
			color = 36;
		} else if(c.equals(Color.MAGENTA)) {
			color = 35;
		} else if(c.equals(Color.BLACK)) {
			color = 30;
		} else if(c.equals(Color.WHITE)) {
			color = 37;
		}
		if(!foreground) {
			color += 10;
		}
		return "\033[" + (bright ? "1;" : "") + color + "m";
	}
}
