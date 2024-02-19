package no.runsafe.framework.internal;

import no.runsafe.framework.exceptions.UnknownMaterialException;
import org.bukkit.Material;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("MagicNumber")
@Deprecated
public final class LegacyMaterial
{
	public static Material getById(int id)
	{
		if (legacyIdMap.containsKey(id))
			return legacyIdMap.get(id);

		throw new UnknownMaterialException(id);
	}

	public static Integer getIdOf(Material material)
	{
		if (legacyMaterialMap.containsKey(material))
			return legacyMaterialMap.get(material);

		return -1;
	}

	static
	{
		legacyIdMap = new ConcurrentHashMap<>();
		legacyMaterialMap = new ConcurrentHashMap<>();

		Map(0, Material.AIR);
		Map(1, Material.STONE);
		Map(2, Material.GRASS);
		Map(3, Material.DIRT);
		Map(4, Material.COBBLESTONE);
		Map(5, Material.WOOD);
		Map(6, Material.SAPLING);
		Map(7, Material.BEDROCK);
		Map(8, Material.WATER);
		Map(9, Material.STATIONARY_WATER);
		Map(10, Material.LAVA);
		Map(11, Material.STATIONARY_LAVA);
		Map(12, Material.SAND);
		Map(13, Material.GRAVEL);
		Map(14, Material.GOLD_ORE);
		Map(15, Material.IRON_ORE);
		Map(16, Material.COAL_ORE);
		Map(17, Material.LOG);
		Map(18, Material.LEAVES);
		Map(19, Material.SPONGE);
		Map(20, Material.GLASS);
		Map(21, Material.LAPIS_ORE);
		Map(22, Material.LAPIS_BLOCK);
		Map(23, Material.DISPENSER);
		Map(24, Material.SANDSTONE);
		Map(25, Material.NOTE_BLOCK);
		Map(26, Material.BED_BLOCK);
		Map(27, Material.POWERED_RAIL);
		Map(28, Material.DETECTOR_RAIL);
		Map(29, Material.PISTON_STICKY_BASE);
		Map(30, Material.WEB);
		Map(31, Material.LONG_GRASS);
		Map(32, Material.DEAD_BUSH);
		Map(33, Material.PISTON_BASE);
		Map(34, Material.PISTON_EXTENSION);
		Map(35, Material.WOOL);
		Map(36, Material.PISTON_MOVING_PIECE);
		Map(37, Material.YELLOW_FLOWER);
		Map(38, Material.RED_ROSE);
		Map(39, Material.BROWN_MUSHROOM);
		Map(40, Material.RED_MUSHROOM);
		Map(41, Material.GOLD_BLOCK);
		Map(42, Material.IRON_BLOCK);
		Map(43, Material.DOUBLE_STEP);
		Map(44, Material.STEP);
		Map(45, Material.BRICK);
		Map(46, Material.TNT);
		Map(47, Material.BOOKSHELF);
		Map(48, Material.MOSSY_COBBLESTONE);
		Map(49, Material.OBSIDIAN);
		Map(50, Material.TORCH);
		Map(51, Material.FIRE);
		Map(52, Material.MOB_SPAWNER);
		Map(53, Material.WOOD_STAIRS);
		Map(54, Material.CHEST);
		Map(55, Material.REDSTONE_WIRE);
		Map(56, Material.DIAMOND_ORE);
		Map(57, Material.DIAMOND_BLOCK);
		Map(58, Material.WORKBENCH);
		Map(59, Material.CROPS);
		Map(60, Material.SOIL);
		Map(61, Material.FURNACE);
		Map(62, Material.BURNING_FURNACE);
		Map(63, Material.SIGN_POST);
		Map(64, Material.WOODEN_DOOR);
		Map(65, Material.LADDER);
		Map(66, Material.RAILS);
		Map(67, Material.COBBLESTONE_STAIRS);
		Map(68, Material.WALL_SIGN);
		Map(69, Material.LEVER);
		Map(70, Material.STONE_PLATE);
		Map(71, Material.IRON_DOOR_BLOCK);
		Map(72, Material.WOOD_PLATE);
		Map(73, Material.REDSTONE_ORE);
		Map(74, Material.GLOWING_REDSTONE_ORE);
		Map(75, Material.REDSTONE_TORCH_OFF);
		Map(76, Material.REDSTONE_TORCH_ON);
		Map(77, Material.STONE_BUTTON);
		Map(78, Material.SNOW);
		Map(79, Material.ICE);
		Map(80, Material.SNOW_BLOCK);
		Map(81, Material.CACTUS);
		Map(82, Material.CLAY);
		Map(83, Material.SUGAR_CANE_BLOCK);
		Map(84, Material.JUKEBOX);
		Map(85, Material.FENCE);
		Map(86, Material.PUMPKIN);
		Map(87, Material.NETHERRACK);
		Map(88, Material.SOUL_SAND);
		Map(89, Material.GLOWSTONE);
		Map(90, Material.PORTAL);
		Map(91, Material.JACK_O_LANTERN);
		Map(92, Material.CAKE_BLOCK);
		Map(93, Material.DIODE_BLOCK_OFF);
		Map(94, Material.DIODE_BLOCK_ON);
		Map(95, Material.TRAPPED_CHEST);
		Map(96, Material.TRAP_DOOR);
		Map(97, Material.MONSTER_EGGS);
		Map(98, Material.SMOOTH_BRICK);
		Map(99, Material.HUGE_MUSHROOM_1);
		Map(100, Material.HUGE_MUSHROOM_2);
		Map(101, Material.IRON_FENCE);
		Map(102, Material.THIN_GLASS);
		Map(103, Material.MELON_BLOCK);
		Map(104, Material.PUMPKIN_STEM);
		Map(105, Material.MELON_STEM);
		Map(106, Material.VINE);
		Map(107, Material.FENCE_GATE);
		Map(108, Material.BRICK_STAIRS);
		Map(109, Material.SMOOTH_STAIRS);
		Map(110, Material.MYCEL);
		Map(111, Material.WATER_LILY);
		Map(112, Material.NETHER_BRICK);
		Map(113, Material.NETHER_FENCE);
		Map(114, Material.NETHER_BRICK_STAIRS);
		Map(115, Material.NETHER_WARTS);
		Map(116, Material.ENCHANTMENT_TABLE);
		Map(117, Material.BREWING_STAND);
		Map(118, Material.CAULDRON);
		Map(119, Material.ENDER_PORTAL);
		Map(120, Material.ENDER_PORTAL_FRAME);
		Map(121, Material.ENDER_STONE);
		Map(122, Material.DRAGON_EGG);
		Map(123, Material.REDSTONE_LAMP_OFF);
		Map(124, Material.REDSTONE_LAMP_ON);
		Map(125, Material.WOOD_DOUBLE_STEP);
		Map(126, Material.WOOD_STEP);
		Map(127, Material.COCOA);
		Map(128, Material.SANDSTONE_STAIRS);
		Map(129, Material.EMERALD_ORE);
		Map(130, Material.ENDER_CHEST);
		Map(131, Material.TRIPWIRE_HOOK);
		Map(132, Material.TRIPWIRE);
		Map(133, Material.EMERALD_BLOCK);
		Map(134, Material.SPRUCE_WOOD_STAIRS);
		Map(135, Material.BIRCH_WOOD_STAIRS);
		Map(136, Material.JUNGLE_WOOD_STAIRS);
		Map(137, Material.COMMAND);
		Map(138, Material.BEACON);
		Map(139, Material.COBBLE_WALL);
		Map(140, Material.FLOWER_POT);
		Map(141, Material.CARROT);
		Map(142, Material.POTATO);
		Map(143, Material.WOOD_BUTTON);
		Map(144, Material.SKULL);
		Map(145, Material.ANVIL);
		Map(146, Material.TRAPPED_CHEST);
		Map(147, Material.GOLD_PLATE);
		Map(148, Material.IRON_PLATE);
		Map(149, Material.REDSTONE_COMPARATOR_OFF);
		Map(150, Material.REDSTONE_COMPARATOR_ON);
		Map(151, Material.DAYLIGHT_DETECTOR);
		Map(152, Material.REDSTONE_BLOCK);
		Map(153, Material.QUARTZ_ORE);
		Map(154, Material.HOPPER);
		Map(155, Material.QUARTZ_BLOCK);
		Map(156, Material.QUARTZ_STAIRS);
		Map(157, Material.ACTIVATOR_RAIL);
		Map(158, Material.DROPPER);
		Map(159, Material.STAINED_CLAY);
		Map(160, Material.STAINED_GLASS_PANE);
		Map(161, Material.LEAVES_2);
		Map(162, Material.LOG_2);
		Map(163, Material.ACACIA_STAIRS);
		Map(164, Material.DARK_OAK_STAIRS);
		Map(165, Material.SLIME_BLOCK);
		Map(166, Material.BARRIER);
		Map(167, Material.IRON_TRAPDOOR);
		Map(168, Material.PRISMARINE);
		Map(169, Material.SEA_LANTERN);
		Map(170, Material.HAY_BLOCK);
		Map(171, Material.CARPET);
		Map(172, Material.HARD_CLAY);
		Map(173, Material.COAL_BLOCK);
		Map(174, Material.PACKED_ICE);
		Map(175, Material.DOUBLE_PLANT);
		Map(176, Material.STANDING_BANNER);
		Map(177, Material.WALL_BANNER);
		Map(178, Material.DAYLIGHT_DETECTOR_INVERTED);
		Map(179, Material.RED_SANDSTONE);
		Map(180, Material.RED_SANDSTONE_STAIRS);
		Map(181, Material.DOUBLE_STONE_SLAB2);
		Map(182, Material.STONE_SLAB2);
		Map(183, Material.SPRUCE_FENCE_GATE);
		Map(184, Material.BIRCH_FENCE_GATE);
		Map(185, Material.JUNGLE_FENCE_GATE);
		Map(186, Material.DARK_OAK_FENCE_GATE);
		Map(187, Material.ACACIA_FENCE_GATE);
		Map(188, Material.SPRUCE_FENCE);
		Map(189, Material.BIRCH_FENCE);
		Map(190, Material.JUNGLE_FENCE);
		Map(191, Material.DARK_OAK_FENCE);
		Map(192, Material.ACACIA_FENCE);
		Map(193, Material.SPRUCE_DOOR);
		Map(194, Material.BIRCH_DOOR);
		Map(195, Material.JUNGLE_DOOR);
		Map(196, Material.ACACIA_DOOR);
		Map(197, Material.DARK_OAK_DOOR);
		Map(198, Material.END_ROD);
		Map(199, Material.CHORUS_PLANT);
		Map(200, Material.CHORUS_FLOWER);
		Map(201, Material.PURPUR_BLOCK);
		Map(202, Material.PURPUR_PILLAR);
		Map(203, Material.PURPUR_STAIRS);
		Map(204, Material.PURPUR_DOUBLE_SLAB);
		Map(205, Material.PURPUR_SLAB);
		Map(206, Material.END_BRICKS);
		Map(207, Material.BEETROOT_BLOCK);
		Map(208, Material.GRASS_PATH);
		Map(209, Material.END_GATEWAY);
		Map(210, Material.COMMAND_REPEATING);
		Map(211, Material.COMMAND_CHAIN);
		Map(212, Material.FROSTED_ICE);
		Map(213, Material.MAGMA);
		Map(214, Material.NETHER_WART_BLOCK);
		Map(215, Material.RED_NETHER_BRICK);
		Map(216, Material.BONE_BLOCK);
		Map(217, Material.STRUCTURE_VOID);
		Map(218, Material.OBSERVER);
		Map(219, Material.WHITE_SHULKER_BOX);
		Map(220, Material.ORANGE_SHULKER_BOX);
		Map(221, Material.MAGENTA_SHULKER_BOX);
		Map(222, Material.LIGHT_BLUE_SHULKER_BOX);
		Map(223, Material.YELLOW_SHULKER_BOX);
		Map(224, Material.LIME_SHULKER_BOX);
		Map(225, Material.PINK_SHULKER_BOX);
		Map(226, Material.GRAY_SHULKER_BOX);
		Map(227, Material.SILVER_SHULKER_BOX);
		Map(228, Material.CYAN_SHULKER_BOX);
		Map(229, Material.PURPLE_SHULKER_BOX);
		Map(230, Material.BLUE_SHULKER_BOX);
		Map(231, Material.BROWN_SHULKER_BOX);
		Map(232, Material.GREEN_SHULKER_BOX);
		Map(233, Material.RED_SHULKER_BOX);
		Map(234, Material.BLACK_SHULKER_BOX);
		Map(235, Material.WHITE_GLAZED_TERRACOTTA);
		Map(236, Material.ORANGE_GLAZED_TERRACOTTA);
		Map(237, Material.MAGENTA_GLAZED_TERRACOTTA);
		Map(238, Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
		Map(239, Material.YELLOW_GLAZED_TERRACOTTA);
		Map(240, Material.LIME_GLAZED_TERRACOTTA);
		Map(241, Material.PINK_GLAZED_TERRACOTTA);
		Map(242, Material.GRAY_GLAZED_TERRACOTTA);
		Map(243, Material.SILVER_GLAZED_TERRACOTTA);
		Map(244, Material.CYAN_GLAZED_TERRACOTTA);
		Map(245, Material.PURPLE_GLAZED_TERRACOTTA);
		Map(246, Material.BLUE_GLAZED_TERRACOTTA);
		Map(247, Material.BROWN_GLAZED_TERRACOTTA);
		Map(248, Material.GREEN_GLAZED_TERRACOTTA);
		Map(249, Material.RED_GLAZED_TERRACOTTA);
		Map(250, Material.BLACK_GLAZED_TERRACOTTA);
		Map(251, Material.CONCRETE);
		Map(252, Material.CONCRETE_POWDER);
		Map(256, Material.IRON_SPADE);
		Map(257, Material.IRON_PICKAXE);
		Map(258, Material.IRON_AXE);
		Map(259, Material.FLINT_AND_STEEL);
		Map(260, Material.APPLE);
		Map(261, Material.BOW);
		Map(262, Material.ARROW);
		Map(263, Material.COAL);
		Map(264, Material.DIAMOND);
		Map(265, Material.IRON_INGOT);
		Map(266, Material.GOLD_INGOT);
		Map(267, Material.IRON_SWORD);
		Map(268, Material.WOOD_SWORD);
		Map(269, Material.WOOD_SPADE);
		Map(270, Material.WOOD_PICKAXE);
		Map(271, Material.WOOD_AXE);
		Map(272, Material.STONE_SWORD);
		Map(273, Material.STONE_SPADE);
		Map(274, Material.STONE_PICKAXE);
		Map(275, Material.STONE_AXE);
		Map(276, Material.DIAMOND_SWORD);
		Map(277, Material.DIAMOND_SPADE);
		Map(278, Material.DIAMOND_PICKAXE);
		Map(279, Material.DIAMOND_AXE);
		Map(280, Material.STICK);
		Map(281, Material.BOWL);
		Map(282, Material.MUSHROOM_SOUP);
		Map(283, Material.GOLD_SWORD);
		Map(284, Material.GOLD_SPADE);
		Map(285, Material.GOLD_PICKAXE);
		Map(286, Material.GOLD_AXE);
		Map(287, Material.STRING);
		Map(288, Material.FEATHER);
		Map(289, Material.SULPHUR);
		Map(290, Material.WOOD_HOE);
		Map(291, Material.STONE_HOE);
		Map(292, Material.IRON_HOE);
		Map(293, Material.DIAMOND_HOE);
		Map(294, Material.GOLD_HOE);
		Map(295, Material.SEEDS);
		Map(296, Material.WHEAT);
		Map(297, Material.BREAD);
		Map(298, Material.LEATHER_HELMET);
		Map(299, Material.LEATHER_CHESTPLATE);
		Map(300, Material.LEATHER_LEGGINGS);
		Map(301, Material.LEATHER_BOOTS);
		Map(302, Material.CHAINMAIL_HELMET);
		Map(303, Material.CHAINMAIL_CHESTPLATE);
		Map(304, Material.CHAINMAIL_LEGGINGS);
		Map(305, Material.CHAINMAIL_BOOTS);
		Map(306, Material.IRON_HELMET);
		Map(307, Material.IRON_CHESTPLATE);
		Map(308, Material.IRON_LEGGINGS);
		Map(309, Material.IRON_BOOTS);
		Map(310, Material.DIAMOND_HELMET);
		Map(311, Material.DIAMOND_CHESTPLATE);
		Map(312, Material.DIAMOND_LEGGINGS);
		Map(313, Material.DIAMOND_BOOTS);
		Map(314, Material.GOLD_HELMET);
		Map(315, Material.GOLD_CHESTPLATE);
		Map(316, Material.GOLD_LEGGINGS);
		Map(317, Material.GOLD_BOOTS);
		Map(318, Material.FLINT);
		Map(319, Material.PORK);
		Map(320, Material.GRILLED_PORK);
		Map(321, Material.PAINTING);
		Map(322, Material.GOLDEN_APPLE);
		Map(323, Material.SIGN);
		Map(324, Material.WOOD_DOOR);
		Map(325, Material.BUCKET);
		Map(326, Material.WATER_BUCKET);
		Map(327, Material.LAVA_BUCKET);
		Map(328, Material.MINECART);
		Map(329, Material.SADDLE);
		Map(330, Material.IRON_DOOR);
		Map(331, Material.REDSTONE);
		Map(332, Material.SNOW_BALL);
		Map(333, Material.BOAT);
		Map(334, Material.LEATHER);
		Map(335, Material.MILK_BUCKET);
		Map(336, Material.CLAY_BRICK);
		Map(337, Material.CLAY_BALL);
		Map(338, Material.SUGAR_CANE);
		Map(339, Material.PAPER);
		Map(340, Material.BOOK);
		Map(341, Material.SLIME_BALL);
		Map(342, Material.STORAGE_MINECART);
		Map(343, Material.POWERED_MINECART);
		Map(344, Material.EGG);
		Map(345, Material.COMPASS);
		Map(346, Material.FISHING_ROD);
		Map(347, Material.WATCH);
		Map(348, Material.GLOWSTONE_DUST);
		Map(349, Material.RAW_FISH);
		Map(350, Material.COOKED_FISH);
		Map(351, Material.INK_SACK);
		Map(352, Material.BONE);
		Map(353, Material.SUGAR);
		Map(354, Material.CAKE);
		Map(355, Material.BED);
		Map(356, Material.DIODE);
		Map(357, Material.COOKIE);
		Map(358, Material.MAP);
		Map(359, Material.SHEARS);
		Map(360, Material.MELON);
		Map(361, Material.PUMPKIN_SEEDS);
		Map(362, Material.MELON_SEEDS);
		Map(363, Material.RAW_BEEF);
		Map(364, Material.COOKED_BEEF);
		Map(365, Material.RAW_CHICKEN);
		Map(366, Material.COOKED_CHICKEN);
		Map(367, Material.ROTTEN_FLESH);
		Map(368, Material.ENDER_PEARL);
		Map(369, Material.BLAZE_ROD);
		Map(370, Material.GHAST_TEAR);
		Map(371, Material.GOLD_NUGGET);
		Map(372, Material.NETHER_STALK);
		Map(373, Material.POTION);
		Map(374, Material.GLASS_BOTTLE);
		Map(375, Material.SPIDER_EYE);
		Map(376, Material.FERMENTED_SPIDER_EYE);
		Map(377, Material.BLAZE_POWDER);
		Map(378, Material.MAGMA_CREAM);
		Map(379, Material.BREWING_STAND_ITEM);
		Map(380, Material.CAULDRON_ITEM);
		Map(381, Material.EYE_OF_ENDER);
		Map(382, Material.SPECKLED_MELON);
		Map(383, Material.MONSTER_EGG);
		Map(384, Material.EXP_BOTTLE);
		Map(385, Material.FIREBALL);
		Map(386, Material.BOOK_AND_QUILL);
		Map(387, Material.WRITTEN_BOOK);
		Map(388, Material.EMERALD);
		Map(389, Material.ITEM_FRAME);
		Map(390, Material.FLOWER_POT_ITEM);
		Map(391, Material.CARROT_ITEM);
		Map(392, Material.POTATO_ITEM);
		Map(393, Material.BAKED_POTATO);
		Map(394, Material.POISONOUS_POTATO);
		Map(395, Material.EMPTY_MAP);
		Map(396, Material.GOLDEN_CARROT);
		Map(397, Material.SKULL_ITEM);
		Map(398, Material.CARROT_STICK);
		Map(399, Material.NETHER_STAR);
		Map(400, Material.PUMPKIN_PIE);
		Map(401, Material.FIREWORK);
		Map(402, Material.FIREWORK_CHARGE);
		Map(403, Material.ENCHANTED_BOOK);
		Map(404, Material.REDSTONE_COMPARATOR);
		Map(405, Material.NETHER_BRICK_ITEM);
		Map(406, Material.QUARTZ);
		Map(407, Material.EXPLOSIVE_MINECART);
		Map(408, Material.HOPPER_MINECART);
		Map(417, Material.IRON_BARDING);
		Map(418, Material.GOLD_BARDING);
		Map(419, Material.DIAMOND_BARDING);
		Map(420, Material.LEASH);
		Map(421, Material.NAME_TAG);
		Map(422, Material.COMMAND_MINECART);
		Map(423, Material.MUTTON);
		Map(424, Material.COOKED_MUTTON);
		Map(425, Material.BANNER);
		Map(426, Material.END_CRYSTAL);
		Map(427, Material.SPRUCE_DOOR_ITEM);
		Map(428, Material.BIRCH_DOOR_ITEM);
		Map(429, Material.JUNGLE_DOOR_ITEM);
		Map(430, Material.ACACIA_DOOR_ITEM);
		Map(431, Material.DARK_OAK_DOOR_ITEM);
		Map(432, Material.CHORUS_FRUIT);
		Map(433, Material.CHORUS_FRUIT_POPPED);
		Map(434, Material.BEETROOT);
		Map(435, Material.BEETROOT_SEEDS);
		Map(436, Material.BEETROOT_SOUP);
		Map(437, Material.DRAGONS_BREATH);
		Map(438, Material.SPLASH_POTION);
		Map(439, Material.SPECTRAL_ARROW);
		Map(440, Material.TIPPED_ARROW);
		Map(441, Material.LINGERING_POTION);
		Map(442, Material.SHIELD);
		Map(443, Material.ELYTRA);
		Map(444, Material.BOAT_SPRUCE);
		Map(445, Material.BOAT_BIRCH);
		Map(446, Material.BOAT_JUNGLE);
		Map(447, Material.BOAT_ACACIA);
		Map(448, Material.BOAT_DARK_OAK);
		Map(449, Material.TOTEM);
		Map(450, Material.SHULKER_SHELL);
		Map(452, Material.IRON_NUGGET);
		Map(453, Material.KNOWLEDGE_BOOK);
		Map(2256, Material.GOLD_RECORD);
		Map(2257, Material.GREEN_RECORD);
		Map(2258, Material.RECORD_3);
		Map(2259, Material.RECORD_4);
		Map(2260, Material.RECORD_5);
		Map(2261, Material.RECORD_6);
		Map(2262, Material.RECORD_7);
		Map(2263, Material.RECORD_8);
		Map(2264, Material.RECORD_9);
		Map(2265, Material.RECORD_10);
		Map(2266, Material.RECORD_11);
		Map(2267, Material.RECORD_12);
	}

	private LegacyMaterial()
	{
	}

	private static void Map(int legacyId, Material material)
	{
		legacyIdMap.put(legacyId, material);
		legacyMaterialMap.put(material, legacyId);
	}

	private static final Map<Integer, Material> legacyIdMap;
	private static final Map<Material, Integer> legacyMaterialMap;
}
