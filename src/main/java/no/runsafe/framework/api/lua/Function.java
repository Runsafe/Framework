package no.runsafe.framework.api.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

import java.util.ArrayList;
import java.util.List;

public abstract class Function extends VarArgFunction
{
	@SuppressWarnings("AbstractMethodOverridesConcreteMethod")
	@Override
	public abstract Varargs invoke(Varargs args);

	@SuppressWarnings("LocalVariableOfConcreteClass")
	protected FunctionParameters varargsToParameters(Varargs args)
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

	@SuppressWarnings("ChainOfInstanceofChecks")
	protected Varargs objectListToVarargs(Iterable<Object> objects)
	{
		List<LuaValue> values = new ArrayList<LuaValue>(0);

		if (objects != null)
		{
			for (Object object : objects)
			{
				if (object instanceof Boolean)
					values.add(valueOf((Boolean) object));

				if (object instanceof String)
					values.add(valueOf((String) object));

				if (object instanceof Double)
					values.add(valueOf((Double) object));

				if (object instanceof Integer)
					values.add(valueOf((Integer) object));

				if (object instanceof Float)
					values.add(valueOf((Float) object));
			}
		}
		return varargsOf(values.toArray(new LuaValue[values.size()]));
	}
}
