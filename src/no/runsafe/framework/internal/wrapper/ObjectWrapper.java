package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.MinecraftServer;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.entity.IProjectileSource;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.block.*;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.block.BukkitBlockState;
import no.runsafe.framework.internal.wrapper.item.BukkitItemStack;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeTravelAgent;
import no.runsafe.framework.internal.extension.RunsafeWorld;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import no.runsafe.framework.minecraft.enchantment.RunsafeEnchantment;
import no.runsafe.framework.minecraft.entity.*;
import no.runsafe.framework.minecraft.entity.animals.*;
import no.runsafe.framework.minecraft.entity.animals.horses.*;
import no.runsafe.framework.minecraft.entity.monsters.*;
import no.runsafe.framework.minecraft.inventory.*;
import no.runsafe.framework.minecraft.item.meta.*;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;
import org.bukkit.projectiles.BlockProjectileSource;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "ChainOfInstanceofChecks", "UnnecessaryFullyQualifiedName", "OverlyComplexClass", "OverlyCoupledClass", "OverloadedVarargsMethod"})
public final class ObjectWrapper
{
	private ObjectWrapper()
	{
	}

	@Nonnull
	@SuppressWarnings("unchecked")
	public static <Wrap> List<Wrap> convert(Collection<?> toWrap)
	{
		if (toWrap == null)
			return Collections.emptyList();

		List<Wrap> results = new ArrayList<Wrap>(toWrap.size());
		for (Object item : toWrap)
		{
			if (item instanceof Metadatable)
				results.add((Wrap) convert((Metadatable) item));
			else if (item instanceof ItemStack)
				results.add((Wrap) convert((ItemStack) item));
			else if (item instanceof OfflinePlayer)
				results.add((Wrap) convert((OfflinePlayer) item));
			else if (item instanceof CraftPlayer)
				results.add((Wrap) convert((CraftPlayer) item));
		}
		return results;
	}

	@Nonnull
	public static <Wrapper extends IPlayer, Raw extends OfflinePlayer> List<Wrapper> convert(Raw... toWrap)
	{
		if (toWrap == null)
			return Collections.emptyList();

		List<Wrapper> results = new ArrayList<Wrapper>(toWrap.length);
		for (Raw item : toWrap)
			results.add((Wrapper) convert(item));
		return results;
	}

	@Nonnull
	public static <Wrapper extends IPlayer, Raw extends CraftPlayer> List<Wrapper> convert(Raw... toWrap)
	{
		if (toWrap == null)
			return Collections.emptyList();

		List<Wrapper> results = new ArrayList<Wrapper>(toWrap.length);
		for (Raw item : toWrap)
			results.add((Wrapper) convert(item));
		return results;
	}

	@Nonnull
	public static <Wrapper extends BukkitMetadata, Raw extends Metadatable> List<Wrapper> convert(Raw... toWrap)
	{
		if (toWrap == null)
			return Collections.emptyList();

		List<Wrapper> results = new ArrayList<Wrapper>(toWrap.length);
		for (Raw item : toWrap)
			results.add((Wrapper) convert(item));
		return results;
	}

	@Nonnull
	public static <Wrapper extends BukkitItemStack, Raw extends ItemStack> List<Wrapper> convert(Raw... toWrap)
	{
		if (toWrap == null)
			return Collections.emptyList();

		List<Wrapper> results = new ArrayList<Wrapper>(toWrap.length);
		for (Raw item : toWrap)
			results.add((Wrapper) convert(item));
		return results;
	}

	@Nullable
	public static RunsafeInventory convert(Inventory toWrap)
	{
		if (toWrap == null)
			return null;

		if (toWrap instanceof PlayerInventory)
			return new RunsafePlayerInventory((PlayerInventory) toWrap);

		if (toWrap instanceof CraftingInventory)
			return new RunsafeCraftingInventory((CraftingInventory) toWrap);

		if (toWrap instanceof AnvilInventory)
			return new RunsafeAnvilInventory((AnvilInventory) toWrap);

		return new RunsafeInventory(toWrap);
	}

	@Nullable
	public static RunsafeEntityEquipment convert(EntityEquipment toWrap)
	{
		if (toWrap == null)
			return null;

		return new RunsafeEntityEquipment(toWrap);
	}

	@Nullable
	public static no.runsafe.framework.minecraft.Item convert(Material toWrap)
	{
		if (toWrap == null)
			return null;
		return no.runsafe.framework.minecraft.Item.get(toWrap, (byte) 0);
	}

	@Nullable
	public static IChunk convert(Chunk toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeChunk(toWrap);
	}

