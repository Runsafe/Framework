package no.runsafe.framework.internal.vector;

import no.runsafe.framework.api.vector.IPoint3D;
import no.runsafe.framework.api.vector.IRegion3D;

public class Region3D implements IRegion3D
{
	public Region3D(IPoint3D p1, IPoint3D p2)
	{
		xMin = Math.min(p1.getX(), p2.getX());
		xMax = Math.max(p1.getX(), p2.getX());
		yMin = Math.min(p1.getY(), p2.getY());
		yMax = Math.max(p1.getY(), p2.getY());
		zMin = Math.min(p1.getZ(), p2.getZ());
		zMax = Math.max(p1.getZ(), p2.getZ());
	}

	@Override
	public boolean contains(IPoint3D point)
	{
		return between(xMin, point.getX(), xMax) && between(yMin, point.getY(), yMax) && between(zMin, point.getZ(), zMax);
	}

	@Override
	public IPoint3D getMinimum()
	{
		return new Point3D(xMin, yMin, zMin);
	}

	@Override
	public IPoint3D getMaximum()
	{
		return new Point3D(xMax, yMax, zMax);
	}

	private static boolean between(double min, double value, double max)
	{
		return min <= value && value <= max;
	}

	private final double xMin;
	private final double xMax;
	private final double yMin;
	private final double yMax;
	private final double zMin;
	private final double zMax;
}
