//Testprogram för Complex-klassen.

public class TestComplex {
	public static void main(String[] args) {
		Complex komplex1 = new Complex(2,3);
		Complex komplex2 = new Complex(4,3);
		Complex komplex3 = new Complex(2,3);
		Complex komplex4 = new Complex(4,3);
		System.out.println("Världens snyggaste testprogram för Complex-klassen");
		System.out.println();
		System.out.println("Realdelen är: " + komplex1.getRe() + " och imaginärdelen är " + komplex1.getIm() + "i");
		System.out.println("Absolutbeloppet i kvadrat är: " + komplex1.getAbs2());
		System.out.println();
		System.out.println("Adderar det komplexa talet " + komplex2.getRe() + " + " + komplex2.getIm() + "i" + " till det komplexa talet " + komplex1.getRe() + " + " + komplex1.getIm() + "i");
		komplex1.add(komplex2);
		System.out.println("Efter addition är realdelen: " + komplex1.getRe() + " och imaginärdenen: " + komplex1.getIm() + "i");
		System.out.println();
		System.out.println("Multiplicerar dom komplexa talen " + komplex3.getRe() + " + " + komplex3.getIm() + "i" + " och " + komplex4.getRe() + " + " + komplex4.getIm() + "i");
		komplex3.mul(komplex4);
		System.out.println("Efter multiplikation är realdelen " + komplex3.getRe() + " och imaginärdelen " + komplex3.getIm() + "i");
			}
}
