package no.runsafe.framework.internal.vector;

import no.runsafe.framework.api.vector.IPoint3D;

public class Point3D implements IPoint3D
{
	public Point3D(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point3D(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public double getX()
	{
		return x;
	}

	@Override
	public void setX(double x)
	{
		this.x = x;
	}

	@Override
	public double getY()
	{
		return y;
	}

	@Override
	public void setY(double y)
	{
		this.y = y;
	}

	@Override
	public double getZ()
	{
		return z;
	}

	@Override
	public void setZ(double z)
	{
		this.z = z;
	}

	private double x;
	private double y;
	private double z;
}
