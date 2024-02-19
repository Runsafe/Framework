package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.block.BlockFace;

public class Effect
{
	public static final Effect Click1 = new Effect(org.bukkit.Effect.CLICK1);
	public static final Effect Click2 = new Effect(org.bukkit.Effect.CLICK2);
	public static final Effect BowFire = new Effect(org.bukkit.Effect.BOW_FIRE);
	public static final Effect DoorToggle = new Effect(org.bukkit.Effect.DOOR_TOGGLE);
	public static final Effect Extinguish = new Effect(org.bukkit.Effect.EXTINGUISH);

	public static final class Record
	{
		public static final Effect C418_13 = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_13.getItemID());
		public static final Effect C418_Cat = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Cat.getItemID());
		public static final Effect C418_Blocks = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Blocks.getItemID());
		public static final Effect C418_Chirp = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Chirp.getItemID());
		public static final Effect C418_Far = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Far.getItemID());
		public static final Effect C418_Mall = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Mall.getItemID());
		public static final Effect C418_Mellohi = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Mellohi.getItemID());
		public static final Effect C418_Stal = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Stal.getItemID());
		public static final Effect C418_Strad = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Strad.getItemID());
		public static final Effect C418_Ward = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Ward.getItemID());
		public static final Effect C418_11 = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_11.getItemID());
		public static final Effect C418_Wait = new Effect(org.bukkit.Effect.RECORD_PLAY, Item.Miscellaneous.Record.C418_Wait.getItemID());

		private Record()
		{
		}
	}

	public static final Effect GhastShriek = new Effect(org.bukkit.Effect.GHAST_SHRIEK);
	public static final Effect GhastShoot = new Effect(org.bukkit.Effect.GHAST_SHOOT);
	public static final Effect BlazeShoot = new Effect(org.bukkit.Effect.BLAZE_SHOOT);
	public static final Effect ZombieChewWood = new Effect(org.bukkit.Effect.ZOMBIE_CHEW_WOODEN_DOOR);
	public static final Effect ZombieChewIron = new Effect(org.bukkit.Effect.ZOMBIE_CHEW_IRON_DOOR);
	public static final Effect ZombieDestroyDoor = new Effect(org.bukkit.Effect.ZOMBIE_DESTROY_DOOR);

	public static final class Smoke
	{
		public static final Effect Up = new Effect(org.bukkit.Effect.SMOKE, BlockFace.UP.ordinal());
		public static final Effect Down = new Effect(org.bukkit.Effect.SMOKE, BlockFace.DOWN.ordinal());
		public static final Effect North = new Effect(org.bukkit.Effect.SMOKE, BlockFace.NORTH.ordinal());
		public static final Effect NorthNorthWest = new Effect(org.bukkit.Effect.SMOKE, BlockFace.NORTH_NORTH_WEST.ordinal());
		public static final Effect NorthWest = new Effect(org.bukkit.Effect.SMOKE, BlockFace.NORTH_WEST.ordinal());
		public static final Effect WestNorthWest = new Effect(org.bukkit.Effect.SMOKE, BlockFace.WEST_NORTH_WEST.ordinal());
		public static final Effect West = new Effect(org.bukkit.Effect.SMOKE, BlockFace.WEST.ordinal());
		public static final Effect WestSouthWest = new Effect(org.bukkit.Effect.SMOKE, BlockFace.WEST_SOUTH_WEST.ordinal());
		public static final Effect SouthWest = new Effect(org.bukkit.Effect.SMOKE, BlockFace.SOUTH_WEST.ordinal());
		public static final Effect SouthSouthWest = new Effect(org.bukkit.Effect.SMOKE, BlockFace.SOUTH_SOUTH_WEST.ordinal());
		public static final Effect South = new Effect(org.bukkit.Effect.SMOKE, BlockFace.SOUTH.ordinal());
		public static final Effect SouthSouthEast = new Effect(org.bukkit.Effect.SMOKE, BlockFace.SOUTH_SOUTH_EAST.ordinal());
		public static final Effect SouthEast = new Effect(org.bukkit.Effect.SMOKE, BlockFace.SOUTH_EAST.ordinal());
		public static final Effect EastSouthEast = new Effect(org.bukkit.Effect.SMOKE, BlockFace.EAST_SOUTH_EAST.ordinal());
		public static final Effect East = new Effect(org.bukkit.Effect.SMOKE, BlockFace.EAST.ordinal());
		public static final Effect EastNorthEast = new Effect(org.bukkit.Effect.SMOKE, BlockFace.EAST_NORTH_EAST.ordinal());
		public static final Effect NorthEast = new Effect(org.bukkit.Effect.SMOKE, BlockFace.NORTH_EAST.ordinal());
		public static final Effect NorthNorthEast = new Effect(org.bukkit.Effect.SMOKE, BlockFace.NORTH_NORTH_EAST.ordinal());

		private Smoke()
		{
		}
	}

	public static final Effect StepSound = new Effect(org.bukkit.Effect.STEP_SOUND);
	public static final Effect EnderSignal = new Effect(org.bukkit.Effect.ENDER_SIGNAL);
	public static final Effect MobSpawnerFlames = new Effect(org.bukkit.Effect.MOBSPAWNER_FLAMES);

	public void Play(ILocation location)
	{
		if (effect == org.bukkit.Effect.STEP_SOUND)
			location.getWorld().playEffect(location, effect, location.getBlock().getData());
		else
			location.getWorld().playEffect(location, effect, data);
	}

	private Effect(org.bukkit.Effect effect)
	{
		this(effect, 0);
	}

	public Effect(org.bukkit.Effect effect, int data)
	{
		this.effect = effect;
		this.data = data;
	}

	private final org.bukkit.Effect effect;
	private final int data;
}
