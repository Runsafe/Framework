package no.runsafe.framework;

public interface IRepository<T extends RunsafeEntity, KT> 
{
	public T get(KT id);
	
	public void persist(T object);
}
