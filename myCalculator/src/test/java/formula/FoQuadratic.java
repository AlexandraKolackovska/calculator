package formula;


public class FoQuadratic {
	
	FoAdd foAdd = new FoAdd();
	FoSubtract foSubtract = new FoSubtract();
	FoMultiply foMultiply = new FoMultiply();
	FoDivide foDivide = new FoDivide();
	

	public double[] execute(double a, double b, double c){
		double[] roots = new double[2];
		double discriminant = foMultiply.execute(b, b);
		discriminant = foSubtract.execute(discriminant, foMultiply.execute(new double[]{4, a, c}));
		roots[0] = 0;
		return roots;
	}
}
