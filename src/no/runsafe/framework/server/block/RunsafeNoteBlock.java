package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitNoteBlock;
import org.bukkit.block.NoteBlock;

public class RunsafeNoteBlock extends BukkitNoteBlock
{
	public RunsafeNoteBlock(NoteBlock toWrap)
	{
		super(toWrap);
	}
}
