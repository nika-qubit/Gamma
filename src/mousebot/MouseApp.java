package mousebot;

public class MouseApp {
	public static void main(String[] argv) {
		MouseController mc = new MouseController();
		new Thread(mc).start();
	}
}
