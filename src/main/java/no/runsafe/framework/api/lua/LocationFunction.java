package no.runsafe.framework.api.lua;

import no.runsafe.framework.api.ILocation;
import org.luaj.vm2.Varargs;

import java.util.ArrayList;
import java.util.List;

public abstract class LocationFunction extends Function
{
	@Override
	public Varargs invoke(Varargs args)
	{
		ILocation location = run(varargsToParameters(args));

		List<Object> values = new ArrayList<Object>(6);
		values.add(location.getWorld().getName());
		values.add(location.getX());
		values.add(location.getY());
		values.add(location.getZ());
		values.add(location.getYaw());
		values.add(location.getPitch());
		return objectListToVarargs(values);
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public abstract ILocation run(FunctionParameters parameters);
}
