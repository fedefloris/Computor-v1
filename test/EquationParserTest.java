import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class EquationParserTest {

	private final EquationParser parser = new EquationParser();

	@Test
	public void testParseEmpty() {
		Equation equation;

		equation = parser.parse("");
		Assert.assertEquals(equation.toString(), "0 = 0");
	}

	@Test
	public void testInvalidEquations() {
		List<String> inputs;

		inputs = new ArrayList<String>();
		inputs.add("a");
		inputs.add("hello");
		inputs.add(".");
		testInvalidInputs(inputs);
	}

	@Test
	public void testInvalidCoefficient() {
		List<String> inputs;

		inputs = new ArrayList<String>();
		inputs.add(".2x^1=0");
		inputs.add("a2x^1=0");
		inputs.add(".1=0");
		inputs.add("a1=0");
		inputs.add(createString('1', 350) + "*x=0");
		testInvalidInputs(inputs);
	}

	@Test
	public void testInvalidVariable() {
		List<String> inputs;

		inputs = new ArrayList<String>();
		inputs.add("2**x^1");
		inputs.add("2*x^=0");
		inputs.add("2*x^" + createString('1', 11) + "=0");
		inputs.add("2*x^1.2=0");
		inputs.add("2*x^-1=0");
		inputs.add("2*x^^=0");
		inputs.add("2*y^2=0");
		testInvalidInputs(inputs);
	}

	@Test
	public void testInvalidEqualsSign() {
		List<String> inputs;

		inputs = new ArrayList<String>();
		inputs.add("==");
		inputs.add("2*x^1=0=0");
		inputs.add("2*x^1==");
		inputs.add("0=0=2*x^1");
		inputs.add("0==2*x^1");
		inputs.add("2*x^1=2*x^1=2*x^1");
		inputs.add("2*x^1==2*x^1");
		inputs.add("==2*x^1");
		testInvalidInputs(inputs);
	}

	public void testInvalidInputs(List<String> inputs) {
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

	private String createString(char value, int size) {
		StringBuilder s;

		s = new StringBuilder(size);
		for (int i = 0; i < size; i++)
			s.append(value);
		return (s.toString());
	}

}
