package no.runsafe.framework.minecraft;

import org.bukkit.FireworkEffect;

public class Firework
{
	public enum EffectType
	{
		Ball(FireworkEffect.Type.BALL),
		LargeBall(FireworkEffect.Type.BALL_LARGE),
		Burst(FireworkEffect.Type.BURST),
		Creeper(FireworkEffect.Type.CREEPER),
		Star(FireworkEffect.Type.STAR);

		EffectType(FireworkEffect.Type type)
		{
			this.type = type;
		}

		public FireworkEffect.Type getType()
		{
			return type;
		}

		private final FireworkEffect.Type type;
	}

	public static FireworkBuilder Random()
	{
		return new FireworkBuilder().Random();
	}

	public static FireworkBuilder Random(int effects)
	{
		return new FireworkBuilder().Random(effects);
	}

	public static FireworkBuilder Effect(EffectType effect)
	{
		return new FireworkBuilder().Effect(effect);
	}

	public static FireworkBuilder Ball()
	{
		return new FireworkBuilder().Ball();
	}

	public static FireworkBuilder LargeBall()
	{
		return new FireworkBuilder().LargeBall();
	}

	public static FireworkBuilder Star()
	{
		return new FireworkBuilder().Star();
	}

	public static FireworkBuilder Burst()
	{
		return new FireworkBuilder().Burst();
	}

	public static FireworkBuilder Creeper()
	{
		return new FireworkBuilder().Creeper();
	}

	public static FireworkBuilder Trail()
	{
		return new FireworkBuilder().Trail();
	}

	public static FireworkBuilder Trail(boolean trail)
	{
		return new FireworkBuilder().Trail(trail);
	}

	public static FireworkBuilder Flicker()
	{
		return new FireworkBuilder().Flicker();
	}

	public static FireworkBuilder Flicker(boolean flicker)
	{
		return new FireworkBuilder().Flicker(flicker);
	}

	public static FireworkBuilder Colour(String rgb)
	{
		return new FireworkBuilder().Colour(rgb);
	}

	public static FireworkBuilder Colour(byte r, byte g, byte b)
	{
		return new FireworkBuilder().Colour(r, g, b);
	}

	public static FireworkBuilder Fade(String rgb)
	{
		return new FireworkBuilder().Fade(rgb);
	}

	public static FireworkBuilder Fade(byte r, byte g, byte b)
	{
		return new FireworkBuilder().Fade(r, g, b);
	}
}
