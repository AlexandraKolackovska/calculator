package formula;

public class FoNegative implements IFoOneVariable {

	FoSubtract foSubtract = new FoSubtract();
	
	@Override
	public double execute(double x) {
		return foSubtract.execute(0,x);
	}
}
