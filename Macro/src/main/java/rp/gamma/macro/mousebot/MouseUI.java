package rp.gamma.macro.mousebot;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MouseUI extends JFrame {
	public JPanel panel;
	public JButton doubleClickBtn;
	public JButton mysticForgeBtn;
	public JButton getCurrentLocationBtn;
	public JTextField getDoubleClickTimes;

	public MouseUI() {
		panel = new JPanel();
		doubleClickBtn = new JButton("Load DoubleClick Script");
		mysticForgeBtn = new JButton("Load Mystic Forge Script");
		getCurrentLocationBtn = new JButton("Get Current Location in 5 s.");
		getDoubleClickTimes = new JTextField("10");

		panel.add(doubleClickBtn);
		panel.add(getDoubleClickTimes);
		panel.add(mysticForgeBtn);
		panel.add(getCurrentLocationBtn);

		this.add(panel);
		this.setSize(300, 200);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
