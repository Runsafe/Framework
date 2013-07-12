package no.runsafe.framework.api.ai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface IChatResponseTrigger
{
	public String getResponse(String player, Matcher message);
	public Pattern getRule();
}
