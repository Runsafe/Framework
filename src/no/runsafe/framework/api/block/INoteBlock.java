package no.runsafe.framework.api.block;

import no.runsafe.framework.api.block.IBlockState;

public interface INoteBlock extends IBlockState
{
	byte getRawNote();
	void setRawNote(byte b);
	boolean play();
	boolean play(byte b, byte b1);
}
