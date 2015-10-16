package robocop.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PlanillaFrancos {
	private List<Persona> personas = new ArrayList<Persona>();
	private int anio;
	private int mes;
	private String nombre;

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public String getPeriodo() {
		int anio = getAnio();
		int mes = getMes();	
		//creo la fecha
		Calendar fecha = Calendar.getInstance();
		fecha.set(anio, mes,1);
		SimpleDateFormat sf = new SimpleDateFormat("mmyyyy");
		return sf.format(fecha);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
