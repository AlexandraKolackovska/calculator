package formula;

public class FoSubtractTest implements IFoTwoVariable{

	@Override
	public double execute(double x, double y) {
		for (int i = 0; i < y; i++) {
			x--;
		}
		return x;
	}
}
