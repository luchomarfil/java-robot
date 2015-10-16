package robocop.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Franco {
	private Persona persona;
	private int dia;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getFechaCompleta() {
		int anio = this.getPersona().getPlanilla().getAnio();
		int mes = this.getPersona().getPlanilla().getMes();
		int dia = this.getDia();
		//creo la fecha
		Calendar fecha = Calendar.getInstance();
		fecha.set(anio, mes, dia);
		SimpleDateFormat sf = new SimpleDateFormat("ddmmyyyy");
		return sf.format(fecha);
	}
}
