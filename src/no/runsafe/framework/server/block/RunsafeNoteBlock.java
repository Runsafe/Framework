package no.runsafe.framework.server.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.BlockState;
import org.bukkit.block.NoteBlock;

public class RunsafeNoteBlock extends RunsafeBlockState
{
	public RunsafeNoteBlock(NoteBlock toWrap)
	{
		super(toWrap);
		noteBlock = toWrap;
	}

//	public Note getNote()
//	{
//		return noteBlock.getNote();
//	}
//
//	public void setNote(Note note)
//	{
//		noteBlock.setNote(note);
//	}

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
		return noteBlock.play(b,b1);
	}

//	public boolean play(Instrument instrument, Note note)
//	{
//		return noteBlock.play(instrument, note);
//	}

	private final NoteBlock noteBlock;
}
