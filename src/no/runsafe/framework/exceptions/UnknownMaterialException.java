package no.runsafe.framework.exceptions;

public class UnknownMaterialException extends RuntimeException
{
	public UnknownMaterialException(int id)
	{
		this.id = id;
	}

	@Override
	public String getMessage()
	{
		return "The supplied material ID " + id + " is not a known material type!";
	}

	private final int id;
}
