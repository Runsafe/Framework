package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitNoteBlock;
import org.bukkit.block.NoteBlock;

public class RunsafeNoteBlock extends BukkitNoteBlock implements no.runsafe.framework.api.block.INoteBlock
{
	public RunsafeNoteBlock(NoteBlock toWrap)
	{
		super(toWrap);
	}
}
