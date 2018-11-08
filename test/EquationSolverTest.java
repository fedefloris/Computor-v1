import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class EquationSolverTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private final EquationParser parser = new EquationParser();
	private final EquationSolver solver = new EquationSolver();

	@Before
	public void setUpStream() {
		System.setOut(new PrintStream(out));
	}

	@After
	public void restoreStream() {
		System.setOut(originalOut);
	}

	@Test
	public void testLinearEquationSolver() {
		String[][] inputs;

		inputs = new String[][] {
			{"", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"1", "Reduced form: 1 * X^0 = 0\nDegree: 0\nThere is no solution because the equation is inconsistent\n"},
			{"1 + x = 1 + x", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"5 * X^2 = 5 * X^2", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"1 + x", "Reduced form: 1 * X^1 + 1 * X^0 = 0\nDegree: 1\nThe solutions is: -1.0\n"},
			{"2 * x ^ 1 = 3", "Reduced form: 2 * X^1 - 3 * X^0 = 0\nDegree: 1\nThe solutions is: 1.5\n"},
			{"-2 * x ^ 1 = 3", "Reduced form: -2 * X^1 - 3 * X^0 = 0\nDegree: 1\nThe solutions is: -1.5\n"},
			{"2.0 * x ^ 1 = -3.0", "Reduced form: 2 * X^1 + 3 * X^0 = 0\nDegree: 1\nThe solutions is: -1.5\n"},
			{"5 = 4 + 7 * x", "Reduced form: -7 * X^1 + 1 * X^0 = 0\nDegree: 1\nThe solutions is: 0.14285714285714285\n"},
			{"-1 + x + 2 = 2 - 1 + x", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"1 + x = -1 + x", "Reduced form: 2 * X^0 = 0\nDegree: 0\nThere is no solution because the equation is inconsistent\n"},
		};
		testInputs(inputs);
	}

	@Test
	public void testQuadraticEquationSolver() {
		String[][] inputs;

		inputs = new String[][] {
			{"x ^ 2", "Reduced form: 1 * X^2 = 0\nDegree: 2\nDiscriminant: 0.0\nThe solutions is: 0.0\n"},
			{"5 * X^0 + 13 * X^1 + 3 * X^2 = 1 * X^0 + 1 * X^1", "Reduced form: 3 * X^2 + 12 * X^1 + 4 * X^0 = 0\nDegree: 2\nDiscriminant: 96.0\nThe two solutions are:\n-3.632993161855452\n-0.3670068381445481\n"}
		};
		testInputs(inputs);
	}

	@Test
	public void testGreaterThanQuadraticEquation() {
		String[][] inputs;

		inputs = new String[][] {
			{"x ^ 3 = -1.1", "Reduced form: 1 * X^3 + 1.1 * X^0 = 0\nDegree: 3\nThe degree is strictly greater than 2, I can't solve\n"}
		};
		testInputs(inputs);
	}

	private void testInputs(String[][] inputs) {
		for (String[] input : inputs) {
			if (input.length != 2)
				continue;
			out.reset();
			solver.solve(parser.parse(input[0]));
			Assert.assertEquals(input[1], out.toString());
		}
	}

}
