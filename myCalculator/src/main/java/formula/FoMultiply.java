package formula;

public class FoMultiply implements IFoTwoVariable, IFoNVariables {

	FoAdd foAdd = new FoAdd();
	FoNegative foNegative = new FoNegative();

	@Override
	public double execute(double x, double y) {
		double result = 0;
		for (int i = 0; i < y; i++) {
			result = foAdd.execute(result, x);
		}
		if (y < 0) {
			return foNegative.execute(result);
		}
		return result;
	}

	@Override
	public double execute(double[] array) {
		double result = 1;
		for (int i = 0; i < array.length; i++) {
			this.execute(result, array[i]);
		}
		return result;
	}
}
