package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.ILocation;

import java.util.HashMap;
import java.util.Map;

public class Sound
{
	public static Sound Get(String name)
	{
		org.bukkit.Sound raw = org.bukkit.Sound.valueOf(name);
		if (soundboard.containsKey(raw.name()))
			return soundboard.get(raw.name());
		return new Sound(raw);
	}

	@SuppressWarnings("StaticVariableOfConcreteClass")
	public static final class Ambiance
	{
		public static final Sound Cave = new Sound(org.bukkit.Sound.AMBIENCE_CAVE);
		public static final Sound Rain = new Sound(org.bukkit.Sound.AMBIENCE_RAIN);
		public static final Sound Thunder = new Sound(org.bukkit.Sound.AMBIENCE_THUNDER);

		private Ambiance()
		{
		}
	}

	public static final class Anvil
	{
		public static final Sound Break = new Sound(org.bukkit.Sound.ANVIL_BREAK);
		public static final Sound Land = new Sound(org.bukkit.Sound.ANVIL_LAND);
		public static final Sound Use = new Sound(org.bukkit.Sound.ANVIL_USE);

		private Anvil()
		{
		}
	}

	public static final class Arrow
	{
		public static final Sound Shoot = new Sound(org.bukkit.Sound.SHOOT_ARROW);
		public static final Sound Hit = new Sound(org.bukkit.Sound.ARROW_HIT);

		private Arrow()
		{
		}
	}

	public static final class Player
	{
		public static final Sound Burp = new Sound(org.bukkit.Sound.BURP);
		public static final Sound Drink = new Sound(org.bukkit.Sound.DRINK);
		public static final Sound Eat = new Sound(org.bukkit.Sound.EAT);
		public static final Sound HurtFlesh = new Sound(org.bukkit.Sound.HURT_FLESH);
		public static final Sound LevelUp = new Sound(org.bukkit.Sound.LEVEL_UP);
		public static final Sound OrbPickup = new Sound(org.bukkit.Sound.ORB_PICKUP);

		private Player()
		{
		}
	}

	public static final class Chest
	{
		public static final Sound Close = new Sound(org.bukkit.Sound.CHEST_CLOSE);
		public static final Sound Open = new Sound(org.bukkit.Sound.CHEST_OPEN);

		private Chest()
		{
		}
	}

	public static final class Mechanical
	{
		public static final Sound Click = new Sound(org.bukkit.Sound.CLICK);
		public static final Sound WoodClick = new Sound(org.bukkit.Sound.WOOD_CLICK);

		private Mechanical()
		{
		}

		public static final class Door
		{
			public static final Sound Close = new Sound(org.bukkit.Sound.DOOR_CLOSE);
			public static final Sound Open = new Sound(org.bukkit.Sound.DOOR_OPEN);

			private Door()
			{
			}
		}
	}

	public static final class Fall
	{
		public static final Sound Big = new Sound(org.bukkit.Sound.FALL_BIG);
		public static final Sound Small = new Sound(org.bukkit.Sound.FALL_SMALL);

		private Fall()
		{
		}
	}

	public static final class Environment
	{
		public static final Sound Explode = new Sound(org.bukkit.Sound.EXPLODE);
		public static final Sound Glass = new Sound(org.bukkit.Sound.GLASS);
		public static final Sound Fire = new Sound(org.bukkit.Sound.FIRE);
		public static final Sound Ignition = new Sound(org.bukkit.Sound.FIRE_IGNITE);
		public static final Sound Fizz = new Sound(org.bukkit.Sound.FIZZ);
		public static final Sound Fuse = new Sound(org.bukkit.Sound.FUSE);
		public static final Sound Lava = new Sound(org.bukkit.Sound.LAVA);
		public static final Sound LavaBubble = new Sound(org.bukkit.Sound.LAVA_POP);
		public static final Sound Splash = new Sound(org.bukkit.Sound.SPLASH);
		public static final Sound Splash2 = new Sound(org.bukkit.Sound.SPLASH2);
		public static final Sound Swim = new Sound(org.bukkit.Sound.SWIM);
		public static final Sound Water = new Sound(org.bukkit.Sound.WATER);

		private Environment()
		{
		}

