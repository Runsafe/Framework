package no.runsafe.framework.api.command.argument;

public class EntityTypeArgument extends EntityType
{
	protected EntityTypeArgument(String name)
	{
		super(name);
	}

	public EntityTypeArgument(boolean required)
	{
		super(required);
	}

	public EntityTypeArgument(String name, boolean required)
	{
		super(name, required);
	}
}
