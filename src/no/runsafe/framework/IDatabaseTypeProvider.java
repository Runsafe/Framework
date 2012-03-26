package no.runsafe.framework;

public interface IDatabaseTypeProvider {
	@SuppressWarnings("rawtypes")
	public Class[] getModelClasses();
}
