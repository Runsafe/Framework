package no.runsafe.framework.internal.wrapper.block;

import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;

public abstract class BukkitNoteBlock extends BukkitBlockState
{
	protected BukkitNoteBlock(Block toWrap, NoteBlock state)
	{
		super(toWrap, state);
		noteBlock = state;
	}

	public byte getRawNote()
	{
		return noteBlock.getRawNote();
	}

	public void setRawNote(byte b)
	{
		noteBlock.setRawNote(b);
	}

	public boolean play()
	{
		return noteBlock.play();
	}

	public boolean play(byte b, byte b1)
	{
		return noteBlock.play(b, b1);
	}

	protected final NoteBlock noteBlock;
}
