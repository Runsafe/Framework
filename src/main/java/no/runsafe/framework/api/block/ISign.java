package no.runsafe.framework.api.block;

public interface ISign extends IBlockState, IBlock
{
	String[] getLines();
	String getLine(int i);
	void setLine(int i, String s);
	void setLines(Object... arguments);
}
