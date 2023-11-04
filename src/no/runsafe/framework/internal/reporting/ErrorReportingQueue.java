package no.runsafe.framework.internal.reporting;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.timer.Worker;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.plugin.Plugin;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ErrorReportingQueue extends Worker<String, Throwable>
{
	public ErrorReportingQueue(Plugin plugin, IScheduler scheduler) throws NoSuchAlgorithmException
	{
		super(scheduler);
		this.plugin = plugin;
		hasher = MessageDigest.getInstance("SHA-256");
	}

	public void submit(Throwable throwable)
	{
		String hash = DatatypeConverter.printBase64Binary(hasher.digest(ExceptionUtils.getFullStackTrace(throwable).getBytes()));
		if (!reported.containsKey(hash))
			Push(hash, throwable);
	}

	@Override
	public void process(String key, Throwable value)
	{
		String report = createReport(key, value);

		// This is where we would talk to some external system and submit the report...
		reported.put(key, new Object()); // Store some state object related to external system (ID)
	}

	private String createReport(String key, Throwable value)
	{
		return String.format(
			"De-duplication key: {%s}\nException details from plugin %s:\n%s",
			key,
			plugin.getName(),
			ExceptionUtils.getFullStackTrace(value)
		);
	}

	private final ConcurrentMap<String, Object> reported = new ConcurrentHashMap<String, Object>();
	private final MessageDigest hasher;
	private final Plugin plugin;
}
