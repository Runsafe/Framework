package no.runsafe.framework.api.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

public abstract class IntegerFunction extends Function
{
	@Override
	public Varargs invoke(Varargs args)
	{
		return varargsOf(new LuaValue[]{valueOf(run(varargsToParameters(args)))});
	}

	public abstract Integer run(FunctionParameters parameters);
}
