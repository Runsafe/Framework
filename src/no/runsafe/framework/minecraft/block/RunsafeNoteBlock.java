package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.INoteBlock;
import no.runsafe.framework.internal.wrapper.block.BukkitNoteBlock;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;

public class RunsafeNoteBlock extends BukkitNoteBlock implements INoteBlock
{
	public RunsafeNoteBlock(Block toWrap, NoteBlock state)
	{
		super(toWrap, state);
	}
}
