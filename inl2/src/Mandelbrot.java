import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Mandelbrot {
	public static void main(String[] args) {
		MandelbrotGUI gui = new MandelbrotGUI();
		Generator generator = new Generator();

		boolean clean = true;
		
		while (true) {
			switch (gui.getCommand()) {
			case MandelbrotGUI.RENDER:
				clean = false;
				generator.render(gui);
				break;
			case MandelbrotGUI.RESET:
				clean = true;
				gui.resetPlane();
				gui.clearPlane();
				break;
			case MandelbrotGUI.QUIT:
				System.exit(0);
				break;
			case MandelbrotGUI.ZOOM:
				if(clean == false) generator.render(gui);
				break;
			}
		}
	}
}