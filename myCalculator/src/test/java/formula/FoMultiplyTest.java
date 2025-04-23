package formula;

public class FoMultiplyTest implements IFoTwoVariable, IFoNVariables{

	FoAdd foAdd = new FoAdd();
	
	@Override
	public double execute(double x, double y) {
		double[] array =  new double[(int) y];
		for (int i = 0; i < y; i++) {
			array[i] = x;
		}
		return foAdd.execute(array);
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
