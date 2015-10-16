package robocop.robot;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.List;

import robocop.exception.RobocopCargaFrancoExcepcion;
import robocop.model.Franco;
import robocop.model.Persona;
import robocop.model.PlanillaFrancos;

public class RobotFrancos {

	private Robot robot;

	public RobotFrancos() {

	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public void cargarPlanilla(PlanillaFrancos planilla) throws RobocopCargaFrancoExcepcion {
		if((planilla.getPersonas() == null) || (planilla.getPersonas().isEmpty())){
			throw new RobocopCargaFrancoExcepcion("La lista de personas de la planilla esta vacia");
		}
		//escribe el periodo
		String periodo = planilla.getPeriodo();
		this.realizarClicIzquierdo(PuntosDeInteres.UBICACION_INPUT_PERIODO);
		this.escribirString(periodo);
		//presiono enter
		this.presionarTecla(PuntosDeInteres.KEY_ACEPTAR_PERIODO);
		this.getRobot().delay(1000);
		System.out.println("Periodo cargado...:"+periodo);
		//ahora procesa los francos
		for (Persona persona : planilla.getPersonas()) {
			this.cargarFrancosDePersona(persona.getFrancos());
			this.getRobot().delay(300);
			System.out.println("Persona cargada...:"+persona.getLegajo().toString());
		}
		System.out.println("Planilla cargada...:"+planilla.getNombre());
		
	}

	public void cargarFrancosDePersona(List<Franco> francos) throws RobocopCargaFrancoExcepcion {
		if((francos == null) || (francos.isEmpty())){
			throw new RobocopCargaFrancoExcepcion("La lista de francos esta vacia");
		}
		//ingreso el numero de legajo
		this.realizarDobleClicIzquierdo(PuntosDeInteres.UBICACION_INPUT_LEGAJO);
		String numeroLegajo = francos.get(0).getPersona().getLegajo().toString();
		this.escribirString(numeroLegajo, PuntosDeInteres.UBICACION_INPUT_LEGAJO);
		//presiono enter
		this.presionarTecla(PuntosDeInteres.KEY_ACEPTAR_LEGAJO);
		this.getRobot().delay(1000);
		//espero un momento
		//aca tengo el cursor en el primer input del legajo		
		for (Franco franco : francos) {
			this.escribirString(franco.getFechaCompleta());
			this.presionarTecla(PuntosDeInteres.KEY_ACEPTAR_FRANCO);
			this.getRobot().delay(100);
			System.out.println("Franco cargado...:"+franco.getDia());
		}
		//aca se procesaron todos los francos
	}

	public void cargarFrancoDePersona(Franco franco) {
		//ingreso el numero de legajo
		this.realizarDobleClicIzquierdo(PuntosDeInteres.UBICACION_INPUT_LEGAJO);
		String numeroLegajo = franco.getPersona().getLegajo().toString();
		this.escribirString(numeroLegajo, PuntosDeInteres.UBICACION_INPUT_LEGAJO);
		//presiono enter
		this.presionarTecla(PuntosDeInteres.KEY_ACEPTAR_LEGAJO);
		this.getRobot().delay(1000);
		//cargo el franco
		this.escribirString(franco.getFechaCompleta());
		this.presionarTecla(PuntosDeInteres.KEY_ACEPTAR_FRANCO);
		this.getRobot().delay(100);
		System.out.println("Franco cargado...:"+franco.getDia());
	}

	/**
	 * Moviliza el robot hasta un determinado punto y ahi simula un clic
	 * izquierdo, esperando un tiempo pasado por parametro
	 * 
	 * @param punto
	 * @param tiempo
	 */
	private void realizarClicIzquierdo(Point punto) {
		// similar a presionarTecla
		this.getRobot().mouseMove(punto.x, punto.y);
		this.getRobot().mousePress(InputEvent.BUTTON1_MASK);
		this.getRobot().mouseRelease(InputEvent.BUTTON1_MASK);
	}

	/**
	 * Moviliza el robot hasta un determinado punto y ahi simula un clic
	 * izquierdo, esperando un tiempo pasado por parametro
	 * 
	 * @param punto
	 * @param tiempo
	 */
	private void realizarDobleClicIzquierdo(Point punto) {
		// similar a presionarTecla
		this.getRobot().mouseMove(punto.x, punto.y);
		this.getRobot().mousePress(InputEvent.BUTTON1_MASK);
		this.getRobot().mouseRelease(InputEvent.BUTTON1_MASK);
		this.getRobot().mousePress(InputEvent.BUTTON1_MASK);
		this.getRobot().mouseRelease(InputEvent.BUTTON1_MASK);
	}

	/**
	 * Presiona la tecla, y la levanta luego de un tiempo determinado para
	 * simular el tipeo por teclado
	 * 
	 * @param keycode
	 * @param tiempo
	 */
	private void presionarTecla(int keycode, int tiempo) {
		robot.keyPress(keycode);
		robot.delay(tiempo);
		robot.keyRelease(keycode);
	}

	/**
	 * Presiona la tecla, y la levanta luego de un tiempo determinado para
	 * simular el tipeo por teclado
	 * 
	 * @param keycode
	 */
	private void presionarTecla(int keycode) {
		this.presionarTecla(keycode, 0);
	}

	/**
	 * Presiona la tecla, y la levanta luego de un tiempo determinado para
	 * simular el tipeo por teclado
	 * 
	 * @param keycode
	 * @param tiempo
	 */
	private void presionarTecla(int keycode, int tiempo, Point punto) {
		robot.mouseMove((int) punto.getX(), (int) punto.getY());
		presionarTecla(keycode, tiempo);
	}

	/**
	 * Para cada letra de la palabra simula la escritura, presionando teclas.
	 * 
	 * @param palabra
	 */
	private void escribirString(String palabra) {

		for (int i = 0; i < palabra.length(); i++) {
			try {
				boolean esLetraUppercase = Character.isUpperCase(palabra.charAt(i));
				String nombreKeyValSufijo = Character.toString(palabra.charAt(i));
				String variableName = "VK_" + nombreKeyValSufijo.toUpperCase();
				Class clazz = KeyEvent.class;
				Field field = clazz.getField(variableName);
				int keyCode = field.getInt(null);

				if (esLetraUppercase) {
					robot.keyPress(KeyEvent.VK_SHIFT);
				}
				this.presionarTecla(keyCode);
				if (esLetraUppercase) {
					robot.keyRelease(KeyEvent.VK_SHIFT);
				}
			} catch (Exception e) {
				System.out.println("Se pudrio la momia");
			}
		}

	}

	/**
	 * Para cada letra de la palabra simula la escritura, presionando teclas.
	 * 
	 * @param palabra
	 */
	private void escribirString(String palabra, Point puntoDondeEscribir) {
		this.getRobot().mouseMove(puntoDondeEscribir.x, puntoDondeEscribir.y);
		this.escribirString(palabra);
	}

}
