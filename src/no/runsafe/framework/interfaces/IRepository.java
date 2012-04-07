package no.runsafe.framework.interfaces;

import no.runsafe.framework.database.RunsafeEntity;

public interface IRepository<T extends RunsafeEntity, KT> 
{
	public T get(KT id);
	
	public void persist(T object);
}
