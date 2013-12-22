package no.runsafe.framework.internal.log;

import no.runsafe.framework.minecraft.RunsafeServer;
import org.picocontainer.Startable;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

// This class will hook into the root logger and send logs to a new file.
public final class Root extends LoggingBase implements Startable
{
	public Root(FileManager handler, RunsafeServer server) throws IOException
	{
		super(server.getLogger(), handler.getFormat("Root"));
		redirect = handler.getLogger("root.log");
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public void start()
	{
		redirect.log(Level.INFO, "Redirecting root logger..");
		Enumeration<String> logs = LogManager.getLogManager().getLoggerNames();
		while (logs.hasMoreElements())
			redirect.log(Level.INFO, " Found log " + logs.nextElement());
		// Steal the server loggers output..
		for (Handler handler : log.getHandlers())
			log.removeHandler(handler);
		for (Handler handler : redirect.getHandlers())
			log.addHandler(handler);
	}

	@Override
	public void stop()
	{
	}

	private final Logger redirect;
}
