package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.item.meta.RunsafeFirework;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class FireworkBuilder
{
	public static final int HEXADECIMAL = 16;

	public FireworkBuilder Random()
	{
		return Random(rng.nextInt(4));
	}

	public FireworkBuilder Random(int effects)
	{
		power = rng.nextInt(3);
		FireworkEffect.Type[] types = FireworkEffect.Type.values();
		for (int i = 0; i <= effects; ++i)
		{
			if (i > 0)
			{
				this.effects.add(builder.build());
				builder = FireworkEffect.builder();
			}
			builder
				.trail(rng.nextBoolean())
				.flicker(rng.nextBoolean())
				.with(types[rng.nextInt(types.length - 1)])
				.withColor(Color.fromRGB(rng.nextInt(Byte.MAX_VALUE), rng.nextInt(Byte.MAX_VALUE), rng.nextInt(Byte.MAX_VALUE)))
				.withColor(Color.fromRGB(rng.nextInt(Byte.MAX_VALUE), rng.nextInt(Byte.MAX_VALUE), rng.nextInt(Byte.MAX_VALUE)));
		}
		return this;
	}

	public FireworkBuilder Effect(Firework.EffectType effect)
	{
		builder = builder.with(effect.getType());
		return this;
	}

	public FireworkBuilder Ball()
	{
		builder = builder.with(FireworkEffect.Type.BALL);
		return this;
	}

	public FireworkBuilder LargeBall()
	{
		builder = builder.with(FireworkEffect.Type.BALL_LARGE);
		return this;
	}

	public FireworkBuilder Star()
	{
		builder = builder.with(FireworkEffect.Type.STAR);
		return this;
	}

	public FireworkBuilder Burst()
	{
		builder = builder.with(FireworkEffect.Type.BURST);
		return this;
	}

	public FireworkBuilder Creeper()
	{
		builder = builder.with(FireworkEffect.Type.CREEPER);
		return this;
	}

	public FireworkBuilder Trail()
	{
		return Trail(true);
	}

	public FireworkBuilder Trail(boolean trail)
	{
		builder = builder.trail(trail);
		return this;
	}

	public FireworkBuilder Flicker()
	{
		return Flicker(true);
	}

	public FireworkBuilder Flicker(boolean flicker)
	{
		builder = builder.flicker(flicker);
		return this;
	}

	public FireworkBuilder Colour(String rgb)
	{
		builder = builder.withColor(Color.fromRGB(Integer.parseInt(rgb, HEXADECIMAL)));
		return this;
	}

	public FireworkBuilder Colour(byte red, byte green, byte blue)
	{
		builder = builder.withColor(Color.fromRGB(red, green, blue));
		return this;
	}

	public FireworkBuilder Fade(String rgb)
	{
		builder = builder.withFade(Color.fromRGB(Integer.parseInt(rgb, HEXADECIMAL)));
		return this;
	}

	public FireworkBuilder Fade(byte red, byte green, byte blue)
	{
		builder = builder.withFade(Color.fromRGB(red, green, blue));
		return this;
	}

	public FireworkBuilder And()
	{
		effects.add(builder.build());
		builder = FireworkEffect.builder();
		return this;
	}

	public FireworkBuilder Power(int power)
	{
		this.power = power;
		return this;
	}

	public RunsafeMeta Create()
	{
		RunsafeFirework item = (RunsafeFirework) Item.Special.Crafted.Firework.getItem();
		item.setPower(power);
		((FireworkMeta) item.getRaw().getItemMeta()).addEffect(builder.build());
		return item;
	}

	public void Fire(ILocation location)
	{
		IEntity fireworkEntity = ProjectileEntity.Firework.spawn(location);
		org.bukkit.entity.Firework firework = ObjectUnwrapper.convert(fireworkEntity);

		firework.getFireworkMeta().setPower(power);
		if (!effects.isEmpty())
			firework.getFireworkMeta().addEffects(effects);
		firework.getFireworkMeta().addEffect(builder.build());
	}

	public void Give(IPlayer player)
	{
		player.give(Create());
	}

	FireworkBuilder()
	{
		builder = FireworkEffect.builder();
	}

	private FireworkEffect.Builder builder;
	private final Collection<FireworkEffect> effects = new ArrayList<FireworkEffect>(0);
	private int power;

	private static final Random rng = new Random();
}
