package no.runsafe.framework.minecraft;

/**
 * Used in no.runsafe.framework.minecraft.networking.PacketAnimation
 * for the different animation types.
 */
public enum AnimationType
{
	/*
	 * Swings the main arm.
	 * Before 1.8, it's the right arm.
	 * In 1.9+, it's whichever arm is set to be the main arm.
	 */
	MAIN_ARM_SWING(0),

	/*
	 * Turns entities red.
	 * Gives camera view a shake when used on a player.
	 * Do not spam this animation at a player, may cause headaces.
	 */
	DAMAGE(1),

	/*
	 * Appears to do nothing in 1.8.
	 */
	BED_EXIT(2),

	/**
	 * Swings the offhand.
	 */
	OFFHAND_ARM_SWING(3),

	/*
	 * Plays a critical hit animation.
	 * Uses brown X shaped particles.
	 */
	NORMAL_CRITICAL(4),

	/*
	 * Plays a magical criticle hit animation.
	 * Uses cyan diamond shaped particles.
	 */
	MAGICAL_CRITICAL(5);

	public int getValue()
	{
		return value;
	}

	AnimationType(int newArgumentName)
	{
		this.value = newArgumentName;
	}

	private final int value;
}