	@Nullable
	public static RunsafeMaterialData convert(MaterialData toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeMaterialData(toWrap);
	}

	@Nullable
	public static IMetadata convert(Metadatable toWrap)
	{
		if (toWrap == null)
			return null;

		if (toWrap instanceof Block)
			return convert((Block) toWrap);

		if (toWrap instanceof BlockState)
			return convert((BlockState) toWrap);

		if (toWrap instanceof Entity)
			return convert((Entity) toWrap);

		if (toWrap instanceof World)
			return convert((World) toWrap);

		return new BukkitMetadata(toWrap);
	}

	@SuppressWarnings({"OverlyComplexMethod", "OverlyCoupledMethod"})
	@Nullable
	public static IBlock convert(Block toWrap)
	{
		if (toWrap == null)
			return null;

		BlockState state = toWrap.getState();
		if (state == null)
			return new RunsafeBlock(toWrap);

		if (state instanceof Chest)
			return new RunsafeChest(toWrap, (Chest) state);

		if (state instanceof BrewingStand)
			return new RunsafeBrewingStand(toWrap, (BrewingStand) state);

		if (state instanceof CreatureSpawner)
			return new RunsafeCreatureSpawner(toWrap, (CreatureSpawner) state);

		if (state instanceof Dispenser)
			return new RunsafeDispenser(toWrap, (Dispenser) state);

//		if(state instanceof DoubleChest)
//			return new RunsafeDoubleChest(toWrap);

		if (state instanceof Dropper)
			return new RunsafeDropper(toWrap, (Dropper) state);

		if (state instanceof Furnace)
			return new RunsafeFurnace(toWrap, (Furnace) state);

		if (state instanceof Hopper)
			return new RunsafeHopper(toWrap, (Hopper) state);

		if (state instanceof Jukebox)
			return new RunsafeJukebox(toWrap, (Jukebox) state);

		if (state instanceof NoteBlock)
			return new RunsafeNoteBlock(toWrap, (NoteBlock) state);

		if (state instanceof Sign)
			return new RunsafeSign(toWrap, (Sign) state);

		return new BukkitBlockState(toWrap, state);
	}

	@SuppressWarnings("OverlyComplexMethod")
	@Nullable
	public static BukkitBlockState convert(BlockState toWrap)
	{
		if (toWrap == null)
			return null;

		if (toWrap instanceof BrewingStand)
			return convert((BrewingStand) toWrap);

		if (toWrap instanceof Chest)
			return convert((Chest) toWrap);

		if (toWrap instanceof CreatureSpawner)
			return convert((CreatureSpawner) toWrap);

		if (toWrap instanceof Dispenser)
			return convert((Dispenser) toWrap);

		if (toWrap instanceof Furnace)
			return convert((Furnace) toWrap);

		if (toWrap instanceof Jukebox)
			return convert((Jukebox) toWrap);

		if (toWrap instanceof NoteBlock)
			return convert((NoteBlock) toWrap);

		if (toWrap instanceof Sign)
			return convert((Sign) toWrap);

		if (toWrap instanceof Dropper)
			return convert((Dropper) toWrap);

		return new BukkitBlockState(null, toWrap);
	}

	@Nullable
	public static RunsafeBrewingStand convert(BrewingStand toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeBrewingStand(null, toWrap);
	}

	@Nullable
	public static RunsafeChest convert(Chest toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeChest(null, toWrap);
	}

	@Nullable
	public static RunsafeDoubleChest convert(DoubleChest toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeDoubleChest(toWrap);
	}

	@Nullable
	public static RunsafeCreatureSpawner convert(CreatureSpawner toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeCreatureSpawner(null, toWrap);
	}

	@Nullable
	public static RunsafeDispenser convert(Dispenser toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeDispenser(null, toWrap);
	}

	@Nullable
	public static RunsafePlayerInventory convert(PlayerInventory toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafePlayerInventory(toWrap);
	}

	@Nullable
	public static RunsafeFurnace convert(Furnace toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeFurnace(null, toWrap);
	}

	@Nullable
	public static RunsafeJukebox convert(Jukebox toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeJukebox(null, toWrap);
	}

	@Nullable
	public static RunsafeFallingBlock convert(FallingBlock toWrap)
	{
		if (toWrap == null)
			return null;

		return new RunsafeFallingBlock(toWrap);
	}

	@Nullable
	public static RunsafeNoteBlock convert(NoteBlock toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeNoteBlock(null, toWrap);
	}

	@Nullable
	public static RunsafeSign convert(Sign toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeSign(null, toWrap);
	}

