package no.runsafe.framework.minecraft.entity.monsters;

import no.runsafe.framework.api.entity.monsters.IMonster;
import no.runsafe.framework.minecraft.entity.RunsafeCreature;
import org.bukkit.entity.Monster;

public class RunsafeMonster extends RunsafeCreature implements IMonster
{
	public RunsafeMonster(Monster toWrap)
	{
		super(toWrap);
	}
}
