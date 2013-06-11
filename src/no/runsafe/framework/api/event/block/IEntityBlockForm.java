package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.block.RunsafeEntityBlockFormEvent;

public interface IEntityBlockForm extends IRunsafeEvent
{
	public void OnEntityBlockForm(RunsafeEntityBlockFormEvent event);
}