		public static final class Step
		{
			public static final Sound Grass = new Sound(org.bukkit.Sound.STEP_GRASS);
			public static final Sound Gravel = new Sound(org.bukkit.Sound.STEP_GRAVEL);
			public static final Sound Ladder = new Sound(org.bukkit.Sound.STEP_LADDER);
			public static final Sound Sand = new Sound(org.bukkit.Sound.STEP_SAND);
			public static final Sound Snow = new Sound(org.bukkit.Sound.STEP_SNOW);
			public static final Sound Stone = new Sound(org.bukkit.Sound.STEP_STONE);
			public static final Sound Wood = new Sound(org.bukkit.Sound.STEP_WOOD);
			public static final Sound Wool = new Sound(org.bukkit.Sound.STEP_WOOL);

			private Step()
			{
			}
		}

		public static final class Dig
		{
			public static final Sound Wool = new Sound(org.bukkit.Sound.DIG_WOOL);
			public static final Sound Grass = new Sound(org.bukkit.Sound.DIG_GRASS);
			public static final Sound Gravel = new Sound(org.bukkit.Sound.DIG_GRAVEL);
			public static final Sound Sand = new Sound(org.bukkit.Sound.DIG_SAND);
			public static final Sound Snow = new Sound(org.bukkit.Sound.DIG_SNOW);
			public static final Sound Stone = new Sound(org.bukkit.Sound.DIG_STONE);
			public static final Sound Wood = new Sound(org.bukkit.Sound.DIG_WOOD);

			private Dig()
			{
			}
		}
	}

	public static final class Item
	{
		public static final Sound Break = new Sound(org.bukkit.Sound.ITEM_BREAK);
		public static final Sound PickUp = new Sound(org.bukkit.Sound.ITEM_PICKUP);

		private Item()
		{
		}
	}

	public static final class Minecart
	{
		public static final Sound Base = new Sound(org.bukkit.Sound.MINECART_BASE);
		public static final Sound Inside = new Sound(org.bukkit.Sound.MINECART_INSIDE);

		private Minecart()
		{
		}
	}

	public static final class Note
	{
		public static final Sound Bass = new Sound(org.bukkit.Sound.NOTE_BASS);
		public static final Sound Piano = new Sound(org.bukkit.Sound.NOTE_PIANO);
		public static final Sound BassDrum = new Sound(org.bukkit.Sound.NOTE_BASS_DRUM);
		public static final Sound Sticks = new Sound(org.bukkit.Sound.NOTE_STICKS);
		public static final Sound BassGuitar = new Sound(org.bukkit.Sound.NOTE_BASS_GUITAR);
		public static final Sound Snare = new Sound(org.bukkit.Sound.NOTE_SNARE_DRUM);
		public static final Sound Pling = new Sound(org.bukkit.Sound.NOTE_PLING);

		private Note()
		{
		}
	}

	public static final class Piston
	{
		public static final Sound Extend = new Sound(org.bukkit.Sound.PISTON_EXTEND);
		public static final Sound Retract = new Sound(org.bukkit.Sound.PISTON_RETRACT);

		private Piston()
		{
		}
	}

	public static final class Portal
	{
		public static final Sound Hum = new Sound(org.bukkit.Sound.PORTAL);
		public static final Sound Travel = new Sound(org.bukkit.Sound.PORTAL_TRAVEL);
		public static final Sound Trigger = new Sound(org.bukkit.Sound.PORTAL_TRIGGER);

		private Portal()
		{
		}
	}

	public static class Creature
	{
		public static final class Bat
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.BAT_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.BAT_HURT);
			public static final Sound Idle = new Sound(org.bukkit.Sound.BAT_IDLE);
			public static final Sound Loop = new Sound(org.bukkit.Sound.BAT_LOOP);
			public static final Sound Takeoff = new Sound(org.bukkit.Sound.BAT_TAKEOFF);

