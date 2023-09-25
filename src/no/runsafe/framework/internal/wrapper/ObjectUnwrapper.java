package no.runsafe.framework.internal.wrapper;

import net.minecraft.server.v1_12_R1.*;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftProjectile;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftMagicNumbers;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import javax.annotation.Nullable;

@SuppressWarnings("OverloadedMethodsWithSameNumberOfParameters")
public final class ObjectUnwrapper
{
	private ObjectUnwrapper()
	{
	}

	@Nullable
	public static EntityPlayer getMinecraft(IPlayer player)
	{
		Player bukkit = convert(player);
		if (bukkit == null)
			return null;
		return ((CraftPlayer) bukkit).getHandle();
	}

	@Nullable
	public static Block getMinecraft(IBlock block)
	{
		org.bukkit.block.Block bukkitBlock = convert(block);
		if (bukkitBlock == null)
			return null;

		return CraftMagicNumbers.getBlock((CraftBlock) bukkitBlock);
	}

	@Nullable
	public static Entity getMinecraft(IEntity entity)
	{
		org.bukkit.entity.Entity bukkit = convert(entity);
		if (bukkit == null)
			return null;
		return ((CraftEntity) bukkit).getHandle();
	}

	@Nullable
	public static EntityProjectile getMinecraft(RunsafeProjectile projectile)
	{
		Projectile bukkit = (Projectile) convert(projectile);
		if (bukkit == null)
			return null;
		return ((CraftProjectile) bukkit).getHandle();
	}

	@Nullable
	public static World getMinecraft(IWorld world)
	{
		org.bukkit.World bukkitWorld = convert(world);
		return ((CraftWorld) bukkitWorld).getHandle();
	}

	@Nullable
	public static ItemStack getMinecraft(RunsafeMeta itemStack)
	{
		org.bukkit.inventory.ItemStack stack = convert(itemStack);
		return CraftItemStack.asNMSCopy(stack);
	}

	@SuppressWarnings("unchecked")
	@Nullable
	public static <T> T convert(Object wrapper)
	{
		return convert((IWrapper<T>) wrapper);
	}

	public static OfflinePlayer convert(BukkitPlayer player)
	{
		return player.getBasePlayer();
	}

	@Nullable
	public static <T> T convert(IWrapper<T> wrapper)
	{
		return wrapper.getRaw();
	}
}
