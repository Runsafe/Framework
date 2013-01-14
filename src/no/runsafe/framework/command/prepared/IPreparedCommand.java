package no.runsafe.framework.command.prepared;

/**
 * Created with IntelliJ IDEA.
 * User: mortenn
 * Date: 14.01.13
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
public interface IPreparedCommand
{
	String getRequiredPermission();

	String execute();
}
