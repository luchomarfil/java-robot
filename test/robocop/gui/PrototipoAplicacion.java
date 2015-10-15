package robocop.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JFrame;

public class PrototipoAplicacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PrototipoAplicacion() {
		setMinimumSize(new Dimension(300, 300));
		setPreferredSize(new Dimension(300, 300));		
		setTitle("Prototipo");
		setName("Prototipo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrototipoAplicacion.class.getResource("/robocop/resources/jeringa.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}
	

}
