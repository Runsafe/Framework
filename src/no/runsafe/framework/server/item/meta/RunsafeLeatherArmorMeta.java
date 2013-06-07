package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.item.meta.BukkitLeatherArmorMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RunsafeLeatherArmorMeta extends BukkitLeatherArmorMeta
{
	public RunsafeLeatherArmorMeta(LeatherArmorMeta toWrap)
	{
		super(toWrap);
	}

	public RunsafeLeatherArmorMeta clone()
	{
		return new RunsafeLeatherArmorMeta(leatherArmor.clone());
	}
}
