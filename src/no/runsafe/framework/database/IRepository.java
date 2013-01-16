package no.runsafe.framework.database;

import no.runsafe.framework.database.RunsafeEntity;

@Deprecated
public interface IRepository<T extends RunsafeEntity, KT> 
{
	public T get(KT id);
	
	public void persist(T object);

	public void delete(T object);
}
