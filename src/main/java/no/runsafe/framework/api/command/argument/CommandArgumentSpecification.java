package no.runsafe.framework.api.command.argument;

import javax.annotation.Nonnull;

public abstract class CommandArgumentSpecification<T> implements IArgument, IValueProvider<T>
{
	protected CommandArgumentSpecification(String name)
	{
		this.name = name;
	}

	@Override
	public int length()
	{
		return name.length();
	}

	@Override
	public char charAt(int index)
	{
		return name.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end)
	{
		return name.subSequence(start, end);
	}

	@Nonnull
	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public boolean isRequired()
	{
		return required;
	}

	public CommandArgumentSpecification<T> withDefault(T value)
	{
		defaultValue = value;
		return this;
	}

	public CommandArgumentSpecification<T> require()
	{
		required = true;
		return this;
	}

	protected T defaultValue;
	protected boolean required = false;
	protected final String name;
}
