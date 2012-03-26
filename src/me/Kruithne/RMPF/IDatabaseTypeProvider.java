package me.Kruithne.RMPF;

public interface IDatabaseTypeProvider {
	@SuppressWarnings("rawtypes")
	public Class[] getModelClasses();
}
