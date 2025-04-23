package formula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoAddTest extends FoAdd{
	
	private FoAdd fo;

	@Test
	public void testExecute() {
		assertEquals(fo.execute(4, 5), 9);
	}

	@Test
	public void testExecuteArray() {
		assertEquals(fo.execute(new double[] {1, 5, 3}), 9);
	}
}