	@Nullable
	public static RunsafeEntity convert(Entity toWrap)
	{
		if (toWrap == null)
			return null;

		if (toWrap instanceof Player)
			return convert((OfflinePlayer) toWrap);

		if (toWrap instanceof Painting)
			return convert((Painting) toWrap);

		if (toWrap instanceof ItemFrame)
			return convert((ItemFrame) toWrap);

		if (toWrap instanceof org.bukkit.entity.LivingEntity)
			return convert((org.bukkit.entity.LivingEntity) toWrap);

		if (toWrap instanceof Projectile)
			return convert((Projectile) toWrap);

		if (toWrap instanceof Item)
			return convert((Item) toWrap);

		if (toWrap instanceof TNTPrimed)
			return convert((TNTPrimed) toWrap);

		if (toWrap instanceof Explosive)
			return convert((Explosive) toWrap);

		if (toWrap instanceof Minecart)
			return convert((Minecart) toWrap);

		return new RunsafeEntity(toWrap);
	}

	@Nullable
	public static RunsafePlayer convert(OfflinePlayer toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafePlayer(toWrap);
	}

	@Nullable
	public static RunsafePlayer convert(CraftPlayer toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafePlayer(toWrap);
	}

	@Nullable
	public static RunsafePlayer convert(HumanEntity toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafePlayer((OfflinePlayer) toWrap);
	}

	@Nullable
	public static RunsafePainting convert(Painting toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafePainting(toWrap);
	}

	@Nullable
	public static RunsafeItemFrame convert(ItemFrame toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeItemFrame(toWrap);
	}

	@Nullable
	public static RunsafeLivingEntity convert(org.bukkit.entity.LivingEntity toWrap)
	{
		if (toWrap == null)
			return null;

		if (toWrap instanceof Creature)
			return convert((Creature) toWrap);

		if (toWrap instanceof Bat)
			return new RunsafeBat((Bat) toWrap);

		if (toWrap instanceof Slime)
			return new RunsafeSlime((Slime) toWrap);

		if (toWrap instanceof ArmorStand)
			return new RunsafeArmourStand((ArmorStand) toWrap);

		if (toWrap instanceof EnderDragon)
			return new RunsafeEnderDragon((EnderDragon) toWrap);

		return new RunsafeLivingEntity(toWrap);
	}

	@Nullable
	public static RunsafeCreature convert(org.bukkit.entity.Creature toWrap)
	{
		if (toWrap instanceof Monster)
			return convert((Monster) toWrap);

		if (toWrap instanceof Horse)
			return convert((Horse) toWrap);

		if (toWrap instanceof Wolf)
			return new RunsafeWolf((Wolf) toWrap);

		if (toWrap instanceof Ocelot)
			return new RunsafeOcelot((Ocelot) toWrap);

		if (toWrap instanceof Pig)
			return new RunsafePig((Pig) toWrap);

		if (toWrap instanceof Cow)
			return new RunsafeCow((Cow) toWrap);

		if (toWrap instanceof Chicken)
			return new RunsafeChicken((Chicken) toWrap);

		if (toWrap instanceof Sheep)
			return new RunsafeSheep((Sheep) toWrap);

		if (toWrap instanceof Villager)
			return new RunsafeVillager((Villager) toWrap);

		return new RunsafeCreature(toWrap);
	}

	@Nullable
	public static RunsafeMonster convert(org.bukkit.entity.Monster toWrap)
	{
		if (toWrap instanceof PigZombie)
			return new RunsafePigZombie((PigZombie) toWrap);

		if (toWrap instanceof Zombie)
			return new RunsafeZombie((Zombie) toWrap);

		if (toWrap instanceof Silverfish)
			return new RunsafeSilverfish((Silverfish) toWrap);

		return new RunsafeMonster(toWrap);
	}

	@Nullable
	public static RunsafeHorse convert(Horse toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeNormalHorse(toWrap);
	}

	@Nullable
	public static RunsafeBlockProjectileSource convert(org.bukkit.projectiles.BlockProjectileSource toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeBlockProjectileSource(toWrap);
	}

	@Nullable
	public static RunsafeProjectile convert(Projectile toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeProjectile(toWrap);
	}

	@Nullable
	public static RunsafeFish convert(Fish toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeFish(toWrap);
	}

	@Nullable
	public static RunsafeWorld convert(World toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeWorld(toWrap);
	}

	@Nullable
	public static ILocation convert(Location toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeLocation(toWrap);
	}

	@Nullable
	public static RunsafeItem convert(Item toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeItem(toWrap);
	}

