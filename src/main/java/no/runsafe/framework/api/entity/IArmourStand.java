package no.runsafe.framework.api.entity;

import no.runsafe.framework.internal.vector.Point3D;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public interface IArmourStand extends ILivingEntity
{
	RunsafeMeta getItemInHand();
	void setItemInHand(RunsafeMeta itemStack);
	RunsafeMeta getBoots();
	void setBoots(RunsafeMeta itemStack);
	RunsafeMeta getLeggings();
	void setLeggings(RunsafeMeta itemStack);
	RunsafeMeta getChestplate();
	void setChestplate(RunsafeMeta itemStack);
	RunsafeMeta getHelmet();
	void setHelmet(RunsafeMeta itemStack);
	boolean hasBasePlate();
	void setBasePlate(boolean basePlateValue);
	boolean hasGravity();
	void setGravity(boolean gravityValue);
	boolean isVisible();
	void setVisible(boolean visibleValue);
	boolean hasArms();
	void setArms(boolean armsValue);
	boolean isSmall();
	void setSmall(boolean smallValue);
	boolean isMarker();
	void setMarker(boolean markerValue);
	Point3D getBodyPose();
	void setBodyPose(Point3D poseAngle);
	Point3D getLeftArmPose();
	void setLeftArmPose(Point3D poseAngle);
	Point3D getRightArmPose();
	void setRightArmPose(Point3D poseAngle);
	Point3D getLeftLegPose();
	void setLeftLegPose(Point3D poseAngle);
	Point3D getRightLegPose();
	void setRightLegPose(Point3D poseAngle);
	Point3D getHeadPose();
	void setHeadPose(Point3D poseAngle);
}