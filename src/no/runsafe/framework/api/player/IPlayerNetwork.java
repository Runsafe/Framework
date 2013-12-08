package no.runsafe.framework.api.player;

import javax.annotation.Nullable;
import java.net.InetSocketAddress;

public interface IPlayerNetwork
{
	@Nullable
	InetSocketAddress getAddress();
	@Nullable
	String getIP();
}
