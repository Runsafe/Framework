package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.internal.vector.Point3D;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public abstract class BukkitArmourStand extends RunsafeLivingEntity
{
	public BukkitArmourStand(ArmorStand toWrap)
	{
		super(toWrap);
		stand = toWrap;
	}

	/**
	 * Gets item armour stand is holding.
	 * @return Item held.
	 */
	RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(stand.getItemInHand());
	}

	/**
	 * Makes the armour stand hold an item.
	 * @param item Thing to be held.
	 */
	void setItemInHand(RunsafeMeta itemStack)
	{
		stand.setItemInHand(itemStack.getRaw());
	}

	/**
	 * Gets item in boots slot.
	 * @return boots
	 */
	public RunsafeMeta getBoots()
	{
		return ObjectWrapper.convert(stand.getBoots());
	}

	/**
	 * Give this armour stand boots.
	 * @param item boots
	 */
	public void setBoots(RunsafeMeta itemStack)
	{
		stand.setBoots(itemStack.getRaw());
	}

	/**
	 * Gets item in pants slot.
	 * @return pants
	 */
	public RunsafeMeta getLeggings()
	{
		return ObjectWrapper.convert(stand.getLeggings());
	}

	/**
	 * Give this armour stand pants.
	 * @param item pants
	 */
	public void setLeggings(RunsafeMeta itemStack)
	{
		stand.setLeggings(itemStack.getRaw());
	}

	/**
	 * Gets item in chestplate slot.
	 * @return Chestplate.
	 */
	public RunsafeMeta getChestplate()
	{
		return ObjectWrapper.convert(stand.getChestplate());
	}

	/**
	 * Set a chestplate.
	 * @param item Chestplate
	 */
	public void setChestplate(RunsafeMeta itemStack)
	{
		stand.setChestplate(itemStack.getRaw());
	}

	/**
	 * Get item in the helmet slot.
	 * May or may not be a helmet.
	 * @return item in helmet slot
	 */
	public RunsafeMeta getHelmet()
	{
		return ObjectWrapper.convert(stand.getHelmet());
	}

	/**
	 * Set helmet slot.
	 * Can be a block or item, not limited to normal helmets.
	 * @param item Hat
	 */
	public void setHelmet(RunsafeMeta itemStack)
	{
		stand.setHelmet(itemStack.getRaw());
	}

	/**
	 * Check if armour stand has a base plate.
	 * @return True if it has a base plate.
	 */
	public boolean hasBasePlate()
	{
		return stand.hasBasePlate();
	}

	/**
	 * Set whether or not armour stand has a base plate.
	 * @param basePlate True for base plate.
	 */
	public void setBasePlate(boolean basePlateValue)
	{
		stand.setBasePlate(basePlateValue);
	}

	/**
	 * Check if it's influenced by gravity.
	 * @return True if likes gravity.
	 */
	public boolean hasGravity()
	{
		return stand.hasGravity();
	}

	/**
	 * Choose whether or not this object will obey the laws of gravity.
	 * @param gravityValue True for gravity, false to just float there.
	 */
	public void setGravity(boolean gravityValue)
	{
		stand.setGravity(gravityValue);
	}

	/**
	 * Check if this object is visible or not.
	 * @return True if visible, false if invisible.
	 */
	public boolean isVisible()
	{
		return stand.isVisible();
	}

	/**
	 * Sets whether or not this object can be seen.
	 * Any blocks/armour on this armour stand can still be seen.
	 * @param visibleValue True if visible.
	 */
	public void setVisible(boolean visibleValue)
	{
		stand.setVisible(visibleValue);
	}

	/**
	 * Check if armour stand has arms.
	 * @return True if it has arms.
	 */
	public boolean hasArms()
	{
		return stand.hasArms();
	}

	/**
	 * Decide whether or not to give the armour stand arms.
	 * @param armsValue True for arms
	 */
	public void setArms(boolean armsValue)
	{
		stand.setArms(armsValue);
	}

	/**
	 * Checks if armour stand is small or not.
	 * @return True if small.
	 */
	public boolean isSmall()
	{
		return stand.isSmall();
	}

	/**
	 * Makes armour stand big or small.
	 * @param smallValue
	 */
	public void setSmall(boolean smallValue)
	{
		stand.setSmall(smallValue);
	}

	/**
	 * Gets whether or not this armour stand is a marker.
	 * Marker armour stands don't render client side.
	 * NOT the same as being invisible.
	 * @return True if it's a marker, false if not.
	 */
	public boolean isMarker()
	{
		return stand.isMarker();
	}

	/**
	 * Sets whether or not the armour stand is a marker.
	 * @param markerValue
	 */
	public void setMarker(boolean markerValue)
	{
		stand.setMarker(markerValue);
	}

	/**
	 * Gets body pose.
	 * @return Body part position.
	 */
	Point3D getBodyPose()
	{
		EulerAngle poseAngle = stand.getBodyPose();
		return new Point3D(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ());
	}

	/**
	 * Sets body pose.
	 * @param poseAngle Body part position.
	 */
	void setBodyPose(Point3D poseAngle)
	{
		stand.setBodyPose(new EulerAngle(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ()));
	}

	/**
	 * Gets left arm pose.
	 * @return Body part position.
	 */
	Point3D getLeftArmPose()
	{
		EulerAngle poseAngle = stand.getLeftArmPose();
		return new Point3D(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ());
	}

	/**
	 * Sets left arm position.
	 * @param poseAngle Body part position.
	 */
	void setLeftArmPose(Point3D poseAngle)
	{
		stand.setLeftArmPose(new EulerAngle(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ()));
	}

	/**
	 * Gets right arm pose.
	 * @return Body part position.
	 */
	Point3D getRightArmPose()
	{
		EulerAngle poseAngle = stand.getRightArmPose();
		return new Point3D(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ());
	}

	/**
	 * Sets right arm position.
	 * @param poseAngle Body part position.
	 */
	void setRightArmPose(Point3D poseAngle)
	{
		stand.setRightArmPose(new EulerAngle(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ()));
	}

	/**
	 * Gets left leg pose.
	 * @return Body part position.
	 */
	Point3D getLeftLegPose()
	{
		EulerAngle poseAngle = stand.getLeftLegPose();
		return new Point3D(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ());
	}

	/**
	 * Sets left leg position.
	 * @param poseAngle Body part position.
	 */
	void setLeftLegPose(Point3D poseAngle)
	{
		stand.setLeftLegPose(new EulerAngle(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ()));
	}

	/**
	 * Gets right leg pose.
	 * @return Body part position.
	 */
	Point3D getRightLegPose()
	{
		EulerAngle poseAngle = stand.getRightLegPose();
		return new Point3D(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ());
	}

	/**
	 * Sets right leg position.
	 * @param poseAngle Body part position.
	 */
	void setRightLegPose(Point3D poseAngle)
	{
		stand.setRightLegPose(new EulerAngle(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ()));
	}

	/**
	 * Gets head pose.
	 * @return Body part position.
	 */
	Point3D getHeadPose()
	{
		EulerAngle poseAngle = stand.getHeadPose();
		return new Point3D(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ());
	}

	/**
	 * Sets head position.
	 * @param poseAngle Body part position.
	 */
	void setHeadPose(Point3D poseAngle)
	{
		stand.setHeadPose(new EulerAngle(poseAngle.getX(), poseAngle.getY(), poseAngle.getZ()));
	}

	@Override
	public ArmorStand getRaw()
	{
		return stand;
	}

	protected final ArmorStand stand;
}
