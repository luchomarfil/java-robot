package robocop.robot;

import java.awt.Point;
import java.awt.Robot;
import java.util.List;

import robocop.model.Franco;
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
	
	public void cargarPlanilla(PlanillaFrancos planilla){
		
	}
	
	public void cargarFrancos(List<Franco> francos, PlanillaFrancos planilla){
		
	}
	
	public void cargarFranco(Franco franco){
		escribirString(franco.getPersona().getLegajo().toString(), PuntosDeInteres.UBICACION_INPUT_LEGAJO);
	}
	
	/**
	 * Moviliza el robot hasta un determinado punto y ahi simula un clic
	 * izquierdo, esperando un tiempo pasado por parametro
	 * @param punto
	 * @param tiempo
	 */
	private void realizarClicIzquierdo(Point punto, int tiempo){
		//similar a presionarTecla
	}
	/**
	 * Presiona la tecla, y la levanta luego de un tiempo determinado
	 * para simular el tipeo por teclado
	 * @param keycode
	 * @param tiempo
	 */
	private void presionarTecla(int keycode, int tiempo){
		robot.keyPress(keycode);
		//robot.delay(tiempo);
		robot.keyRelease(keycode);
	}
	/**
	 * Presiona la tecla, y la levanta luego de un tiempo determinado
	 * para simular el tipeo por teclado
	 * @param keycode
	 * @param tiempo
	 */
	private void presionarTecla(int keycode, int tiempo, Point punto){
		robot.mouseMove((int)punto.getX(),(int)punto.getY());
		presionarTecla(keycode, tiempo);
	}
	
	/**
	 * Para cada letra de la palabra simula la escritura,
	 * presionando teclas.
	 * @param palabra
	 */
	private void escribirString(String palabra){
		//como pasar un string a una tecla del teclado
		//pasar string a lista de keycodes
		//invocar a escribirString de abajo
	}
	
	/**
	 * Para cada letra de la palabra simula la escritura,
	 * presionando teclas.
	 * @param palabra
	 */
	private void escribirString(String palabra, Point puntoDondeEscribir){
		//como pasar un string a una tecla del teclado
		//pasar string a lista de keycodes
		//invocar a escribirString de abajo
	}
	
	/**
	 * Para cada keycode, simula la escritura
	 */
	private void escribirString(List<Integer> listaKeyCodes){
		//se podria utilizar luego de traducir de alguna manera 
		//un string a una lista de keycodes, con el metodo de arriba
		//con cada keycode se invoca a #presionarTecla
	}
	
}
