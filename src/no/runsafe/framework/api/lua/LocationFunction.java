package no.runsafe.framework.api.lua;

import no.runsafe.framework.minecraft.RunsafeLocation;
import org.luaj.vm2.Varargs;

import java.util.ArrayList;
import java.util.List;

public abstract class LocationFunction extends Function
{
	@Override
	public Varargs invoke(Varargs args)
	{
		RunsafeLocation location = run(VarargsToParameters(args));

		List<Object> values = new ArrayList<Object>(4);
		values.add(location.getWorld().getName());
		values.add(location.getX());
		values.add(location.getY());
		values.add(location.getZ());
		return objectListToVarargs(values);
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public abstract RunsafeLocation run(FunctionParameters parameters);
}
