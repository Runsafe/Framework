package no.runsafe.framework.minecraft;

import no.runsafe.framework.enchant.IEnchant;
import no.runsafe.framework.enchant.IEnchantable;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class Item implements IEnchantable
{
	public static class BuildingBlock
	{
		public static Item Stone = new Item(Material.STONE, true);
		public static Item Grass = new Item(Material.GRASS, true);
		public static Item Dirt = new Item(Material.DIRT, true);
		public static Item Cobblestone = new Item(Material.COBBLESTONE, true);
		public static Item Bedrock = new Item(Material.BEDROCK, true);
		public static Item Sand = new Item(Material.SAND, true);
		public static Item Gravel = new Item(Material.GRAVEL, true);
		public static Item Sponge = new Item(Material.SPONGE, true);
		public static Item Glass = new Item(Material.GLASS, true);
		public static Item LapisLazuli = new Item(Material.LAPIS_BLOCK, true);
		public static Item GoldBlock = new Item(Material.GOLD_BLOCK, true);
		public static Item IronBlock = new Item(Material.IRON_BLOCK, true);
		public static Item Brick = new Item(Material.BRICK, true);
		public static Item Bookshelf = new Item(Material.BOOKSHELF, true);
		public static Item MossyCobblestone = new Item(Material.MOSSY_COBBLESTONE, true);
		public static Item Obsidian = new Item(Material.OBSIDIAN, true);
		public static Item Diamond = new Item(Material.DIAMOND_BLOCK, true);
		public static Item Ice = new Item(Material.ICE, true);
		public static Item Snow = new Item(Material.SNOW_BLOCK, true);
		public static Item Clay = new Item(Material.CLAY, true);
		public static Item Pumpkin = new Item(Material.PUMPKIN, true);
		public static Item Netherrack = new Item(Material.NETHERRACK, true);
		public static Item Soulsand = new Item(Material.SOUL_SAND, true);
		public static Item Glowstone = new Item(Material.GLOWSTONE, true);
		public static Item JackOLantern = new Item(Material.JACK_O_LANTERN, true);
		public static Item Melon = new Item(Material.MELON_BLOCK, true);
		public static Item Mycelium = new Item(Material.MYCEL, true);
		public static Item NetherBrick = new Item(Material.NETHER_BRICK, true);
		public static Item EndStone = new Item(Material.ENDER_STONE, true);
		public static Item Emerald = new Item(Material.EMERALD_BLOCK, true);

		public static class Wood
		{
			public static Item Oak = new Item(Material.LOG, true, 0);
			public static Item Spruce = new Item(Material.LOG, true, 1);
			public static Item Birch = new Item(Material.LOG, true, 2);
			public static Item Jungle = new Item(Material.LOG, true, 3);

			public static class Plank
			{
				public static Item Oak = new Item(Material.WOOD, true, 0);
				public static Item Spruce = new Item(Material.WOOD, true, 1);
				public static Item Birch = new Item(Material.WOOD, true, 2);
				public static Item Jungle = new Item(Material.WOOD, true, 3);
			}
		}

		public static class Sandstone
		{
			public static Item Normal = new Item(Material.SANDSTONE, true, 0);
			public static Item Chiseled = new Item(Material.SANDSTONE, true, 1);
			public static Item Smooth = new Item(Material.SANDSTONE, true, 2);
		}

		public static class Wool
		{
			public static Item White = new Item(Material.WOOL, true, 0);
			public static Item Orange = new Item(Material.WOOL, true, 1);
			public static Item Magenta = new Item(Material.WOOL, true, 2);
			public static Item LightBlue = new Item(Material.WOOL, true, 3);
			public static Item Yellow = new Item(Material.WOOL, true, 4);
			public static Item Lime = new Item(Material.WOOL, true, 5);
			public static Item Pink = new Item(Material.WOOL, true, 6);
			public static Item Gray = new Item(Material.WOOL, true, 7);
			public static Item LightGray = new Item(Material.WOOL, true, 8);
			public static Item Cyan = new Item(Material.WOOL, true, 9);
			public static Item Purple = new Item(Material.WOOL, true, 10);
			public static Item Blue = new Item(Material.WOOL, true, 11);
			public static Item Brown = new Item(Material.WOOL, true, 12);
			public static Item Green = new Item(Material.WOOL, true, 13);
			public static Item Red = new Item(Material.WOOL, true, 14);
			public static Item Black = new Item(Material.WOOL, true, 15);
		}

		public static class Slab
		{
			public static Item Oak = new Item(Material.WOOD_STEP, true, 0);
			public static Item Spruce = new Item(Material.WOOD_STEP, true, 0);
			public static Item Birch = new Item(Material.WOOD_STEP, true, 0);
			public static Item Jungle = new Item(Material.WOOD_STEP, true, 0);
			public static Item Stone = new Item(Material.STEP, true, 0);
			public static Item Sandstone = new Item(Material.STEP, true, 1);
			public static Item Cobblestone = new Item(Material.STEP, true, 2);
			public static Item Brick = new Item(Material.STEP, true, 3);
			public static Item StoneBrick = new Item(Material.STEP, true, 4);
			public static Item NetherRack = new Item(Material.STEP, true, 5);
			public static Item Quartz = new Item(Material.STEP, true, 6);
		}

		public static class Stairs
		{
			public static Item Oak = new Item(Material.WOOD_STAIRS, true);
			public static Item Spruce = new Item(Material.SPRUCE_WOOD_STAIRS, true);
			public static Item Birch = new Item(Material.BIRCH_WOOD_STAIRS, true);
			public static Item Jungle = new Item(Material.JUNGLE_WOOD_STAIRS, true);
			public static Item Cobblestone = new Item(Material.COBBLESTONE_STAIRS, true);
			public static Item Brick = new Item(Material.BRICK_STAIRS, true);
			public static Item StoneBrick = new Item(Material.SMOOTH_STAIRS, true);
			public static Item NetherBrick = new Item(Material.NETHER_BRICK_STAIRS, true);
			public static Item Quartz = new Item(Material.QUARTZ_STAIRS, true);
			public static Item Sandstone = new Item(Material.SANDSTONE_STAIRS, true);
		}

		public static class StoneBrick
		{
			public static Item Normal = new Item(Material.SMOOTH_BRICK, true, 0);
			public static Item Mossy = new Item(Material.SMOOTH_BRICK, true, 1);
			public static Item Cracked = new Item(Material.SMOOTH_BRICK, true, 2);
			public static Item Chiseled = new Item(Material.SMOOTH_BRICK, true, 3);
		}

		public static class CobbleWall
		{
			public static Item Normal = new Item(Material.COBBLE_WALL, true, 0);
			public static Item Mossy = new Item(Material.COBBLE_WALL, true, 1);
		}

		public static class Quartz
		{
			public static Item Normal = new Item(Material.QUARTZ_BLOCK, true, 0);
			public static Item Chiseled = new Item(Material.QUARTZ_BLOCK, true, 1);
			public static Item Pillar = new Item(Material.QUARTZ_BLOCK, true, 2);
		}
	}

	public static class Ore
	{
		public static Item Gold = new Item(Material.GOLD_ORE, true);
		public static Item Iron = new Item(Material.IRON_ORE, true);
		public static Item Coal = new Item(Material.COAL_ORE, true);
		public static Item LapisLazuli = new Item(Material.LAPIS_ORE, true);
		public static Item Diamond = new Item(Material.DIAMOND_ORE, true);
		public static Item Emerald = new Item(Material.EMERALD_ORE, true);
		public static Item Quartz = new Item(Material.QUARTZ_ORE, true);
		public static Item Redstone = new Item(Material.REDSTONE_ORE, true);
	}

	public static class Decoration
	{
		public static Item Web = new Item(Material.WEB, true);
		public static Item LongGrass = new Item(Material.LONG_GRASS, true);
		public static Item DeadBush = new Item(Material.DEAD_BUSH, true);
		public static Item Flower = new Item(Material.YELLOW_FLOWER, true);
		public static Item Rose = new Item(Material.RED_ROSE, true);
		public static Item Torch = new Item(Material.TORCH, true);
		public static Item Chest = new Item(Material.CHEST, true);
		public static Item Workbench = new Item(Material.WORKBENCH, true);
		public static Item Furnace = new Item(Material.FURNACE, true);
		public static Item Ladder = new Item(Material.LADDER, true);
		public static Item Snow = new Item(Material.SNOW, true);
		public static Item Cactus = new Item(Material.CACTUS, true);
		public static Item Jukebox = new Item(Material.JUKEBOX, true);
		public static Item Fence = new Item(Material.FENCE, true);
		public static Item IronBars = new Item(Material.IRON_FENCE, true);
		public static Item GlassPane = new Item(Material.THIN_GLASS, true);
		public static Item Vine = new Item(Material.VINE, true);
		public static Item LilyPad = new Item(Material.WATER_LILY, true);
		public static Item NetherFence = new Item(Material.NETHER_FENCE, true);
		public static Item EnchantmentTable = new Item(Material.ENCHANTMENT_TABLE, true);
		public static Item EnderPortalFrame = new Item(Material.ENDER_PORTAL_FRAME, true);
		public static Item EnderChest = new Item(Material.ENDER_CHEST, true);
		public static Item TrappedChest = new Item(Material.TRAPPED_CHEST, true);
		public static Item Painting = new Item(Material.PAINTING, true);
		public static Item Sign = new Item(Material.SIGN, true);
		public static Item Bed = new Item(Material.BED, true);
		public static Item ItemFrame = new Item(Material.ITEM_FRAME, true);
		public static Item FlowerPot = new Item(Material.FLOWER_POT_ITEM, true);

		public static class Sapling
		{
			public static Item Oak = new Item(Material.SAPLING, true, 0);
			public static Item Spruce = new Item(Material.SAPLING, true, 1);
			public static Item Birch = new Item(Material.SAPLING, true, 2);
			public static Item Jungle = new Item(Material.SAPLING, true, 3);
		}

		public static class Leaves
		{
			public static Item Oak = new Item(Material.LEAVES, true);
			public static Item Spruce = new Item(Material.LEAVES, true);
			public static Item Birch = new Item(Material.LEAVES, true);
			public static Item Jungle = new Item(Material.LEAVES, true);
		}

		public static class Mushroom
		{
			public static Item Brown = new Item(Material.BROWN_MUSHROOM, true);
			public static Item Red = new Item(Material.RED_MUSHROOM, true);
			public static Item Huge1 = new Item(Material.HUGE_MUSHROOM_1, true);
			public static Item Huge2 = new Item(Material.HUGE_MUSHROOM_2, true);
		}

		public static class MonsterEgg
		{
			public static Item Stone = new Item(Material.MONSTER_EGGS, true, 0);
			public static Item Cobblestone = new Item(Material.MONSTER_EGGS, true, 1);
			public static Item StoneBrick = new Item(Material.MONSTER_EGGS, true, 2);
		}

		public static class Anvil
		{
			public static Item Normal = new Item(Material.ANVIL, true, 0);
			public static Item SlightlyDamaged = new Item(Material.ANVIL, true, 1);
			public static Item VeryDamaged = new Item(Material.ANVIL, true, 2);
		}

		public static class Head
		{
			public static Item Skeleton = new Item(Material.SKULL_ITEM, true, 0);
			public static Item WitherSkeleton = new Item(Material.SKULL_ITEM, true, 1);
			public static Item Zombie = new Item(Material.SKULL_ITEM, true, 2);
			public static Item Human = new Item(Material.SKULL_ITEM, true, 3);
			public static Item Creeper = new Item(Material.SKULL_ITEM, true, 4);
		}
	}

	public static class Redstone
	{
		public static Item Block = new Item(Material.REDSTONE_BLOCK, true);
		public static Item Dust = new Item(Material.REDSTONE, true);
		public static Item Torch = new Item(Material.REDSTONE_TORCH_ON, true);
		public static Item Diode = new Item(Material.DIODE, true);
		public static Item Comparator = new Item(Material.REDSTONE_COMPARATOR, true);
		public static Item TripwireHook = new Item(Material.TRIPWIRE_HOOK, true);
		public static Item DaylightDetector = new Item(Material.DAYLIGHT_DETECTOR, true);
		public static Item Lever = new Item(Material.LEVER, true);
		public static Item TNT = new Item(Material.TNT, true);

		public static class Lamp
		{
			public static Item Off = new Item(Material.REDSTONE_LAMP_OFF, true);
			public static Item On = new Item(Material.REDSTONE_LAMP_ON, true);
		}

		public static class Device
		{
			public static Item Dispenser = new Item(Material.DISPENSER, true);
			public static Item NoteBlock = new Item(Material.NOTE_BLOCK, true);
			public static Item Hopper = new Item(Material.HOPPER, true);
			public static Item Dropper = new Item(Material.DROPPER, true);
		}

		public static class Piston
		{
			public static Item Sticky = new Item(Material.PISTON_STICKY_BASE, true);
			public static Item Normal = new Item(Material.PISTON_BASE, true);
		}

		public static class Button
		{
			public static Item Stone = new Item(Material.STONE_BUTTON, true);
			public static Item Wood = new Item(Material.WOOD_BUTTON, true);
		}

		public static class PressurePlate
		{
			public static Item Stone = new Item(Material.STONE_PLATE, true);
			public static Item Wood = new Item(Material.WOOD_PLATE, true);
			public static Item Gold = new Item(Material.GOLD_PLATE, true);
			public static Item Iron = new Item(Material.IRON_PLATE, true);
		}

		public static class Door
		{
			public static Item Trap = new Item(Material.TRAP_DOOR, true);
			public static Item Wood = new Item(Material.WOOD_DOOR, true);
			public static Item Iron = new Item(Material.IRON_DOOR, true);
			public static Item Gate = new Item(Material.FENCE_GATE, true);
		}
	}

	public static class Transportation
	{
		public static Item Saddle = new Item(Material.SADDLE, true);
		public static Item Boat = new Item(Material.BOAT, true);
		public static Item CarrotOnAStick = new Item(Material.CARROT_STICK, true);

		public static class Rail
		{
			public static Item Normal = new Item(Material.RAILS, true);
			public static Item Powered = new Item(Material.POWERED_RAIL, true);
			public static Item Detector = new Item(Material.DETECTOR_RAIL, true);
			public static Item Activator = new Item(Material.ACTIVATOR_RAIL, true);
		}

		public static class Minecart
		{
			public static Item Normal = new Item(Material.MINECART, true);
			public static Item Storage = new Item(Material.STORAGE_MINECART, true);
			public static Item Powered = new Item(Material.POWERED_MINECART, true);
			public static Item Explosive = new Item(Material.EXPLOSIVE_MINECART, true);
			public static Item Hopper = new Item(Material.HOPPER_MINECART, true);
		}
	}

	public static class Miscellaneous
	{
		public static Item Beacon = new Item(Material.BEACON, true);
		public static Item Snowball = new Item(Material.SNOW_BALL, true);
		public static Item Paper = new Item(Material.PAPER, true);
		public static Item Book = new Item(Material.BOOK, true);
		public static Item Slimeball = new Item(Material.SLIME_BALL, true);
		public static Item Bone = new Item(Material.BONE, true);
		public static Item EnderPearl = new Item(Material.ENDER_PEARL, true);
		public static Item EyeOfEnder = new Item(Material.EYE_OF_ENDER, true);
		public static Item ExperienceBottle = new Item(Material.EXP_BOTTLE, true);
		public static Item FireCharge = new Item(Material.FIREBALL, true);
		public static Item BookAndQuill = new Item(Material.BOOK_AND_QUILL, true);
		public static Item Map = new Item(Material.EMPTY_MAP, true);
		public static Item FireworkCharge = new Item(Material.FIREWORK_CHARGE, true);

		public static class Bucket
		{
			public static Item Normal = new Item(Material.BUCKET, true);
			public static Item Water = new Item(Material.WATER_BUCKET, true);
			public static Item Lava = new Item(Material.LAVA_BUCKET, true);
			public static Item Milk = new Item(Material.MILK_BUCKET, true);
		}

		public static class MonsterEgg
		{
			public static Item Creeper = new Item(Material.MONSTER_EGG, true, EntityType.CREEPER.getTypeId());
			public static Item Skeleton = new Item(Material.MONSTER_EGG, true, EntityType.SKELETON.getTypeId());
			public static Item Spider = new Item(Material.MONSTER_EGG, true, EntityType.SPIDER.getTypeId());
			public static Item Zombie = new Item(Material.MONSTER_EGG, true, EntityType.ZOMBIE.getTypeId());
			public static Item Slime = new Item(Material.MONSTER_EGG, true, EntityType.SLIME.getTypeId());
			public static Item Ghast = new Item(Material.MONSTER_EGG, true, EntityType.GHAST.getTypeId());
			public static Item ZombiePigman = new Item(Material.MONSTER_EGG, true, EntityType.PIG_ZOMBIE.getTypeId());
			public static Item Enderman = new Item(Material.MONSTER_EGG, true, EntityType.ENDERMAN.getTypeId());
			public static Item CaveSpider = new Item(Material.MONSTER_EGG, true, EntityType.CAVE_SPIDER.getTypeId());
			public static Item Silverfish = new Item(Material.MONSTER_EGG, true, EntityType.SILVERFISH.getTypeId());
			public static Item Blaze = new Item(Material.MONSTER_EGG, true, EntityType.BLAZE.getTypeId());
			public static Item MagmaCube = new Item(Material.MONSTER_EGG, true, EntityType.MAGMA_CUBE.getTypeId());
			public static Item Bat = new Item(Material.MONSTER_EGG, true, EntityType.BAT.getTypeId());
			public static Item Witch = new Item(Material.MONSTER_EGG, true, EntityType.WITCH.getTypeId());
			public static Item Pig = new Item(Material.MONSTER_EGG, true, EntityType.PIG.getTypeId());
			public static Item Sheep = new Item(Material.MONSTER_EGG, true, EntityType.SHEEP.getTypeId());
			public static Item Cow = new Item(Material.MONSTER_EGG, true, EntityType.COW.getTypeId());
			public static Item Chicken = new Item(Material.MONSTER_EGG, true, EntityType.CHICKEN.getTypeId());
			public static Item Squid = new Item(Material.MONSTER_EGG, true, EntityType.SQUID.getTypeId());
			public static Item Wolf = new Item(Material.MONSTER_EGG, true, EntityType.WOLF.getTypeId());
			public static Item Mooshroom = new Item(Material.MONSTER_EGG, true, EntityType.MUSHROOM_COW.getTypeId());
			public static Item Ocelot = new Item(Material.MONSTER_EGG, true, EntityType.OCELOT.getTypeId());
			public static Item Villager = new Item(Material.MONSTER_EGG, true, EntityType.VILLAGER.getTypeId());
		}

		public static class Record
		{
			public static Item C418_13 = new Item(Material.GOLD_RECORD, true);
			public static Item C418_Cat = new Item(Material.GREEN_RECORD, true);
			public static Item C418_Blocks = new Item(Material.RECORD_3, true);
			public static Item C418_Chirp = new Item(Material.RECORD_4, true);
			public static Item C418_Far = new Item(Material.RECORD_5, true);
			public static Item C418_Mall = new Item(Material.RECORD_6, true);
			public static Item C418_Mellohi = new Item(Material.RECORD_7, true);
			public static Item C418_Stal = new Item(Material.RECORD_8, true);
			public static Item C418_Strad = new Item(Material.RECORD_9, true);
			public static Item C418_Ward = new Item(Material.RECORD_10, true);
			public static Item C418_11 = new Item(Material.RECORD_11, true);
			public static Item C418_Wait = new Item(Material.RECORD_12, true);
		}
	}

	public static class Food
	{
		public static class Plant
		{
			public static Item Apple = new Item(Material.APPLE, true);
			public static Item Melon = new Item(Material.MELON, true);
			public static Item Carrot = new Item(Material.CARROT_ITEM, true);
			public static Item Potato = new Item(Material.POTATO_ITEM, true);
		}

		public static class Meat
		{
			public static Item Pork = new Item(Material.PORK, true);
			public static Item Fish = new Item(Material.RAW_FISH, true);
			public static Item Beef = new Item(Material.RAW_BEEF, true);
			public static Item Chicken = new Item(Material.RAW_CHICKEN, true);
		}

		public static class Cooked
		{
			public static Item MushroomSoup = new Item(Material.MUSHROOM_SOUP, true);
			public static Item Bread = new Item(Material.BREAD, true);
			public static Item Pork = new Item(Material.GRILLED_PORK, true);
			public static Item Fish = new Item(Material.COOKED_FISH, true);
			public static Item Cake = new Item(Material.CAKE, true);
			public static Item Cookie = new Item(Material.COOKIE, true);
			public static Item Beef = new Item(Material.COOKED_BEEF, true);
			public static Item Chicken = new Item(Material.COOKED_CHICKEN, true);
			public static Item Potato = new Item(Material.BAKED_POTATO, true);
			public static Item PumpkinPie = new Item(Material.PUMPKIN_PIE, true);
		}

		public static class Golden
		{
			public static Item Apple = new Item(Material.GOLDEN_APPLE, true);
			public static Item Carrot = new Item(Material.GOLDEN_CARROT, true);
		}

		public static class Unsavory
		{
			public static Item PoisonousPotato = new Item(Material.POISONOUS_POTATO, true);
			public static Item RottenFlesh = new Item(Material.ROTTEN_FLESH, true);
			public static Item SpiderEye = new Item(Material.SPIDER_EYE, true);
		}
	}

	public static class Tool
	{
		public static Item FlintAndSteel = new Item(Material.FLINT_AND_STEEL, true);
		public static Item Compass = new Item(Material.COMPASS, true);
		public static Item FishingRod = new Item(Material.FISHING_ROD, true);
		public static Item Watch = new Item(Material.WATCH, true);
		public static Item Shears = new Item(Material.SHEARS, true);

		public static class Shovel
		{
			public static Item Iron = new Item(Material.IRON_SPADE, true);
			public static Item Wood = new Item(Material.WOOD_SPADE, true);
			public static Item Stone = new Item(Material.STONE_SPADE, true);
			public static Item Diamond = new Item(Material.DIAMOND_SPADE, true);
			public static Item Gold = new Item(Material.GOLD_SPADE, true);
		}

		public static class Pickaxe
		{
			public static Item Iron = new Item(Material.IRON_PICKAXE, true);
			public static Item Wood = new Item(Material.WOOD_PICKAXE, true);
			public static Item Stone = new Item(Material.STONE_PICKAXE, true);
			public static Item Diamond = new Item(Material.DIAMOND_PICKAXE, true);
			public static Item Gold = new Item(Material.GOLD_PICKAXE, true);
		}

		public static class Axe
		{
			public static Item Iron = new Item(Material.IRON_AXE, true);
			public static Item Wood = new Item(Material.WOOD_AXE, true);
			public static Item Stone = new Item(Material.STONE_AXE, true);
			public static Item Diamond = new Item(Material.DIAMOND_AXE, true);
			public static Item Gold = new Item(Material.GOLD_AXE, true);
		}

		public static class Hoe
		{
			public static Item Wood = new Item(Material.WOOD_HOE, true);
			public static Item Stone = new Item(Material.STONE_HOE, true);
			public static Item Iron = new Item(Material.IRON_HOE, true);
			public static Item Diamond = new Item(Material.DIAMOND_HOE, true);
			public static Item Gold = new Item(Material.GOLD_HOE, true);
		}
	}

	public static class Combat
	{
		public static Item Bow = new Item(Material.BOW, true);
		public static Item Arrow = new Item(Material.ARROW, true);

		public static class Sword
		{
			public static Item Wood = new Item(Material.WOOD_SWORD, true);
			public static Item Iron = new Item(Material.IRON_SWORD, true);
			public static Item Stone = new Item(Material.STONE_SWORD, true);
			public static Item Diamond = new Item(Material.DIAMOND_SWORD, true);
			public static Item Gold = new Item(Material.GOLD_SWORD, true);
		}

		public static class Helmet
		{
			public static Item Leather = new Item(Material.LEATHER_HELMET, true);
			public static Item Iron = new Item(Material.IRON_HELMET, true);
			public static Item Diamond = new Item(Material.DIAMOND_HELMET, true);
			public static Item Gold = new Item(Material.GOLD_HELMET, true);
			public static Item Chainmail = new Item(Material.CHAINMAIL_HELMET, true);
		}

		public static class Chestplate
		{
			public static Item Leather = new Item(Material.LEATHER_CHESTPLATE, true);
			public static Item Iron = new Item(Material.IRON_CHESTPLATE, true);
			public static Item Diamond = new Item(Material.DIAMOND_CHESTPLATE, true);
			public static Item Gold = new Item(Material.GOLD_CHESTPLATE, true);
			public static Item Chainmail = new Item(Material.CHAINMAIL_CHESTPLATE, true);
		}

		public static class Leggings
		{
			public static Item Leather = new Item(Material.LEATHER_LEGGINGS, true);
			public static Item Iron = new Item(Material.IRON_LEGGINGS, true);
			public static Item Diamond = new Item(Material.DIAMOND_LEGGINGS, true);
			public static Item Gold = new Item(Material.GOLD_LEGGINGS, true);
			public static Item Chainmail = new Item(Material.CHAINMAIL_LEGGINGS, true);
		}

		public static class Boots
		{
			public static Item Leather = new Item(Material.LEATHER_BOOTS, true);
			public static Item Iron = new Item(Material.IRON_BOOTS, true);
			public static Item Diamond = new Item(Material.DIAMOND_BOOTS, true);
			public static Item Gold = new Item(Material.GOLD_BOOTS, true);
			public static Item Chainmail = new Item(Material.CHAINMAIL_BOOTS, true);
		}
	}

	public static class Brewing
	{
		public static Item GhastTear = new Item(Material.GHAST_TEAR, true);
		public static Item Potion = new Item(Material.POTION, true);
		public static Item GlassBottle = new Item(Material.GLASS_BOTTLE, true);
		public static Item FermentedSpiderEye = new Item(Material.FERMENTED_SPIDER_EYE, true);
		public static Item BlazePowder = new Item(Material.BLAZE_POWDER, true);
		public static Item MagmaCream = new Item(Material.MAGMA_CREAM, true);
		public static Item BrewingStand = new Item(Material.BREWING_STAND_ITEM, true);
		public static Item GlisteringMelon = new Item(Material.SPECKLED_MELON, true);
		public static Item Cauldron = new Item(Material.CAULDRON_ITEM, true);
		public static Item NetherWart = new Item(Material.NETHER_STALK, true);
	}

	public static class Materials
	{
		public static Item Coal = new Item(Material.COAL, true, 0);
		public static Item CharCoal = new Item(Material.COAL, true, 1);
		public static Item Diamond = new Item(Material.DIAMOND, true);
		public static Item IronIngot = new Item(Material.IRON_INGOT, true);
		public static Item GoldIngot = new Item(Material.GOLD_INGOT, true);
		public static Item Stick = new Item(Material.STICK, true);
		public static Item Bowl = new Item(Material.BOWL, true);
		public static Item String = new Item(Material.STRING, true);
		public static Item Feather = new Item(Material.FEATHER, true);
		public static Item Gunpowder = new Item(Material.SULPHUR, true);
		public static Item Wheat = new Item(Material.WHEAT, true);
		public static Item Flint = new Item(Material.FLINT, true);
		public static Item Leather = new Item(Material.LEATHER, true);
		public static Item ClayBrick = new Item(Material.CLAY_BRICK, true);
		public static Item Clay = new Item(Material.CLAY_BALL, true);
		public static Item Sugarcane = new Item(Material.SUGAR_CANE, true);
		public static Item Egg = new Item(Material.EGG, true);
		public static Item GlowstoneDust = new Item(Material.GLOWSTONE_DUST, true);
		public static Item InkSack = new Item(Material.INK_SACK, true, 0);
		public static Item Cocoa = new Item(Material.INK_SACK, true, 3);
		public static Item Sugar = new Item(Material.SUGAR, true);
		public static Item BlazeRod = new Item(Material.BLAZE_ROD, true);
		public static Item GoldNugget = new Item(Material.GOLD_NUGGET, true);
		public static Item Emerald = new Item(Material.EMERALD, true);
		public static Item NetherStar = new Item(Material.NETHER_STAR, true);
		public static Item NetherBrick = new Item(Material.NETHER_BRICK_ITEM, true);
		public static Item Quartz = new Item(Material.QUARTZ, true);
		public static Item BoneMeal = new Item(Material.INK_SACK, true, 15);

		public static class Dye
		{
			public static Item Black = Materials.InkSack;
			public static Item Red = new Item(Material.INK_SACK, true, 1);
			public static Item Green = new Item(Material.INK_SACK, true, 2);
			public static Item Brown = Materials.Cocoa;
			public static Item Blue = new Item(Material.INK_SACK, true, 4);
			public static Item Purple = new Item(Material.INK_SACK, true, 5);
			public static Item Cyan = new Item(Material.INK_SACK, true, 6);
			public static Item LightGray = new Item(Material.INK_SACK, true, 7);
			public static Item Gray = new Item(Material.INK_SACK, true, 8);
			public static Item Pink = new Item(Material.INK_SACK, true, 9);
			public static Item Lime = new Item(Material.INK_SACK, true, 10);
			public static Item Yellow = new Item(Material.INK_SACK, true, 11);
			public static Item LightBlue = new Item(Material.INK_SACK, true, 12);
			public static Item Magenta = new Item(Material.INK_SACK, true, 13);
			public static Item Orange = new Item(Material.INK_SACK, true, 14);
			public static Item White = Materials.BoneMeal;
		}

		public static class Seed
		{
			public static Item Wheat = new Item(Material.SEEDS, true);
			public static Item Pumpkin = new Item(Material.PUMPKIN_SEEDS, true);
			public static Item Melon = new Item(Material.MELON_SEEDS, true);
		}
	}

	public static class Unavailable
	{
		public static Item Air = new Item(Material.AIR, true);
		public static Item Water = new Item(Material.WATER, true);
		public static Item StationaryWater = new Item(Material.STATIONARY_WATER, true);
		public static Item Lava = new Item(Material.LAVA, true);
		public static Item StationaryLava = new Item(Material.STATIONARY_LAVA, true);
		public static Item BedBlock = new Item(Material.BED_BLOCK, true);
		public static Item PistonArm = new Item(Material.PISTON_EXTENSION, true);
		public static Item MovingPistonArm = new Item(Material.PISTON_MOVING_PIECE, true);
		public static Item Fire = new Item(Material.FIRE, true);
		public static Item MobSpawner = new Item(Material.MOB_SPAWNER, true);
		public static Item RedstoneWire = new Item(Material.REDSTONE_WIRE, true);
		public static Item Crops = new Item(Material.CROPS, true);
		public static Item TilledSoil = new Item(Material.SOIL, true);
		public static Item BurningFurnace = new Item(Material.BURNING_FURNACE, true);
		public static Item Signpost = new Item(Material.SIGN_POST, true);
		public static Item WallSign = new Item(Material.WALL_SIGN, true);
		public static Item WoodenDoor = new Item(Material.WOODEN_DOOR, true);
		public static Item IronDoorBlock = new Item(Material.IRON_DOOR_BLOCK, true);
		public static Item GlowingRedstoneOre = new Item(Material.GLOWING_REDSTONE_ORE, true);
		public static Item SugarCaneBlock = new Item(Material.SUGAR_CANE_BLOCK, true);
		public static Item Portal = new Item(Material.PORTAL, true);
		public static Item CakeBlock = new Item(Material.CAKE_BLOCK, true);
		public static Item LockedChest = new Item(Material.LOCKED_CHEST, true);
		public static Item PumpkinStem = new Item(Material.PUMPKIN_STEM, true);
		public static Item MelonStem = new Item(Material.MELON_STEM, true);
		public static Item NetherWart = new Item(Material.NETHER_WARTS, true);
		public static Item BrewingStand = new Item(Material.BREWING_STAND, true);
		public static Item Cauldron = new Item(Material.CAULDRON, true);
		public static Item EnderPortal = new Item(Material.ENDER_PORTAL, true);
		public static Item Cocoa = new Item(Material.COCOA, true);
		public static Item Tripwire = new Item(Material.TRIPWIRE, true);
		public static Item CommandBlock = new Item(Material.COMMAND, true);
		public static Item FlowerPot = new Item(Material.FLOWER_POT, true);
		public static Item Skull = new Item(Material.SKULL, true);
		public static Item Carrot = new Item(Material.CARROT, true);
		public static Item Potato = new Item(Material.POTATO, true);

		public static class Redstone
		{
			public static Item TorchOff = new Item(Material.REDSTONE_TORCH_OFF, true);
			public static Item DiodeOn = new Item(Material.DIODE_BLOCK_ON, true);
			public static Item DiodeOff = new Item(Material.DIODE_BLOCK_OFF, true);
			public static Item ComparatorOn = new Item(Material.REDSTONE_COMPARATOR_ON, true);
			public static Item ComparatorOff = new Item(Material.REDSTONE_COMPARATOR_OFF, true);
		}

		public static class DoubleSlab
		{
			public static Item Oak = new Item(Material.WOOD_DOUBLE_STEP, true, 0);
			public static Item Spruce = new Item(Material.WOOD_DOUBLE_STEP, true, 1);
			public static Item Birch = new Item(Material.WOOD_DOUBLE_STEP, true, 2);
			public static Item Jungle = new Item(Material.WOOD_DOUBLE_STEP, true, 3);
			public static Item Stone = new Item(Material.DOUBLE_STEP, true, 0);
			public static Item Sandstone = new Item(Material.DOUBLE_STEP, true, 1);
			public static Item Plank = new Item(Material.DOUBLE_STEP, true, 2);
			public static Item Cobblestone = new Item(Material.DOUBLE_STEP, true, 3);
			public static Item Brick = new Item(Material.DOUBLE_STEP, true, 4);
			public static Item StoneBrick = new Item(Material.DOUBLE_STEP, true, 5);
			public static Item NetherBrick = new Item(Material.DOUBLE_STEP, true, 6);
			public static Item Quartz = new Item(Material.DOUBLE_STEP, true, 7);
		}
	}

	public static class Special
	{
		public static Item DragonEgg = new Item(Material.DRAGON_EGG, true);

		public static class Crafted
		{
			public static Item Map = new Item(Material.MAP, true);
			public static Item WrittenBook = new Item(Material.WRITTEN_BOOK, true);
			public static Item Firework = new Item(Material.FIREWORK, true);
			public static Item EnchantedBook = new Item(Material.ENCHANTED_BOOK, true);
		}
	}

	public static Item get(String type)
	{
		Material material = Material.getMaterial(type);
		if (material == null)
			return null;
		if (items.containsKey(material))
			return items.get(material);
		return new Item(material, true);
	}

	public static Item get(int type)
	{
		Material material = Material.getMaterial(type);
		if (material == null)
			return null;
		if (items.containsKey(material))
			return items.get(material);
		return new Item(material, true);
	}

	public Material getType()
	{
		return material;
	}

	@Override
	public boolean enchanted()
	{
		if (root || material.isBlock() || item == null)
			return false;

		return item.enchanted();
	}

	@Override
	public boolean enchanted(IEnchant enchant)
	{
		if (root || material.isBlock() || item == null)
			return false;

		return item.enchanted(enchant);
	}

	@Override
	public IEnchantable enchant(IEnchant enchant)
	{
		if (material.isBlock())
			return this;

		if (root || item == null)
			return convertToItem().enchant(enchant);

		item.enchant(enchant);
		return this;
	}

	@Override
	public IEnchantable enchant(Iterable<IEnchant> enchants)
	{
		if (material.isBlock())
			return this;

		if (root || item == null)
			return convertToItem().enchant(enchants);

		item.enchant(enchants);
		return this;
	}

	@Override
	public IEnchantable disenchant()
	{
		if (material.isBlock())
			return this;

		if (root || item == null)
			return convertToItem().disenchant();

		item.disenchant();
		return this;
	}

	@Override
	public IEnchantable disenchant(IEnchant enchant)
	{
		if (material.isBlock())
			return this;

		if (root || item == null)
			return convertToItem().disenchant(enchant);

		item.disenchant(enchant);
		return this;
	}

	@Override
	public RunsafeItemStack getItem()
	{
		return item == null ? convertToItem().getItem() : item;
	}

	private Item(Material material, boolean root)
	{
		this(material, root, 0);
	}

	private Item(Material material, boolean root, int damage)
	{
		this.material = material;
		this.root = root;
		this.damage = damage;
		item = root ? null : new RunsafeItemStack(material.getId());
		if (root)
			items.put(material, this);
	}

	private Item convertToItem()
	{
		return new Item(material, false, damage);
	}

	private static final Map<Material, Item> items = new HashMap<Material, Item>();
	private final Material material;
	private final boolean root;
	private final RunsafeItemStack item;
	private final int damage;
}
