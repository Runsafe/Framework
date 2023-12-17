package no.runsafe.framework.api.block;

public interface INoteBlock extends IBlockState, IBlock
{
	byte getRawNote();
	void setRawNote(byte b);
	boolean play();
	boolean play(byte b, byte b1);
}
