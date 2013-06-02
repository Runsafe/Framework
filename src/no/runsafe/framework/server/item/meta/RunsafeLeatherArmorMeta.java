package no.runsafe.framework.server.item.meta;

import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RunsafeLeatherArmorMeta extends RunsafeItemMeta
{
	public RunsafeLeatherArmorMeta(LeatherArmorMeta toWrap)
	{
		super(toWrap);
		leatherArmor = toWrap;
	}

	public int getColor()
	{
		return leatherArmor.getColor().asRGB();
	}

	public void setColor(int color)
	{
		leatherArmor.setColor(Color.fromRGB(color));
	}

	public void setColor(int r, int g, int b)
	{
		leatherArmor.setColor(Color.fromRGB(r, g, b));
	}

	public RunsafeLeatherArmorMeta clone()
	{
		return new RunsafeLeatherArmorMeta(leatherArmor.clone());
	}

	final private LeatherArmorMeta leatherArmor;
}
