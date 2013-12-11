package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.ISign;
import no.runsafe.framework.internal.wrapper.block.BukkitSign;
import org.bukkit.block.Sign;

public class RunsafeSign extends BukkitSign implements ISign
{
	public RunsafeSign(Sign toWrap)
	{
		super(toWrap);
	}

	@Override
	public void setLines(String... arguments)
	{
		int index = 0;
		for (String line : arguments)
		{
			if (index > 4) break;
			setLine(index, line);
			index++;
		}
	}
}
