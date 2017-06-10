package no.runsafe.framework.internal.wrapper.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
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

	public void setRawNote(byte note)
	{
		noteBlock.setNote(new Note(note));
	}

	public boolean play()
	{
		return noteBlock.play();
	}

	public boolean play(byte instrument, byte note)
	{
		return noteBlock.play(Instrument.getByType(instrument), new Note(note));
	}

	protected final NoteBlock noteBlock;
}
