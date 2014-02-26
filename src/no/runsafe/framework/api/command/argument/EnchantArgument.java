package no.runsafe.framework.api.command.argument;

@Deprecated
public class EnchantArgument extends Enchant
{
	protected EnchantArgument(String name)
	{
		super(name);
	}

	public EnchantArgument(boolean required)
	{
		super(required);
	}

	public EnchantArgument(String name, boolean required)
	{
		super(name, required);
	}
}
