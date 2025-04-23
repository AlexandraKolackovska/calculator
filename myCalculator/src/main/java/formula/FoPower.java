package formula;

public class FoPower implements IFoTwoVariable {

	FoMultiply foMultiply = new FoMultiply();
	
	@Override
	public double execute(double x, double y) {
		double result = 1;
		for (int i = 0; i < y; i++) {
			result = foMultiply.execute(result, x);
		}
		return result;
	}

}
