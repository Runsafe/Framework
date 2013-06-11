package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitNoteBlock;
import org.bukkit.block.NoteBlock;

public class RunsafeNoteBlock extends BukkitNoteBlock
{
	public RunsafeNoteBlock(NoteBlock toWrap)
	{
		super(toWrap);
	}
}
