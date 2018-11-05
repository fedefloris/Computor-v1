import org.junit.Assert;
import org.junit.Test;

public class VariableTest {

	@Test
	public void testConstructor() {
		Variable v;

		v = new Variable(2, 10);
		Assert.assertEquals(v.getDegree(), 2);
		Assert.assertEquals(v.getCoefficient(), 10, 0);
	}

	@Test
	public void testEquals() {
		Variable v1, v2;

		v1 = new Variable(2, -123);
		v2 = new Variable(2, 1123);
		Assert.assertEquals(v1.equals(v2), true);
		v2.setDegree(1);
		Assert.assertEquals(v1.equals(v2), false);
		Assert.assertEquals(v1.equals("test"), false);
		Assert.assertEquals(v1.equals(null), false);
	}

	@Test
	public void testToString() {
		Variable v1;

		v1 = new Variable(2, 1);
		Assert.assertEquals(v1.toString(), "+ 1 * X^2");
		v1 = new Variable(0, 0);
		Assert.assertEquals(v1.toString(), "+ 0 * X^0");
		v1 = new Variable(0, 2.3);
		Assert.assertEquals(v1.toString(), "+ 2.3 * X^0");
		v1 = new Variable(2, -1.1);
		Assert.assertEquals(v1.toString(), "- 1.1 * X^2");
	}

	@Test
	public void testSetDegree() {
		Variable v;

		v = new Variable(2, 10);
		v.setDegree(0);
		Assert.assertEquals(v.getDegree(), 0);
		v.setDegree(1);
		Assert.assertEquals(v.getDegree(), 1);
	}

	@Test
	public void testSetCoefficient() {
		Variable v;

		v = new Variable(2, 10);
		v.setCoefficient(0);
		Assert.assertEquals(v.getCoefficient(), 0, 0);
		v.setCoefficient(1);
		Assert.assertEquals(v.getCoefficient(), 1, 0);
	}

	@Test
	public void testAdd() {
		Variable v1, v2;

		v1 = new Variable(2, 10);
		v2 = new Variable(2, -10);
		v1.add(v2);
		Assert.assertEquals(v1.getCoefficient(), 0, 0);
		v1.add(-20);
		Assert.assertEquals(v1.getCoefficient(), -20, 0);
		v1.add(45);
		Assert.assertEquals(v1.getCoefficient(), 25, 0);
	}
}
