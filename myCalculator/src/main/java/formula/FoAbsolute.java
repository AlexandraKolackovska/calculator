package formula;

public class FoAbsolute implements IFoOneVariable {

	@Override
	public double execute(double x) {
		if (x >= 0) {
			return x;
		}
		String s = x + "";
		s = s.substring(1);
		return Double.parseDouble(s);
	}

}