	@Nullable
	public static RunsafeExplosive convert(Explosive toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeExplosive(toWrap);
	}

	@Nullable
	public static RunsafeMinecart convert(Minecart toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeMinecart(toWrap);
	}

	@Nullable
	public static RunsafeTNTPrimed convert(TNTPrimed toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeTNTPrimed(toWrap);
	}

	@Nullable
	public static RunsafeMeta convert(ItemStack toWrap)
	{
		if (toWrap == null)
			return null;
		ItemMeta meta = toWrap.getItemMeta();
		if (meta instanceof BookMeta)
			return new RunsafeBook(toWrap);
		if (meta instanceof EnchantmentStorageMeta)
			return new RunsafeEnchantmentStorage(toWrap);
		if (meta instanceof FireworkMeta)
			return new RunsafeFirework(toWrap);
		if (meta instanceof LeatherArmorMeta)
			return new RunsafeLeatherArmor(toWrap);
		if (meta instanceof MapMeta)
			return new RunsafeMap(toWrap);
		if (meta instanceof PotionMeta)
			return new RunsafePotion(toWrap);
		if (meta instanceof SkullMeta)
			return new RunsafeSkull(toWrap);
		return new RunsafeMeta(toWrap);
	}

	@Nullable
	public static RunsafeEnchantment convert(Enchantment toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeEnchantment(toWrap);
	}

	public static RunsafeInventoryType convert(InventoryType toWrap)
	{
		return RunsafeInventoryType.valueOf(toWrap.name());
	}

	@Nullable
	public static RunsafeInventoryView convert(InventoryView toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeInventoryView(toWrap);
	}

	@Nullable
	public static RunsafeTravelAgent convert(TravelAgent toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeTravelAgent(toWrap);
	}

	@Nullable
	public static RunsafeHopper convert(Hopper toWrap)
	{
		if (toWrap == null)
			return null;

		return new RunsafeHopper(null, toWrap);
	}

	@Nullable
	public static RunsafeDropper convert(Dropper toWrap)
	{
		if (toWrap == null)
			return null;
		return new RunsafeDropper(null, toWrap);
	}

	@Nullable
	public static IProjectileSource convert(org.bukkit.projectiles.ProjectileSource toWrap)
	{
		if (toWrap == null)
			return null;
		if (toWrap instanceof BlockProjectileSource)
			return convert((BlockProjectileSource) toWrap);
		if (toWrap instanceof org.bukkit.entity.LivingEntity)
			return convert((org.bukkit.entity.LivingEntity) toWrap);
		return null;
	}

	@Nullable
	public static IInventoryHolder convert(InventoryHolder toWrap)
	{
		if (toWrap == null)
			return null;
		if (toWrap instanceof Hopper)
			return convert((Hopper) toWrap);
		if (toWrap instanceof BrewingStand)
			return convert((BrewingStand) toWrap);
		if (toWrap instanceof Chest)
			return convert((Chest) toWrap);
		if (toWrap instanceof Dispenser)
			return convert((Dispenser) toWrap);
		if (toWrap instanceof Furnace)
			return convert((Furnace) toWrap);
		if (toWrap instanceof DoubleChest)
			return convert((DoubleChest) toWrap);
		if (toWrap instanceof Player)
			return convert((OfflinePlayer) toWrap);
		if (toWrap instanceof Dropper)
			return convert((Dropper) toWrap);
		return null;
	}

	@Nullable
	public static IAnimalTamer convert(AnimalTamer toWrap)
	{
		if (toWrap == null)
			return null;

		if (toWrap instanceof OfflinePlayer)
			return convert((OfflinePlayer) toWrap);

		if (toWrap instanceof HumanEntity)
			return convert((HumanEntity) toWrap);

		return null;
	}

	@Nullable
	public static RunsafeEntityType convert(org.bukkit.entity.EntityType type)
	{
		if (type == null)
			return null;
		return no.runsafe.framework.minecraft.entity.EntityType.convert(type);
	}

	@Nullable
	public static RunsafeRecipe convert(Recipe toWrap)
	{
		if (toWrap == null)
			return null;

		return new RunsafeRecipe(toWrap);
	}

	public static CraftServer convert(MinecraftServer server)
	{
		return new CraftServer(server, server.getPlayerList());
	}

	public static RunsafeMeta convert(net.minecraft.server.v1_12_R1.ItemStack raw)
	{
		return new RunsafeMeta(CraftItemStack.asCraftMirror(raw));
	}

	public static IPlayer convert(EntityPlayer player)
	{
		return convert((OfflinePlayer) new CraftPlayer(convert(player.server), player));
	}
}
