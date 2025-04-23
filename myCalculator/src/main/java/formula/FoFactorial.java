package formula;

public class FoFactorial implements IFoOneVariable {

	FoMultiply foMultiply = new FoMultiply();

	@Override
	public double execute(double x) {
		double result = 1;
		for (int i = 1; i < x + 1; i++) {
			result = foMultiply.execute(result, i);
		}
		return result;
	}

}
