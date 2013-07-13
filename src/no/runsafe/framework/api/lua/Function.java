package no.runsafe.framework.api.lua;

import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

public abstract class Function extends VarArgFunction
{
	@Override
	public abstract Varargs invoke(Varargs args);

	protected FunctionParameters VarargsToParameters(Varargs args)
	{
		FunctionParameters parameters = new FunctionParameters();
		int currentIndex = 1;
		while (!args.isnoneornil(currentIndex))
		{
			parameters.addParameter(args.checkvalue(currentIndex));
			currentIndex += 1;
		}
		return parameters;
	}
}
