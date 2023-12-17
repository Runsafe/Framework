package no.runsafe.framework.api.lua;

import org.luaj.vm2.Varargs;

import java.util.List;

public abstract class RunsafeLuaFunction extends Function
{
	@SuppressWarnings("LocalVariableOfConcreteClass")
	@Override
	public Varargs invoke(Varargs args)
	{
		FunctionParameters parameters = new FunctionParameters();
		int currentIndex = 1;
		while (!args.isnoneornil(currentIndex))
		{
			parameters.addParameter(args.checkvalue(currentIndex));
			currentIndex += 1;
		}
		return objectListToVarargs(run(parameters));
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public abstract List<Object> run(FunctionParameters parameters);
}
