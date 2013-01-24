package no.runsafe.framework.server.block;

import org.bukkit.block.Block;

public class RunsafeSpawner extends RunsafeBlock
{
	public RunsafeSpawner(Block toWrap)
	{
		super(toWrap);
	}

	@Override
	public RunsafeCreatureSpawner getBlockState()
	{
		return (RunsafeCreatureSpawner) super.getBlockState();
	}

	public String getCreatureType()
	{
		return getBlockState().getCreatureTypeName();
	}

	public int getCreatureId()
	{
		return getBlockState().getRaw().getTypeId();
	}

	public void setCreatureType(String type)
	{
		getBlockState().setCreatureTypeByName(type);
	}
}
