package no.runsafe.framework.server;

import no.runsafe.framework.server.block.*;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.entity.RunsafeLivingEntity;
import no.runsafe.framework.server.entity.RunsafePainting;
import no.runsafe.framework.server.entity.RunsafePlayer;
import no.runsafe.framework.server.metadata.RunsafeMetadata;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.metadata.Metadatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectWrapper
{
	@SuppressWarnings("unchecked")
	public static <Wrapper extends RunsafeMetadata> List<Wrapper> convert(List<? extends Metadatable> toWrap)
	{
		ArrayList<Wrapper> results = new ArrayList<Wrapper>();
		for (Metadatable item : toWrap)
		{
			results.add((Wrapper) convert(item));
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public static <Wrapper extends RunsafeMetadata, Raw extends Metadatable> List<Wrapper> convert(Raw[] toWrap)
	{
		ArrayList<Wrapper> results = new ArrayList<Wrapper>();
		for (Raw item : toWrap)
		{
			results.add((Wrapper) convert(item));
		}
		return results;
	}

	public static List<RunsafePlayer> convert(OfflinePlayer[] toWrap)
	{
		ArrayList<RunsafePlayer> results = new ArrayList<RunsafePlayer>();
		for(OfflinePlayer player : toWrap)
			results.add(new RunsafePlayer(player));
		return results;
	}

	public static List<RunsafePlayer> convert(Set<? extends OfflinePlayer> toWrap)
	{
		ArrayList<RunsafePlayer> results = new ArrayList<RunsafePlayer>();
		for(OfflinePlayer player : toWrap)
			results.add(new RunsafePlayer(player));
		return results;
	}

	public static RunsafeMetadata convert(Metadatable toWrap)
	{
		if (toWrap instanceof Block)
			return convert((Block) toWrap);

		if (toWrap instanceof BlockState)
			return convert((BlockState) toWrap);

		if (toWrap instanceof Entity)
			return convert((Entity) toWrap);

		if (toWrap instanceof World)
			return convert((World) toWrap);

		return new RunsafeMetadata(toWrap);
	}

	public static RunsafeBlock convert(Block toWrap)
	{
		return new RunsafeBlock(toWrap);
	}

	public static RunsafeBlockState convert(BlockState toWrap)
	{
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

		return new RunsafeBlockState(toWrap);
	}

	public static RunsafeBrewingStand convert(BrewingStand toWrap)
	{
		return new RunsafeBrewingStand(toWrap);
	}

	public static RunsafeChest convert(Chest toWrap)
	{
		return new RunsafeChest(toWrap);
	}

	public static RunsafeCreatureSpawner convert(CreatureSpawner toWrap)
	{
		return new RunsafeCreatureSpawner(toWrap);
	}

	public static RunsafeDispenser convert(Dispenser toWrap)
	{
		return new RunsafeDispenser(toWrap);
	}

	public static RunsafeFurnace convert(Furnace toWrap)
	{
		return new RunsafeFurnace(toWrap);
	}

	public static RunsafeJukebox convert(Jukebox toWrap)
	{
		return new RunsafeJukebox(toWrap);
	}

	public static RunsafeNoteBlock convert(NoteBlock toWrap)
	{
		return new RunsafeNoteBlock(toWrap);
	}

	public static RunsafeSign convert(Sign toWrap)
	{
		return new RunsafeSign(toWrap);
	}

	public static RunsafeEntity convert(Entity toWrap)
	{
		if (toWrap instanceof Player)
			return convert((Player) toWrap);

		if (toWrap instanceof Painting)
			return convert((Painting) toWrap);

		if (toWrap instanceof LivingEntity)
			return convert((LivingEntity) toWrap);

		return new RunsafeEntity(toWrap);
	}

	public static RunsafePlayer convert(Player toWrap)
	{
		return new RunsafePlayer(toWrap);
	}

	public static RunsafePainting convert(Painting toWrap)
	{
		return new RunsafePainting(toWrap);
	}

	public static RunsafeLivingEntity convert(LivingEntity toWrap)
	{
		return new RunsafeLivingEntity(toWrap);
	}

	public static RunsafeWorld convert(World toWrap)
	{
		return new RunsafeWorld(toWrap);
	}
}
