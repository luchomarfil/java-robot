package robocop.parser;

import java.io.File;
import java.util.List;

import robocop.model.PlanillaFrancos;

public abstract class PlanillaParser {
	public abstract List<PlanillaFrancos> parsePlanilla(File filename);
	public abstract List<PlanillaFrancos> parsePlanillas(File directory);
}
