package robocop.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private Long legajo;
	private List<Franco> francos = new ArrayList<Franco>();
	private PlanillaFrancos planilla;

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public PlanillaFrancos getPlanilla() {
		return planilla;
	}

	public void setPlanilla(PlanillaFrancos planilla) {
		this.planilla = planilla;
	}

	public List<Franco> getFrancos() {
		return francos;
	}

	public void setFrancos(List<Franco> francos) {
		this.francos = francos;
	}

}
