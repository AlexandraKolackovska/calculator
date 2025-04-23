package formula;

public class FoSubtract extends FoDefault {

	FoAbsolute foAbsolute = new FoAbsolute();

	@Override
	public double execute(double x, double y) {

		for (int i = 0; i < foAbsolute.execute(y); i++) {
			if (y < 0) {
				x++;
			} else {
				x--;
			}
		}
		return x;
	}
}
