package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.command.argument.BasePlayerArgument;
import no.runsafe.framework.internal.extension.RunsafeServer;
import no.runsafe.framework.internal.extension.player.RunsafeAmbiguousPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public abstract class Player extends BasePlayerArgument
{
	public static class Any extends Player
	{
		@Deprecated
		public static class Required extends Any
		{
			public Required()
			{
				this("player", false);
			}

			public Required(String name)
			{
				this(name, false);
			}

			public Required(String name, boolean defaultSelf)
			{
				super(name, true, defaultSelf);
			}

			@Override
			public boolean isRequired()
			{
				return true;
			}
		}

		@Deprecated
		public static class Optional extends Any
		{
			public Optional()
			{
				this("player", false);
			}

			public Optional(String name)
			{
				this(name, false);
			}

			public Optional(String name, boolean defaultSelf)
			{
				super(name, false, defaultSelf);
			}

			@Override
			public boolean isRequired()
			{
				return false;
			}
		}

		protected Any(String name, boolean required, boolean context)
		{
			super(name, required, context);
		}

		@Nullable
		@Override
		public String expand(ICommandExecutor context, @Nullable String value)
		{
			if (value == null)
				return super.expand(context, null);

			Matcher quoted = Command.QUOTED_ARGUMENT.matcher(value);
			if (quoted.matches())
				return quoted.group(1);

			List<String> matches = RunsafeServer.findPlayer(value);
			if (matches.size() > 1)
			{
				context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
				if (!isRequired() && expand)
					return null;
			}
			if (matches.size() == 1)
				return matches.get(0);

			context.sendColouredMessage("Unable to locate any players matching '%s'!", value);
			return null;
		}

		@Override
		public IPlayer getValue(IPlayer context, Map<String, String> params)
		{
			String param = params.get(name);
			if (param == null || param.isEmpty())
				return defaultValue;
			return InjectionPlugin.getGlobalComponent(IServer.class).getPlayerExact(param);
		}
	}

	public static class Online extends Player
	{
		@Deprecated
		public static class Required extends Online
		{
			public Required()
			{
				this("player", false);
			}

			public Required(String name)
			{
				this(name, false);
			}

			public Required(String name, boolean defaultSelf)
			{
				super(name, true, defaultSelf);
			}

			@Override
			public boolean isRequired()
			{
				return true;
			}
		}

		@Deprecated
		public static class Optional extends Online
		{
			public Optional()
			{
				this("player", false);
			}

			public Optional(String name)
			{
				this(name, false);
			}

			public Optional(String name, boolean defaultSelf)
			{
				super(name, false, defaultSelf);
			}

			@Override
			public boolean isRequired()
			{
				return false;
			}
		}

		protected Online(String name, boolean required, boolean context)
		{
			super(name, required, context);
		}

		@Nullable
		@Override
		public String expand(ICommandExecutor context, @Nullable String value)
		{
			if (value == null)
				return super.expand(context, null);

			if (context instanceof IPlayer)
				return expandForPlayer((IPlayer) context, value);

			return expandForConsole(context, value);
		}

		@Nullable
		private String expandForConsole(ICommandExecutor context, @Nullable String value)
		{
			Matcher quoted = Command.QUOTED_ARGUMENT.matcher(value);
			if (quoted.matches())
			{
				IPlayer target = no.runsafe.framework.internal.Player.Get().getExact(quoted.group(1));
				if (target.isOnline())
					return target.getName();
				return null;
			}

			List<String> matches = no.runsafe.framework.internal.Player.Get().getOnline(value);
			if (matches.size() > 1)
			{
				context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
				if (!isRequired() && expand)
					return null;
			}
			if (matches != null && matches.size() == 1)
				return matches.get(0);

			context.sendColouredMessage("Unable to locate any players matching '%s'!", value);
			return null;
		}

		@Nullable
		private String expandForPlayer(IPlayer context, String value)
		{
			Matcher quoted = Command.QUOTED_ARGUMENT.matcher(value);
			if (quoted.matches())
			{
				IPlayer target = no.runsafe.framework.internal.Player.Get().getExact(quoted.group(1));
				if (context.shouldNotSee(target))
					return null;
				return quoted.group(1);
			}
			List<String> matches = no.runsafe.framework.internal.Player.Get().getOnline(context, value);
			if (matches.size() > 1)
			{
				context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
				if (!isRequired() && expand)
					return null;
			}
			if (matches != null && matches.size() == 1)
				return matches.get(0);

			context.sendColouredMessage("Unable to locate any players matching '%s'!", value);
			return null;
		}

		@Override
		public IPlayer getValue(IPlayer context, Map<String, String> params)
		{
			String param = params.get(name);
			if (param == null || param.isEmpty())
				return defaultValue;
			return InjectionPlugin.getGlobalComponent(IServer.class).getPlayerExact(param);
		}
	}

	protected Player(String name, boolean required, boolean context)
	{
		super(name, required, context);
	}
}
