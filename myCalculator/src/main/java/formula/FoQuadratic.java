package formula;

public class FoQuadratic {

	FoAdd foAdd = new FoAdd();
	FoSubtract foSubtract = new FoSubtract();
	FoMultiply foMultiply = new FoMultiply();
	FoDivide foDivide = new FoDivide();
	FoNegative foNegative = new FoNegative();
	FoSquareRoot foSquareRoot = new FoSquareRoot();

	public double[] execute(double a, double b, double c) {
		double[] roots = new double[2];
		// D = b^2 - 4ac
		double discriminant;
		discriminant = foMultiply.execute(b, b);
		discriminant = foSubtract.execute(discriminant, foMultiply.execute(4, foMultiply.execute(a, c)));

		// x1 = (-b + √D) / 2a
		double x1 = foDivide.execute(foAdd.execute(foNegative.execute(b), foSquareRoot.execute(discriminant)),
				foMultiply.execute(2, a));
		// x2 = (-b - √D) / 2a
		double x2 = foDivide.execute(foSubtract.execute(foNegative.execute(b), foSquareRoot.execute(discriminant)),
				foMultiply.execute(2, a));
		System.out.println("The roots of equation " + a + "x² + " + b + "x + " + c + " are: " + x1 + ", " + x2);
		roots[0] = x1;
		roots[1] = x2;
		return roots;
	}
}
