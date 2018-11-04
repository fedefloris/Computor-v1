import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class EquationParserTest {

	@Test
	public void testParseEmpty() {
		EquationParser parser;
		Equation equation;

		parser = new EquationParser();
		equation = parser.parse("");
		Assert.assertEquals(equation.toString(), "0 = 0");
	}

	@Test
	public void testInvalidCoefficient() {
		List<String> inputs;

		inputs = new ArrayList<String>();
		inputs.add(".2x^1=0");
		inputs.add("a2x^1=0");
		inputs.add(".1=0");
		inputs.add("a1=0");
		testInvalidInputs(inputs);
	}

	@Test
	public void testInvalidVariable() {
		List<String> inputs;

		inputs = new ArrayList<String>();
		inputs.add("2*x^=0");
		inputs.add("2*x^1.2=0");
		inputs.add("2*x^-1=0");
		inputs.add("2*x^^=0");
		inputs.add("2*y^2=0");
		testInvalidInputs(inputs);
	}

	public void testInvalidInputs(List<String> inputs) {
		EquationParser parser;

		parser = new EquationParser();
		for (String input : inputs) {
			try {
				parser.parse(input);
			}
			catch (ParserException pe) {
				continue;
			}
			Assert.fail();
		}
	}

	@Test
	public void testParseDegree() {
		EquationParser parser;
		Equation equation;

		parser = new EquationParser();
		// equation = parser.parse("");
		// Assert.assertEquals(equation.toString(), "0 = 0");
	}

}
