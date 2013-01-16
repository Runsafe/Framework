package no.runsafe.framework.database;

@Deprecated
public interface ISchemaUpdater {
	void Run(SchemaRevisionRepository repository, IDatabase db);
}
