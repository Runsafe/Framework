package no.runsafe.framework.internal.log;

import org.picocontainer.Startable;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

// This class will hook into the root logger and send logs to a new file.
public final class Root extends LoggingBase implements Startable
{
	public Root(LogFileHandler handler) throws IOException
	{
		super(handler.getLogger("root.log"), handler.getFormat("Root"));
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public void start()
	{
		log.log(Level.INFO, "Redirecting root logger..");
		Logger parent = log.getParent();
		// Remove default handlers
		for(Handler handler : parent.getHandlers())
			parent.removeHandler(handler);

		// Shift the output handler from the "Root" log up to the parent logger.
		for(Handler handler : log.getHandlers())
		{
			parent.addHandler(handler);
			log.removeHandler(handler);
		}
	}

	@Override
	public void stop()
	{
	}
}
