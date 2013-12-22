package no.runsafe.framework.internal.log;

import org.picocontainer.Startable;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

// This class will hook into the root logger and send logs to a new file.
public final class Root extends LoggingBase implements Startable
{
	public Root(FileManager handler) throws IOException
	{
		super(handler.getLogger("root.log"), handler.getFormat("Root"));
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public void start()
	{
		log.log(Level.INFO, "Redirecting root logger..");
		Logger parent = log.getParent();
		while(parent.getParent() != null)
			parent = parent.getParent();
		// Steal the parent loggers output..
		hookLogger(parent);
		// Steal the server loggers output..
		hookLogger(Logger.getLogger("Server thread"));
	}

	private void hookLogger(Logger logger)
	{
		for (Handler handler : log.getHandlers())
			log.removeHandler(handler);
		for (Handler handler : log.getHandlers())
			logger.addHandler(handler);
	}

	@Override
	public void stop()
	{
	}
}
