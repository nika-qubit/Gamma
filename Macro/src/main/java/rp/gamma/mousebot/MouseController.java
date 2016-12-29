package rp.gamma.mousebot;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class MouseController implements Runnable {
	volatile private boolean dctStop = true;
	volatile private boolean mftStop = true;
	private Robot mouseRobot;
	private MouseUI mouseUI;

	DoubleClickThread dct;
	MysticForgeThread mft;

	public MouseController() {
		mouseUI = new MouseUI();
		try {
			// System.out.println("Mouse button number:
			// "+MouseInfo.getNumberOfButtons());
			this.mouseRobot = new Robot();
			addListenersToLoadScript();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void singleLeftClick() {
		mouseRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		mouseRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void doubleLeftClick() {
		System.out.println("Double Click");
		singleLeftClick();
		singleLeftClick();
		mouseRobot.delay(80);
	}

	public void moveTo(int x, int y) {
		mouseRobot.mouseMove(x, y);
	}

	class DoubleClickThread extends Thread {

		@Override
		public void run() {
			mouseRobot.delay(5000);
			int i = 0;
			int doubleClickTimes = Integer.parseInt(mouseUI.getDoubleClickTimes.getText());
			while (i < doubleClickTimes) {
				doubleLeftClick();
				i++;
			}
		}

	}

	class MysticForgeThread extends Thread {
		public void run() {
			mouseRobot.delay(5000);
			int i = 0;
			while (i < 24) {
				// put in 4 items
				moveTo(556, 259);
				doubleLeftClick();
				moveTo(600, 259);
				doubleLeftClick();
				moveTo(670, 259);
				doubleLeftClick();
				moveTo(706, 259);
				doubleLeftClick();
				// forge
				moveTo(1098, 700);
				doubleLeftClick();
				mouseRobot.delay(3000);
				i++;
			}
		}
	}

	/*
	 * @ event to UI
	 */
	public void addListenersToLoadScript() {
		mouseUI.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_F9) {
					dctStop = true;
					mftStop = true;
					System.out.println("F9 pressed, manually stopped");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// load double click script
		mouseUI.doubleClickBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dctStop = false;
				dct = new DoubleClickThread();
				System.out.println("Start Double Clicking");
				dct.run();
			}
		});

		// load mystic forge script
		mouseUI.mysticForgeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mftStop = false;
				mft = new MysticForgeThread();
				System.out.println("Start Mystic Forge");
				mft.run();
			}
		});

		// get Current Location
		mouseUI.getCurrentLocationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Get location in 5s.");
				mouseRobot.delay(5000);
				Point p = MouseInfo.getPointerInfo().getLocation();
				JOptionPane.showMessageDialog(null, p.getX() + ", " + p.getY());
			}
		});

	}

	public void run() {

	}
}
