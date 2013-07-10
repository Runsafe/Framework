package no.runsafe.framework.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

import java.util.ArrayList;
import java.util.List;

public class RunsafeLuaFunction extends VarArgFunction
{
	public Varargs invoke(Varargs args)
	{
		FunctionParameters parameters = new FunctionParameters();
		int currentIndex = 1;
		while (!args.isnoneornil(currentIndex))
		{
			parameters.addParameter(args.checkvalue(currentIndex));
			currentIndex += 1;
		}
		return this.objectListToVarargs(this.run(parameters));
	}

	private Varargs objectListToVarargs(List<Object> objects)
	{
		List<LuaValue> values = new ArrayList<LuaValue>();

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
			}
		}
		return varargsOf(values.toArray(new LuaValue[values.size()]));
	}

	public List<Object> run(FunctionParameters parameters)
	{
		return null;
	}
}
