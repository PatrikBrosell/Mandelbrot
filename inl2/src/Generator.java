import java.awt.Color;
import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Generator {
	Color[][] picture;
	Complex[][] complex;
	double minRe;
	double maxRe;
	double minIm;
	double maxIm;
	int width;
	int height;

	/** Ritar en bild i fönstret i användargränssnittet gui */
	public void render(MandelbrotGUI gui) {

		// Disable Input
		gui.disableInput();
		// Skapa matrisen med komplexa tal med metoden mesh
		complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(),
				gui.getHeight());
		Color[] cScale = colorScale();
		Color[] rScale = redScale();
		Color[] bScale = blueScale();
		Color[] gScale = greenScale();
		int r = 0;
		switch (gui.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_LOW:
			r += 9;
			break;
		case MandelbrotGUI.RESOLUTION_LOW:
			r += 7;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM:
			r += 5;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH:
			r += 3;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			r += 1;
			break;
		}
		int MAX_ITER = 1024;
		if (gui.getExtraText().equals("blue")) {
			MAX_ITER = 255;
		} else if (gui.getExtraText().equals("red")) {
			MAX_ITER = 255;
		} else if (gui.getExtraText().equals("green")) {
			MAX_ITER = 255;	
		} else {
			MAX_ITER = 1024;
		} 
			// Skapar matrisen "picture" färgerna för varje pixel

			// Sen sätter man en färg beroende på hur många iterationer man
			// måste göra för att hitta att det inte är en mandelbrotmängd

		

		Color[][] picture = new Color[gui.getHeight() / r][gui.getWidth() / r];
		for (int j = 0; j < gui.getHeight() / r; j++) {
			for (int i = 0; i < gui.getWidth() / r; i++) {
				Complex c = complex[i * r + r / 2][j * r + r / 2];
				
				int k = 0;
				Complex z0 = new Complex(0, 0);
				do {
					k++;
					z0.mul(z0);
					z0.add(c);
				} while (k < MAX_ITER && z0.getAbs2() <= 2 * 2);
				if (k < MAX_ITER) {
					switch (gui.getMode()) {
					case MandelbrotGUI.MODE_BW: picture[j][i] = new Color(255, 255, 255); break;
					case MandelbrotGUI.MODE_COLOR: 
						if (gui.getExtraText().equals("blue")) {
							picture[j][i] = bScale[k];
						} else if (gui.getExtraText().equals("red")) {
							picture[j][i] = rScale[k];
						} else if (gui.getExtraText().equals("green")) {
							picture[j][i] = gScale[k];	
						} else {
							picture[j][i] = cScale[k];
						} break;
					}
					} else {
					picture[j][i] = new Color(0, 0, 0);
				}
			}
		}

		// Ritar upp bilden
		gui.putData(picture, r, r);
		// Återställer disable input
		gui.enableInput();
	}

	private Color[] colorScale() {
		Color[] divergeColor = new Color[1090];
		double ColorLength = 32;
		int allColors = 0;
		for (int m = (int) ColorLength; m >= 0; m--) {
			for (int n = (int) ColorLength; n >= 0; n--) {
				allColors++;
				divergeColor[allColors] = new Color(0, n * (255 / 32), m * (255 / 32));
			}
		}
		return divergeColor;
	
	}
	
	private Color[] redScale() {
		Color[] divergeRed = new Color[255];
		for (int red = 0; red < 255; red++) {
				divergeRed[red] = new Color(red, 0, 0);
			}
		return divergeRed;
		}
	
	private Color[] blueScale() {
		Color[] divergeBlue = new Color[255];
		for (int blue = 0; blue < 255; blue++) {
				divergeBlue[blue] = new Color(0, 0, blue);
			}
		return divergeBlue;
		}
	
	private Color[] greenScale() {
		Color[] divergeGreen = new Color[255];
		for (int green = 0; green < 255; green++) {
				divergeGreen[green] = new Color(0, green, 0);
			}
		return divergeGreen;
		}
	
	
	/**
	 * Skapar en matris där varje element är ett komplext tal som har rätt
	 * koordinater
	 */
	private Complex[][] mesh(double minRe, double maxRe, double minIm,
			double maxIm, int width, int height) {

		Complex[][] complex = new Complex[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				complex[j][i] = new Complex(
						(double) minRe + ((double) j / (double) (width - 1))
								* (maxRe - minRe), maxIm
								- ((double) i / (height - 1)) * (maxIm - minIm));
			}
		}
		/**
		 * System.out.println("Im-värde: " + complex[0][0].getIm() +
		 * " och Re-värde: " + complex[0][0].getRe());
		 * System.out.println("Im-värde: " + complex[height - 1][width -
		 * 1].getIm() + " och Re-värde: " + complex[height - 1][width -
		 * 1].getRe());
		 */
		return complex;

	}

}

/*
 * if (complex[i * r + r / 2][j * r + r / 2].getAbs2() > 1) { picture[j][i] =
 * Color.PINK; } else if (complex[i * r + r / 2][j * r + r / 2].getIm() > 0 &&
 * complex[i * r + r / 2][j * r + r / 2].getRe() > 0) { picture[j][i] =
 * Color.RED; } else if (complex[i * r + r / 2][j * r + r / 2].getIm() > 0 &&
 * complex[i * r + r / 2][j * r + r / 2].getRe() < 0) { picture[j][i] =
 * Color.blue; } else if (complex[i * r + r / 2][j * r + r / 2].getIm() < 0 &&
 * complex[i * r + r / 2][j * r + r / 2].getRe() < 0) { picture[j][i] =
 * Color.green; } else if (complex[i * r + r / 2][j * r + r / 2].getIm() < 0 &&
 * complex[i * r + r / 2][j * r + r / 2].getRe() > 0) { picture[j][i] =
 * Color.MAGENTA; }
 */
