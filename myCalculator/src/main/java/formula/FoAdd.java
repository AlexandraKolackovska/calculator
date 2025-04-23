package formula;

public class FoAdd extends FoDefault{
	
	FoSubtract foSubtract = new FoSubtract();
	FoNegative foNegative = new FoNegative();

	@Override
	public double execute(double x, double y) {
		if(y < 0) {
			return foSubtract.execute(x, foNegative.execute(y)); 
		}
		for (int i = 0; i < y; i++) {
			x++;
		}
		return x;
	}

	@Override
	public double execute(double[] array) {
		double result = 0;
		for (int i = 0; i < array.length; i++) {
			this.execute(result, array[i]);
		}
		return result;
	}
}
