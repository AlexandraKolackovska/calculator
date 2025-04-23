package formula;

public interface IFoOneVariable extends IFoTwoVariable{
	
	public double execute(double x);

	@Override
	default double execute(double x, double y) {
		return execute(x);
	}
}
