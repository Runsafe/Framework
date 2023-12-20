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
		public static final Sound Cave = new Sound(org.bukkit.Sound.AMBIENT_CAVE);
		public static final Sound Rain = new Sound(org.bukkit.Sound.WEATHER_RAIN);
		public static final Sound RainAbove = new Sound(org.bukkit.Sound.WEATHER_RAIN_ABOVE);
		public static final Sound Thunder = new Sound(org.bukkit.Sound.ENTITY_LIGHTNING_THUNDER);

		private Ambiance()
		{
		}
	}

	public static final class UI
	{
		public static final Sound ButtonClick = new Sound(org.bukkit.Sound.UI_BUTTON_CLICK);
		public static final Sound ChallengeComplete = new Sound(org.bukkit.Sound.UI_TOAST_CHALLENGE_COMPLETE);
		public static final Sound ToastIn = new Sound(org.bukkit.Sound.UI_TOAST_IN);
		public static final Sound ToastOut = new Sound(org.bukkit.Sound.UI_TOAST_OUT);

		private UI()
		{
		}
	}

	public static final class Music
	{
		public static final Sound Creative = new Sound(org.bukkit.Sound.MUSIC_CREATIVE);
		public static final Sound Credits = new Sound(org.bukkit.Sound.MUSIC_CREDITS);
		public static final Sound Dragon = new Sound(org.bukkit.Sound.MUSIC_DRAGON);
		public static final Sound End = new Sound(org.bukkit.Sound.MUSIC_END);
		public static final Sound Game = new Sound(org.bukkit.Sound.MUSIC_GAME);
		public static final Sound Menu = new Sound(org.bukkit.Sound.MUSIC_MENU);
		public static final Sound Nether = new Sound(org.bukkit.Sound.MUSIC_NETHER);

		private Music()
		{
		}
	}

	public static final class Record
	{
		public static final Sound Thirteen = new Sound(org.bukkit.Sound.RECORD_13);
		public static final Sound Cat = new Sound(org.bukkit.Sound.RECORD_CAT);
		public static final Sound Blocks = new Sound(org.bukkit.Sound.RECORD_BLOCKS);
		public static final Sound Chirp = new Sound(org.bukkit.Sound.RECORD_CHIRP);
		public static final Sound Far = new Sound(org.bukkit.Sound.RECORD_FAR);
		public static final Sound Mall = new Sound(org.bukkit.Sound.RECORD_MALL);
		public static final Sound Mellohi = new Sound(org.bukkit.Sound.RECORD_MELLOHI);
		public static final Sound Stal = new Sound(org.bukkit.Sound.RECORD_STAL);
		public static final Sound Strad = new Sound(org.bukkit.Sound.RECORD_STRAD);
		public static final Sound Ward = new Sound(org.bukkit.Sound.RECORD_WARD);
		public static final Sound Eleven = new Sound(org.bukkit.Sound.RECORD_11);
		public static final Sound Wait = new Sound(org.bukkit.Sound.RECORD_WAIT);
		public static final Sound Pigstep = new Sound(org.bukkit.Sound.ENTITY_PIG_STEP); // placeholder
		public static final Sound Otherside = new Sound(org.bukkit.Sound.RECORD_13); // placeholder
		public static final Sound Relic = new Sound(org.bukkit.Sound.RECORD_13); // placeholder
		public static final Sound Five = new Sound(org.bukkit.Sound.RECORD_13); // placeholder

		private Record()
		{
		}
	}

	public static final class Anvil
	{
		public static final Sound Destroy = new Sound(org.bukkit.Sound.BLOCK_ANVIL_DESTROY);
		public static final Sound Fall = new Sound(org.bukkit.Sound.BLOCK_ANVIL_FALL);
		public static final Sound Hit = new Sound(org.bukkit.Sound.BLOCK_ANVIL_HIT);
		public static final Sound Land = new Sound(org.bukkit.Sound.BLOCK_ANVIL_LAND);
		public static final Sound Place = new Sound(org.bukkit.Sound.BLOCK_ANVIL_PLACE);
		public static final Sound Use = new Sound(org.bukkit.Sound.BLOCK_ANVIL_USE);

		private Anvil()
		{
		}
	}

	public static final class Arrow
	{
		public static final Sound Shoot = new Sound(org.bukkit.Sound.ENTITY_ARROW_SHOOT);
		public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_ARROW_HIT);
		public static final Sound HitPlayer = new Sound(org.bukkit.Sound.ENTITY_ARROW_HIT_PLAYER);

		private Arrow()
		{
		}
	}

	public static final class Player
	{
		public static final Sound Burp = new Sound(org.bukkit.Sound.ENTITY_PLAYER_BURP);
		public static final Sound Drink = new Sound(org.bukkit.Sound.ENTITY_GENERIC_DRINK);
		public static final Sound Eat = new Sound(org.bukkit.Sound.ENTITY_GENERIC_EAT);
		public static final Sound HurtFlesh = new Sound(org.bukkit.Sound.ENTITY_GENERIC_HURT);
		public static final Sound LevelUp = new Sound(org.bukkit.Sound.ENTITY_PLAYER_LEVELUP);
		public static final Sound OrbPickup = new Sound(org.bukkit.Sound.ENTITY_EXPERIENCE_ORB_PICKUP);

		private Player()
		{
		}
	}

	public static final class Chest
	{
		public static final Sound Close = new Sound(org.bukkit.Sound.BLOCK_CHEST_CLOSE);
		public static final Sound Open = new Sound(org.bukkit.Sound.BLOCK_CHEST_OPEN);
		public static final Sound Locked = new Sound(org.bukkit.Sound.BLOCK_CHEST_LOCKED);
		public static final Sound ShulkerClose = new Sound(org.bukkit.Sound.BLOCK_SHULKER_BOX_CLOSE);
		public static final Sound ShulkerOpen = new Sound(org.bukkit.Sound.BLOCK_SHULKER_BOX_OPEN);
		public static final Sound EnderChestClose = new Sound(org.bukkit.Sound.BLOCK_ENDERCHEST_CLOSE);
		public static final Sound EnderChestOpen = new Sound(org.bukkit.Sound.BLOCK_ENDERCHEST_OPEN);

		private Chest()
		{
		}
	}

	public static final class ChorusFlower
	{
		public static final Sound Death = new Sound(org.bukkit.Sound.BLOCK_CHORUS_FLOWER_DEATH);
		public static final Sound Grow = new Sound(org.bukkit.Sound.BLOCK_CHORUS_FLOWER_GROW);

		private ChorusFlower()
		{
		}
	}

	public static final class UtilityBlock
	{
		public static final Sound Brew = new Sound(org.bukkit.Sound.BLOCK_BREWING_STAND_BREW);
		public static final Sound EnchantmentTableUse = new Sound(org.bukkit.Sound.BLOCK_ENCHANTMENT_TABLE_USE);
		public static final Sound FurnaceCrackle = new Sound(org.bukkit.Sound.BLOCK_FURNACE_FIRE_CRACKLE);

		UtilityBlock()
		{
		}
	}

	public static final class Mechanical
	{
		public static final Sound Click = new Sound(org.bukkit.Sound.BLOCK_STONE_BUTTON_CLICK_ON);
		public static final Sound WoodClick = new Sound(org.bukkit.Sound.BLOCK_WOOD_BUTTON_CLICK_ON);

		private Mechanical()
		{
		}

		public static final class Door
		{
			public static final Sound Close = new Sound(org.bukkit.Sound.BLOCK_WOODEN_DOOR_CLOSE);
			public static final Sound Open = new Sound(org.bukkit.Sound.BLOCK_WOODEN_DOOR_OPEN);

			private Door()
			{
			}
		}

		public static final class Fence
		{
			public static final Sound Close = new Sound(org.bukkit.Sound.BLOCK_FENCE_GATE_CLOSE);
			public static final Sound Open = new Sound(org.bukkit.Sound.BLOCK_FENCE_GATE_OPEN);

			private Fence()
			{
			}
		}
	}

	public static final class Fall
	{
		public static final Sound Big = new Sound(org.bukkit.Sound.ENTITY_GENERIC_BIG_FALL);
		public static final Sound Small = new Sound(org.bukkit.Sound.ENTITY_GENERIC_SMALL_FALL);

		private Fall()
		{
		}
	}

	public static final class Environment
	{
		public static final Sound Explode = new Sound(org.bukkit.Sound.ENTITY_GENERIC_EXPLODE);
		public static final Sound Glass = new Sound(org.bukkit.Sound.BLOCK_GLASS_FALL);
		public static final Sound Fire = new Sound(org.bukkit.Sound.BLOCK_FIRE_AMBIENT);
		public static final Sound Ignition = new Sound(org.bukkit.Sound.ENTITY_TNT_PRIMED);
		public static final Sound Fizz = new Sound(org.bukkit.Sound.BLOCK_FIRE_EXTINGUISH);
		public static final Sound Fuse = new Sound(org.bukkit.Sound.ENTITY_TNT_PRIMED);
		public static final Sound Lava = new Sound(org.bukkit.Sound.BLOCK_LAVA_AMBIENT);
		public static final Sound LavaBubble = new Sound(org.bukkit.Sound.BLOCK_LAVA_POP);
		public static final Sound Splash = new Sound(org.bukkit.Sound.ENTITY_GENERIC_SPLASH);
		public static final Sound Splash2 = new Sound(org.bukkit.Sound.ENTITY_GENERIC_SPLASH);
		public static final Sound Swim = new Sound(org.bukkit.Sound.ENTITY_GENERIC_SWIM);
		public static final Sound Water = new Sound(org.bukkit.Sound.BLOCK_WATER_AMBIENT);

		private Environment()
		{
		}

		public static final class Step
		{
			public static final Sound Anvil = new Sound(org.bukkit.Sound.BLOCK_ANVIL_STEP);
			public static final Sound Glass = new Sound(org.bukkit.Sound.BLOCK_GLASS_STEP);
			public static final Sound Grass = new Sound(org.bukkit.Sound.BLOCK_GRASS_STEP);
			public static final Sound Gravel = new Sound(org.bukkit.Sound.BLOCK_GRAVEL_STEP);
			public static final Sound Ladder = new Sound(org.bukkit.Sound.BLOCK_LADDER_STEP);
			public static final Sound Sand = new Sound(org.bukkit.Sound.BLOCK_SAND_STEP);
			public static final Sound Snow = new Sound(org.bukkit.Sound.BLOCK_SNOW_STEP);
			public static final Sound Stone = new Sound(org.bukkit.Sound.BLOCK_STONE_STEP);
			public static final Sound Wood = new Sound(org.bukkit.Sound.BLOCK_WOOD_STEP);
			public static final Sound Wool = new Sound(org.bukkit.Sound.BLOCK_CLOTH_STEP);

			private Step()
			{
			}
		}

		public static final class Dig
		{
			public static final Sound Anvil = new Sound(org.bukkit.Sound.BLOCK_ANVIL_BREAK);
			public static final Sound Wool = new Sound(org.bukkit.Sound.BLOCK_CLOTH_BREAK); // TODO wool sounds
			public static final Sound Glass = new Sound(org.bukkit.Sound.BLOCK_GLASS_BREAK);
			public static final Sound Grass = new Sound(org.bukkit.Sound.BLOCK_GRASS_BREAK);
			public static final Sound Gravel = new Sound(org.bukkit.Sound.BLOCK_GRAVEL_BREAK);
			public static final Sound Sand = new Sound(org.bukkit.Sound.BLOCK_SAND_BREAK);
			public static final Sound Snow = new Sound(org.bukkit.Sound.BLOCK_SNOW_BREAK);
			public static final Sound Stone = new Sound(org.bukkit.Sound.BLOCK_STONE_BREAK);
			public static final Sound Wood = new Sound(org.bukkit.Sound.BLOCK_WOOD_BREAK);

			private Dig()
			{
			}
		}
	}

	public static final class Item
	{
		public static final Sound Break = new Sound(org.bukkit.Sound.ENTITY_ITEM_BREAK);
		public static final Sound PickUp = new Sound(org.bukkit.Sound.ENTITY_ITEM_PICKUP);

		public static final Sound ChorusFruitTeleport = new Sound(org.bukkit.Sound.ITEM_CHORUS_FRUIT_TELEPORT);
		public static final Sound ElytraFlying = new Sound(org.bukkit.Sound.ITEM_ELYTRA_FLYING);
		public static final Sound FirechargeUse = new Sound(org.bukkit.Sound.ITEM_FIRECHARGE_USE);
		public static final Sound FlintAndSteelUse = new Sound(org.bukkit.Sound.ITEM_FLINTANDSTEEL_USE);
		public static final Sound HoeTill = new Sound(org.bukkit.Sound.ITEM_HOE_TILL);
		public static final Sound ShovelFlatten = new Sound(org.bukkit.Sound.ITEM_SHOVEL_FLATTEN);
		public static final Sound TotemUse = new Sound(org.bukkit.Sound.ITEM_TOTEM_USE);

		private Item()
		{
		}

		public static final class Armour
		{
			public static final Sound EquipChain = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_CHAIN);
			public static final Sound EquipDiamond = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_DIAMOND);
			public static final Sound EquipElytra = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_ELYTRA);
			public static final Sound EquipGeneric = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_GENERIC);
			public static final Sound EquipGold = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_GOLD);
			public static final Sound EquipIron = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_IRON);
			public static final Sound EquipLeather = new Sound(org.bukkit.Sound.ITEM_ARMOR_EQUIP_LEATHER);

			private Armour()
			{
			}
		}

		public static final class Bottle
		{
			public static final Sound Empty = new Sound(org.bukkit.Sound.ITEM_BOTTLE_EMPTY);
			public static final Sound Fill = new Sound(org.bukkit.Sound.ITEM_BOTTLE_FILL);
			public static final Sound FillDragonbreath = new Sound(org.bukkit.Sound.ITEM_BOTTLE_FILL_DRAGONBREATH);

			private Bottle()
			{
			}
		}

		public static final class Bucket
		{
			public static final Sound Empty = new Sound(org.bukkit.Sound.ITEM_BUCKET_EMPTY);
			public static final Sound EmptyLava = new Sound(org.bukkit.Sound.ITEM_BUCKET_EMPTY_LAVA);
			public static final Sound Fill = new Sound(org.bukkit.Sound.ITEM_BUCKET_FILL);
			public static final Sound FillLava = new Sound(org.bukkit.Sound.ITEM_BUCKET_FILL_LAVA);

			private Bucket()
			{
			}
		}

		public static final class Shield
		{
			public static final Sound Block = new Sound(org.bukkit.Sound.ITEM_SHIELD_BLOCK);
			public static final Sound Break = new Sound(org.bukkit.Sound.ITEM_SHIELD_BREAK);

			private Shield()
			{
			}
		}
	}

	public static final class Minecart
	{
		public static final Sound Base = new Sound(org.bukkit.Sound.ENTITY_MINECART_RIDING);
		public static final Sound Inside = new Sound(org.bukkit.Sound.ENTITY_MINECART_INSIDE);

		private Minecart()
		{
		}
	}

	public static final class Note
	{
		public static final Sound Bass = new Sound(org.bukkit.Sound.BLOCK_NOTE_BASS);
		public static final Sound Piano = new Sound(org.bukkit.Sound.BLOCK_NOTE_HARP);
		public static final Sound BassDrum = new Sound(org.bukkit.Sound.BLOCK_NOTE_BASEDRUM);
		public static final Sound Sticks = new Sound(org.bukkit.Sound.BLOCK_NOTE_HAT);
		public static final Sound BassGuitar = new Sound(org.bukkit.Sound.BLOCK_NOTE_BASS);
		public static final Sound Snare = new Sound(org.bukkit.Sound.BLOCK_NOTE_SNARE);
		public static final Sound Pling = new Sound(org.bukkit.Sound.BLOCK_NOTE_PLING);
		public static final Sound Bell = new Sound(org.bukkit.Sound.BLOCK_NOTE_BELL);
		public static final Sound Chime = new Sound(org.bukkit.Sound.BLOCK_NOTE_CHIME);
		public static final Sound Flute = new Sound(org.bukkit.Sound.BLOCK_NOTE_FLUTE);
		public static final Sound Guitar = new Sound(org.bukkit.Sound.BLOCK_NOTE_GUITAR);
		public static final Sound Xylophone = new Sound(org.bukkit.Sound.BLOCK_NOTE_XYLOPHONE);
		public static final Sound Banjo = new Sound(org.bukkit.Sound.BLOCK_NOTE_GUITAR); // Placeholder
		public static final Sound CowBell = new Sound(org.bukkit.Sound.BLOCK_NOTE_BELL); // Placeholder
		public static final Sound Didgeridoo = new Sound(org.bukkit.Sound.BLOCK_NOTE_GUITAR); // Placeholder
		public static final Sound Bit = new Sound(org.bukkit.Sound.BLOCK_NOTE_GUITAR); // Placeholder
		public static final Sound IronXylophone = new Sound(org.bukkit.Sound.BLOCK_NOTE_XYLOPHONE); // Placeholder

		private Note()
		{
		}
	}

	public static final class Redstone
	{
		public static final Sound ComparatorClick = new Sound(org.bukkit.Sound.BLOCK_COMPARATOR_CLICK);

		private Redstone()
		{
		}

		public static final class Dispenser
		{
			public static final Sound Dispense = new Sound(org.bukkit.Sound.BLOCK_DISPENSER_DISPENSE);
			public static final Sound Fail = new Sound(org.bukkit.Sound.BLOCK_DISPENSER_FAIL);
			public static final Sound Launch = new Sound(org.bukkit.Sound.BLOCK_DISPENSER_LAUNCH);

			Dispenser()
			{
			}
		}

		public static final class Piston
		{
			public static final Sound Extend = new Sound(org.bukkit.Sound.BLOCK_PISTON_EXTEND);
			public static final Sound Retract = new Sound(org.bukkit.Sound.BLOCK_PISTON_CONTRACT);

			private Piston()
			{
			}
		}
	}

	public static final class Portal
	{
		public static final Sound Hum = new Sound(org.bukkit.Sound.BLOCK_PORTAL_AMBIENT);
		public static final Sound Travel = new Sound(org.bukkit.Sound.BLOCK_PORTAL_TRAVEL);
		public static final Sound Trigger = new Sound(org.bukkit.Sound.BLOCK_PORTAL_TRIGGER);

		public static final Sound EndGatewaySpawn = new Sound(org.bukkit.Sound.BLOCK_END_GATEWAY_SPAWN);
		public static final Sound EndPortalFrameFill = new Sound(org.bukkit.Sound.BLOCK_END_PORTAL_FRAME_FILL);
		public static final Sound EndPortalSpawn = new Sound(org.bukkit.Sound.BLOCK_END_PORTAL_SPAWN);



		private Portal()
		{
		}
	}

	public static class Creature
	{
		public static final class Bat
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_BAT_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_BAT_HURT);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_BAT_AMBIENT);
			public static final Sound Loop = new Sound(org.bukkit.Sound.ENTITY_BAT_LOOP);
			public static final Sound Takeoff = new Sound(org.bukkit.Sound.ENTITY_BAT_TAKEOFF);

			private Bat()
			{
			}
		}

		public static final class Blaze
		{
			public static final Sound Breath = new Sound(org.bukkit.Sound.ENTITY_BLAZE_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_BLAZE_DEATH);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_BLAZE_HURT);

			private Blaze()
			{
			}
		}

		public static final class Cat
		{
			public static final Sound Hiss = new Sound(org.bukkit.Sound.ENTITY_CAT_HISS);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_CAT_HURT);
			public static final Sound Meow = new Sound(org.bukkit.Sound.ENTITY_CAT_AMBIENT);
			public static final Sound Purr = new Sound(org.bukkit.Sound.ENTITY_CAT_PURR);
			public static final Sound Purreow = new Sound(org.bukkit.Sound.ENTITY_CAT_PURREOW);

			private Cat()
			{
			}
		}

		public static final class Chicken
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_CHICKEN_AMBIENT);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_CHICKEN_HURT);
			public static final Sound EggPop = new Sound(org.bukkit.Sound.ENTITY_CHICKEN_EGG);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_CHICKEN_STEP);

			private Chicken()
			{
			}
		}

		public static final class Cow
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_COW_AMBIENT);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_COW_HURT);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_COW_STEP);

			private Cow()
			{
			}
		}

		public static final class Creeper
		{
			public static final Sound Hiss = new Sound(org.bukkit.Sound.ENTITY_CREEPER_PRIMED);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_CREEPER_DEATH);

			private Creeper()
			{
			}
		}

		public static final class EnderDragon
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_ENDERDRAGON_DEATH);
			public static final Sound Growl = new Sound(org.bukkit.Sound.ENTITY_ENDERDRAGON_GROWL);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_ENDERDRAGON_HURT);
			public static final Sound Flap = new Sound(org.bukkit.Sound.ENTITY_ENDERDRAGON_FLAP);

			private EnderDragon()
			{
			}
		}

		public static final class Enderman
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_ENDERMEN_DEATH);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_ENDERMEN_HURT);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_ENDERMEN_AMBIENT);
			public static final Sound Teleport = new Sound(org.bukkit.Sound.ENTITY_ENDERMEN_TELEPORT);
			public static final Sound Scream = new Sound(org.bukkit.Sound.ENTITY_ENDERMEN_SCREAM);
			public static final Sound Stare = new Sound(org.bukkit.Sound.ENTITY_ENDERMEN_STARE);

			private Enderman()
			{
			}
		}

		public static final class Ghast
		{
			public static final Sound Scream = new Sound(org.bukkit.Sound.ENTITY_GHAST_SCREAM);
			public static final Sound Scream2 = new Sound(org.bukkit.Sound.ENTITY_GHAST_SCREAM);
			public static final Sound Charge = new Sound(org.bukkit.Sound.ENTITY_GHAST_WARN);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_GHAST_DEATH);
			public static final Sound Fireball = new Sound(org.bukkit.Sound.ENTITY_GHAST_SHOOT);
			public static final Sound Moan = new Sound(org.bukkit.Sound.ENTITY_GHAST_AMBIENT);

			private Ghast()
			{
			}
		}

		public static final class Golem
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_IRONGOLEM_DEATH);
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_IRONGOLEM_ATTACK);
			public static final Sound Throw = new Sound(org.bukkit.Sound.ENTITY_IRONGOLEM_ATTACK);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_IRONGOLEM_STEP);

			private Golem()
			{
			}
		}

		public static final class Illager
		{
			private Illager()
			{
			}

			public static final class Evocation
			{
				public static final Sound Fang = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_FANGS_ATTACK);
				public static final Sound Ambient = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_AMBIENT);
				public static final Sound CastSpell = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_CAST_SPELL);
				public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_DEATH);
				public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_HURT);
				public static final Sound PrepareAttack = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_PREPARE_ATTACK);
				public static final Sound PrepareSummon = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_PREPARE_SUMMON);
				public static final Sound PrepareWololo = new Sound(org.bukkit.Sound.ENTITY_EVOCATION_ILLAGER_PREPARE_WOLOLO);

				private Evocation()
				{
				}
			}

			public static final class Illusion
			{
				public static final Sound Ambient = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_AMBIENT);
				public static final Sound CastSpell = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_CAST_SPELL);
				public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_DEATH);
				public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_HURT);
				public static final Sound MirrorMove = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_MIRROR_MOVE);
				public static final Sound PrepareBlindness = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_PREPARE_BLINDNESS);
				public static final Sound PrepareMirror = new Sound(org.bukkit.Sound.ENTITY_ILLUSION_ILLAGER_PREPARE_MIRROR);

				private Illusion()
				{
				}
			}
		}

		public static final class MagmaCube
		{
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_MAGMACUBE_SQUISH);
			public static final Sound Walk2 = new Sound(org.bukkit.Sound.ENTITY_SMALL_MAGMACUBE_SQUISH);
			public static final Sound Jump = new Sound(org.bukkit.Sound.ENTITY_MAGMACUBE_JUMP);

			private MagmaCube()
			{
			}
		}

		public static final class Parrot
		{
			public static final Sound Ambient = new Sound(org.bukkit.Sound.ENTITY_PARROT_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_PARROT_DEATH);
			public static final Sound Eat = new Sound(org.bukkit.Sound.ENTITY_PARROT_EAT);
			public static final Sound Fly = new Sound(org.bukkit.Sound.ENTITY_PARROT_FLY);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_PARROT_HURT);
			public static final Sound Step = new Sound(org.bukkit.Sound.ENTITY_PARROT_STEP);

			private Parrot()
			{
			}

			public static final class Imitate
			{
				public static final Sound Blaze = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_BLAZE);
				public static final Sound Creeper = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_CREEPER);
				public static final Sound ElderGuardian = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ELDER_GUARDIAN);
				public static final Sound EnderDragon = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ENDERDRAGON);
				public static final Sound Enderman = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ENDERMAN);
				public static final Sound EvocationIllager = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_EVOCATION_ILLAGER);
				public static final Sound Ghast = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_GHAST);
				public static final Sound Husk = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_HUSK);
				public static final Sound IllusionIllager = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ILLUSION_ILLAGER);
				public static final Sound MagmaCube = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_MAGMACUBE);
				public static final Sound PolarBear = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_POLAR_BEAR);
				public static final Sound Shulker = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_SHULKER);
				public static final Sound Silverfish = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_SILVERFISH);
				public static final Sound Skeleton = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_SKELETON);
				public static final Sound Slime = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_SLIME);
				public static final Sound Spider = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_SPIDER);
				public static final Sound Stray = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_STRAY);
				public static final Sound Vex = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_VEX);
				public static final Sound VindicationIllager = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_VINDICATION_ILLAGER);
				public static final Sound Witch = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_WITCH);
				public static final Sound Wither = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_WITHER);
				public static final Sound WitherSkeleton = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_WITHER_SKELETON);
				public static final Sound Wolf = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_WOLF);
				public static final Sound Zombie = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ZOMBIE);
				public static final Sound ZombiePigman = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN);
				public static final Sound ZombieVillager = new Sound(org.bukkit.Sound.ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER);

				private Imitate()
				{
				}
			}
		}

		public static final class Pig
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_PIG_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_PIG_DEATH);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_PIG_STEP);

			private Pig()
			{
			}
		}

		public static final class Sheep
		{

			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_SHEEP_AMBIENT);
			public static final Sound Shear = new Sound(org.bukkit.Sound.ENTITY_SHEEP_SHEAR);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_SHEEP_STEP);

			private Sheep()
			{
			}
		}

		public static final class Silverfish
		{
			public static final Sound Hit = new Sound(org.bukkit.Sound.ENTITY_SILVERFISH_HURT);
			public static final Sound Kill = new Sound(org.bukkit.Sound.ENTITY_SILVERFISH_DEATH);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_SILVERFISH_AMBIENT);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_SILVERFISH_STEP);

			private Silverfish()
			{
			}
		}

		public static final class Skeleton
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_SKELETON_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_SKELETON_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_SKELETON_HURT);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_SKELETON_STEP);

			private Skeleton()
			{
			}
		}

		public static final class Slime
		{
			public static final Sound Attack = new Sound(org.bukkit.Sound.ENTITY_SLIME_ATTACK);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_SLIME_SQUISH);
			public static final Sound Walk2 = new Sound(org.bukkit.Sound.ENTITY_SMALL_SLIME_SQUISH);

			private Slime()
			{
			}
		}

		public static final class Spider
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_SPIDER_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_SPIDER_DEATH);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_SPIDER_STEP);

			private Spider()
			{
			}
		}

		public static final class Villager
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_VILLAGER_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_VILLAGER_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_VILLAGER_HURT);
			public static final Sound Haggle = new Sound(org.bukkit.Sound.ENTITY_VILLAGER_TRADING);
			public static final Sound Yes = new Sound(org.bukkit.Sound.ENTITY_VILLAGER_YES);
			public static final Sound No = new Sound(org.bukkit.Sound.ENTITY_VILLAGER_NO);

			private Villager()
			{
			}
		}

		public static final class Wither
		{
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_WITHER_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_WITHER_HURT);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_WITHER_AMBIENT);
			public static final Sound Shoot = new Sound(org.bukkit.Sound.ENTITY_WITHER_SHOOT);
			public static final Sound Spawn = new Sound(org.bukkit.Sound.ENTITY_WITHER_SPAWN);

			private Wither()
			{
			}
		}

		public static final class Wolf
		{
			public static final Sound Bark = new Sound(org.bukkit.Sound.ENTITY_WOLF_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_WOLF_DEATH);
			public static final Sound Growl = new Sound(org.bukkit.Sound.ENTITY_WOLF_GROWL);
			public static final Sound Howl = new Sound(org.bukkit.Sound.ENTITY_WOLF_HOWL);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_WOLF_HURT);
			public static final Sound Pant = new Sound(org.bukkit.Sound.ENTITY_WOLF_PANT);
			public static final Sound Shake = new Sound(org.bukkit.Sound.ENTITY_WOLF_SHAKE);
			public static final Sound Walk = new Sound(org.bukkit.Sound.ENTITY_WOLF_STEP);
			public static final Sound Whine = new Sound(org.bukkit.Sound.ENTITY_WOLF_WHINE);

			private Wolf()
			{
			}
		}

		public static final class Zombie
		{
			public static final Sound Metal = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR);
			public static final Sound Wood = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_ATTACK_DOOR_WOOD);
			public static final Sound WoodBreak = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_BREAK_DOOR_WOOD);
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_AMBIENT);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_HURT);
			public static final Sound Infect = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_INFECT);
			public static final Sound Disinfect = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED);
			public static final Sound Remedy = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_VILLAGER_CURE);

			private Zombie()
			{
			}
		}

		public static final class PigZombie
		{
			public static final Sound Idle = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_PIG_AMBIENT);
			public static final Sound Angry = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_PIG_ANGRY);
			public static final Sound Death = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_PIG_DEATH);
			public static final Sound Hurt = new Sound(org.bukkit.Sound.ENTITY_ZOMBIE_PIG_HURT);

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
	private static final Map<String, Sound> soundboard = new HashMap<>(org.bukkit.Sound.values().length);
}
