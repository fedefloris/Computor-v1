import org.junit.*;
import org.junit.Assert.*;

public class VariableTest {
	@Test
	public void testConstructor() {
		Variable v = new Variable(2, 10);
		Assert.assertEquals(v.getDegree(), 2);
		Assert.assertEquals(v.getCoefficient(), 10);
	}
}