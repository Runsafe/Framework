package no.runsafe.framework.api.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

public abstract class VoidFunction extends Function
{
	@Override
	public Varargs invoke(Varargs args)
	{
		run(varargsToParameters(args));
		return varargsOf(new LuaValue[0]);
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	protected abstract void run(FunctionParameters parameters);
}
