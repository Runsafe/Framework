package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;
import java.util.Map;

public class ByteValue extends CommandArgumentSpecification<Byte>
{
    public ByteValue(String name)
    {
        super(name);
    }

    @Override
    public boolean isWhitespaceInclusive()
    {
        return false;
    }

    @Override
    public Byte getValue(IPlayer context, Map<String, String> params)
    {
        try
        {
            if (params.get(name) == null || params.get(name).isEmpty())
                return defaultValue;
            return Byte.parseByte(params.get(name));
        }
        catch (NumberFormatException e)
        {
            return defaultValue;
        }
    }
}
