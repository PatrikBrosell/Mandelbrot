public class Complex {
	public double re;
	public double im;

	/** Skapar en komplex variabel med realdelen re och imaginärdelen im */
	Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/** Tar reda på realdelen */
	double getRe() {
		return re;
	}
	/** Tar reda på imaginärdelen */
	double getIm() {
		return im;
	}

	/** Tar reda på talets absolutbelopp i kvadrat */
	double getAbs2() {
		return (re*re + im*im);
	}

	/** Adderar det komplexa talet c till detta tal */
	void add(Complex c) {
		re = re + c.getRe();
		im = im + c.getIm();
	}

	/** Multiplicerar detta tal med det komplexa talet c */
	void mul(Complex c) {
		double temp_re = (re * c.getRe()) - (im * c.getIm());
		im = (im * c.getRe()) + (re * c.getIm());
		re = temp_re;
	}
}
