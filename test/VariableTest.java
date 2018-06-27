import org.junit.*;
import org.junit.Assert.*;

public class VariableTest {

	@Test
	public void testConstructor() {
		Variable v = new Variable(2, 10);
		Assert.assertEquals(v.getDegree(), 2);
		Assert.assertEquals(v.getCoefficient(), 10);
	}

	@Test
	public void testSetDegree() {
		Variable v = new Variable(2, 10);
		v.setDegree(0);
		Assert.assertEquals(v.getDegree(), 0);
		v.setDegree(1);
		Assert.assertEquals(v.getDegree(), 1);
	}

	@Test
	public void testSetCoefficient() {
		Variable v = new Variable(2, 10);
		v.setCoefficient(0);
		Assert.assertEquals(v.getCoefficient(), 0);
		v.setCoefficient(1);
		Assert.assertEquals(v.getCoefficient(), 1);
	}
}