package no.runsafe.framework.api.ai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface IChatResponseTrigger
{
	String getResponse(String player, Matcher message);
	Pattern getRule();
}
