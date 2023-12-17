package no.runsafe.framework.api.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

public abstract class StringFunction extends Function
{
	@Override
	public Varargs invoke(Varargs args)
	{
		return varargsOf(new LuaValue[]{valueOf(run(varargsToParameters(args)))});
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public abstract String run(FunctionParameters parameters);
}
