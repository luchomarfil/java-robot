package robocop.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Dimension;

public class RobocopFrame extends JFrame {
	public RobocopFrame() {
		setMinimumSize(new Dimension(300, 300));
		setPreferredSize(new Dimension(300, 300));
		setType(Type.UTILITY);
		setTitle("Robocop");
		setName("Robocop");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RobocopFrame.class.getResource("/robocop/resources/robocop.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
