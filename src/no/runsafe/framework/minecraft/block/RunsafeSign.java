package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.ISign;
import no.runsafe.framework.internal.wrapper.block.BukkitSign;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class RunsafeSign extends BukkitSign implements ISign
{
	public RunsafeSign(Block toWrap, Sign state)
	{
		super(toWrap, state);
	}

	@Override
	public void setLines(Object... arguments)
	{
		int index = 0;
		for (Object line : arguments)
		{
			if (index > 4) break;
			setLine(index, line.toString());
			index++;
		}
	}
}