			private Bat()
			{
			}
		}

		public static final class Blaze
		{
			public static final Sound Breath = new Sound(org.bukkit.Sound.BLAZE_BREATH);
			public static final Sound Death = new Sound(org.bukkit.Sound.BLAZE_DEATH);
			public static final Sound Hit = new Sound(org.bukkit.Sound.BLAZE_HIT);

			private Blaze()
			{
			}
		}

		public static final class Cat
		{
			public static final Sound Hiss = new Sound(org.bukkit.Sound.CAT_HISS);
			public static final Sound Hit = new Sound(org.bukkit.Sound.CAT_HIT);
			public static final Sound Meow = new Sound(org.bukkit.Sound.CAT_MEOW);
			public static final Sound Purr = new Sound(org.bukkit.Sound.CAT_PURR);
			public static final Sound Purreow = new Sound(org.bukkit.Sound.CAT_PURREOW);

			private Cat()
			{
			}
		}

		public static final class Chicken
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.CHICKEN_IDLE);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.CHICKEN_HURT);
			public static final Sound EggPop = new Sound(org.bukkit.Sound.CHICKEN_EGG_POP);
			public static final Sound Walk = new Sound(org.bukkit.Sound.CHICKEN_WALK);

			private Chicken()
			{
			}
		}

		public static final class Cow
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.COW_IDLE);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.COW_HURT);
			public static final Sound Walk = new Sound(org.bukkit.Sound.COW_WALK);

			private Cow()
			{
			}
		}

		public static final class Creeper
		{
			public static final Sound Hiss = new Sound(org.bukkit.Sound.CREEPER_HISS);
			public static final Sound Death = new Sound(org.bukkit.Sound.CREEPER_DEATH);

			private Creeper()
			{
			}
		}

		public static final class EnderDragon
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENDERDRAGON_DEATH);
			public static final Sound Growl = new Sound(org.bukkit.Sound.ENDERDRAGON_GROWL);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENDERDRAGON_HIT);
			public static final Sound Flap = new Sound(org.bukkit.Sound.ENDERDRAGON_WINGS);

			private EnderDragon()
			{
			}
		}

		public static final class Enderman
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENDERMAN_DEATH);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENDERMAN_HIT);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENDERMAN_IDLE);
			public static final Sound Teleport = new Sound(org.bukkit.Sound.ENDERMAN_TELEPORT);
			public static final Sound Scream = new Sound(org.bukkit.Sound.ENDERMAN_SCREAM);
			public static final Sound Stare = new Sound(org.bukkit.Sound.ENDERMAN_STARE);

			private Enderman()
			{
			}
		}

		public static final class Ghast
		{
			public static final Sound Scream = new Sound(org.bukkit.Sound.GHAST_SCREAM);
			public static final Sound Scream2 = new Sound(org.bukkit.Sound.GHAST_SCREAM2);
			public static final Sound Charge = new Sound(org.bukkit.Sound.GHAST_CHARGE);
			public static final Sound Death = new Sound(org.bukkit.Sound.GHAST_DEATH);
			public static final Sound Fireball = new Sound(org.bukkit.Sound.GHAST_FIREBALL);
			public static final Sound Moan = new Sound(org.bukkit.Sound.GHAST_MOAN);

			private Ghast()
			{
			}
		}

		public static final class Golem
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.IRONGOLEM_DEATH);
			public static final Sound Hit = new Sound(org.bukkit.Sound.IRONGOLEM_HIT);
			public static final Sound Throw = new Sound(org.bukkit.Sound.IRONGOLEM_THROW);
			public static final Sound Walk = new Sound(org.bukkit.Sound.IRONGOLEM_WALK);

			private Golem()
			{
			}
		}

		public static final class MagmaCube
		{
			public static final Sound Walk = new Sound(org.bukkit.Sound.MAGMACUBE_WALK);
			public static final Sound Walk2 = new Sound(org.bukkit.Sound.MAGMACUBE_WALK2);
			public static final Sound Jump = new Sound(org.bukkit.Sound.MAGMACUBE_JUMP);

			private MagmaCube()
			{
			}
		}

		public static final class Pig
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.PIG_IDLE);
			public static final Sound Death = new Sound(org.bukkit.Sound.PIG_DEATH);
			public static final Sound Walk = new Sound(org.bukkit.Sound.PIG_WALK);

			private Pig()
			{
			}
		}

		public static final class Sheep
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.SHEEP_IDLE);
			public static final Sound Shear = new Sound(org.bukkit.Sound.SHEEP_SHEAR);
			public static final Sound Walk = new Sound(org.bukkit.Sound.SHEEP_WALK);

			private Sheep()
			{
			}
		}

		public static final class Silverfish
		{
			public static final Sound Hit = new Sound(org.bukkit.Sound.SILVERFISH_HIT);
			public static final Sound Kill = new Sound(org.bukkit.Sound.SILVERFISH_KILL);
			public static final Sound Idle = new Sound(org.bukkit.Sound.SILVERFISH_IDLE);
			public static final Sound Walk = new Sound(org.bukkit.Sound.SILVERFISH_WALK);

			private Silverfish()
			{
			}
		}

		public static final class Skeleton
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.SKELETON_IDLE);
			public static final Sound Death = new Sound(org.bukkit.Sound.SKELETON_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.SKELETON_HURT);
			public static final Sound Walk = new Sound(org.bukkit.Sound.SKELETON_WALK);

			private Skeleton()
			{
			}
		}

		public static final class Slime
		{
			public static final Sound Attack = new Sound(org.bukkit.Sound.SLIME_ATTACK);
			public static final Sound Walk = new Sound(org.bukkit.Sound.SLIME_WALK);
			public static final Sound Walk2 = new Sound(org.bukkit.Sound.SLIME_WALK2);

			private Slime()
			{
			}
		}

		public static final class Spider
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.SPIDER_IDLE);
			public static final Sound Death = new Sound(org.bukkit.Sound.SPIDER_DEATH);
			public static final Sound Walk = new Sound(org.bukkit.Sound.SPIDER_WALK);

			private Spider()
			{
			}
		}

		public static final class Villager
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.VILLAGER_IDLE);
			public static final Sound Death = new Sound(org.bukkit.Sound.VILLAGER_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.VILLAGER_HIT);
			public static final Sound Haggle = new Sound(org.bukkit.Sound.VILLAGER_HAGGLE);
			public static final Sound Yes = new Sound(org.bukkit.Sound.VILLAGER_YES);
			public static final Sound No = new Sound(org.bukkit.Sound.VILLAGER_NO);

			private Villager()
			{
			}
		}

		public static final class Wither
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.WITHER_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.WITHER_HURT);
			public static final Sound Idle = new Sound(org.bukkit.Sound.WITHER_IDLE);
			public static final Sound Shoot = new Sound(org.bukkit.Sound.WITHER_SHOOT);
			public static final Sound Spawn = new Sound(org.bukkit.Sound.WITHER_SPAWN);

			private Wither()
			{
			}
		}

		public static final class Wolf
		{
			public static final Sound Bark = new Sound(org.bukkit.Sound.WOLF_BARK);
			public static final Sound Death = new Sound(org.bukkit.Sound.WOLF_DEATH);
			public static final Sound Growl = new Sound(org.bukkit.Sound.WOLF_GROWL);
			public static final Sound Howl = new Sound(org.bukkit.Sound.WOLF_HOWL);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.WOLF_HURT);
			public static final Sound Pant = new Sound(org.bukkit.Sound.WOLF_PANT);
			public static final Sound Shake = new Sound(org.bukkit.Sound.WOLF_SHAKE);
			public static final Sound Walk = new Sound(org.bukkit.Sound.WOLF_WALK);
			public static final Sound Whine = new Sound(org.bukkit.Sound.WOLF_WHINE);

			private Wolf()
			{
			}
		}

		public static final class Zombie
		{
			public static final Sound Metal = new Sound(org.bukkit.Sound.ZOMBIE_METAL);
			public static final Sound Wood = new Sound(org.bukkit.Sound.ZOMBIE_WOOD);
			public static final Sound WoodBreak = new Sound(org.bukkit.Sound.ZOMBIE_WOODBREAK);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ZOMBIE_IDLE);
			public static final Sound Death = new Sound(org.bukkit.Sound.ZOMBIE_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ZOMBIE_HURT);
			public static final Sound Infect = new Sound(org.bukkit.Sound.ZOMBIE_INFECT);
			public static final Sound Disinfect = new Sound(org.bukkit.Sound.ZOMBIE_UNFECT);
			public static final Sound Remedy = new Sound(org.bukkit.Sound.ZOMBIE_REMEDY);

			private Zombie()
			{
			}
		}

		public static final class PigZombie
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ZOMBIE_PIG_IDLE);
			public static final Sound Angry = new Sound(org.bukkit.Sound.ZOMBIE_PIG_ANGRY);
			public static final Sound Death = new Sound(org.bukkit.Sound.ZOMBIE_PIG_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ZOMBIE_PIG_HURT);

			private PigZombie()
			{
			}
		}
	}

	public void Play(ILocation location)
	{
		Play(location, 1, 1);
	}

	public void Play(ILocation location, float volume, float pitch)
	{
		location.getWorld().playSound(location, this, volume, pitch);
	}

	public org.bukkit.Sound getSound()
	{
		return sample;
	}

	Sound(org.bukkit.Sound sample)
	{
		this.sample = sample;
		//noinspection ThisEscapedInObjectConstruction
		soundboard.put(sample.name(), this);
	}

	private final org.bukkit.Sound sample;
	private static final Map<String, Sound> soundboard = new HashMap<String, Sound>(org.bukkit.Sound.values().length);
}
