import org.junit.*;
import org.junit.Assert.*;

public class EquationParserTest {

	@Test
	public void testParse() {
		EquationParser parser;
		Equation equation;

		parser = new EquationParser();
		equation = parser.parse("");
		Assert.assertEquals(1, 1);
	}

}
