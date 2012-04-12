package no.runsafe.framework.database;

public interface IDatabaseTypeProvider {
	@SuppressWarnings("rawtypes")
	public Class[] getModelClasses();
}
