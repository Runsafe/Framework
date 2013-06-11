package no.runsafe.framework.minecraft.item.meta;

import no.runsafe.framework.internal.wrapper.item.meta.BukkitLeatherArmor;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RunsafeLeatherArmor extends BukkitLeatherArmor
{
	public RunsafeLeatherArmor(ItemStack stack)
	{
		super(stack);
	}

	public void RandomColour()
	{
		setColor(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
	}

	static private final Random rng = new Random();
}
