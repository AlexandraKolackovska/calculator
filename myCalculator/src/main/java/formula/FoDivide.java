package formula;

public class FoDivide implements IFoTwoVariable {

	FoSubtract foSubtract = new FoSubtract();

	@Override
	public double execute(double x, double y) {

		int intX = (int) x;
		int intY = (int) y;
		if (intX == x && intY == y) {
			try {
				System.out.println("The quotient is:\t" + getQuotient(intX, intY));
				System.out.println("The remainder is:\t" + getRemainder(intX, intY));
			} catch (Exception e) {
				System.out.println("You cannot divide by zero!");
			}
		}

		return x / y;
	}

	public int getQuotient(int x, int y) throws Exception {
		if (y != 0) {
			int i = 0;
			while (x >= y) {
				x = (int) foSubtract.execute(x, y);
				i++;
			}
			return i;
		} else {
			throw new Exception("DivisionByZeroNotAllowed");
		}
	}

	public int getRemainder(int x, int y) throws Exception {
		if (y != 0) {
			while (x >= y) {
				x = (int) foSubtract.execute(x, y);
			}
			return x;
		} else {
			throw new Exception("DivisionByZeroNotAllowed");
		}
	}
}
