package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import org.bukkit.block.NoteBlock;

public class BukkitNoteBlock extends RunsafeBlockState
{
	public BukkitNoteBlock(NoteBlock toWrap)
	{
		super(toWrap);
		noteBlock = toWrap;
	}

//	public Note getNote()
//	public void setNote(Note note)

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

//	public boolean play(Instrument instrument, Note note)

	@Override
	public NoteBlock getRaw()
	{
		return noteBlock;
	}

	protected final NoteBlock noteBlock;
}