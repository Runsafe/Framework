package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.block.RunsafeEntityBlockFormEvent;

public interface IEntityBlockForm extends IRunsafeEvent
{
	public void OnEntityBlockForm(RunsafeEntityBlockFormEvent event);
}
