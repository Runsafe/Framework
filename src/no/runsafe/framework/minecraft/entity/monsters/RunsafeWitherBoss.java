package no.runsafe.framework.minecraft.entity.monsters;

import no.runsafe.framework.api.entity.monsters.IWitherBoss;
import org.bukkit.entity.Wither;

public class RunsafeWitherBoss extends RunsafeMonster implements IWitherBoss
{
	public RunsafeWitherBoss(Wither toWrap)
	{
		super(toWrap);
		wither = toWrap;
	}

	Wither wither;
}
