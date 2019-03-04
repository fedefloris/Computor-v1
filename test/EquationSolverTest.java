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
			{"0.0 = 0.0", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"00 = 0*1", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"00 = 0*0", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"1", "Reduced form: 1 * X^0 = 0\nDegree: 0\nThere is no solution because the equation is inconsistent\n"},
			{"1*1 + x = 1 + x", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"5 * X^2 = 5 * X^2", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"1 + x", "Reduced form: 1 * X^1 + 1 * X^0 = 0\nDegree: 1\nThe solution is: -1.0\n"},
			{"2 * 1 * x ^ 1 = 3", "Reduced form: 2 * X^1 - 3 * X^0 = 0\nDegree: 1\nThe solution is: 1.5\n"},
			{"-2 * x ^ 1 = 3", "Reduced form: -2 * X^1 - 3 * X^0 = 0\nDegree: 1\nThe solution is: -1.5\n"},
			{"2.0 * x ^ 1 = -3.0", "Reduced form: 2 * X^1 + 3 * X^0 = 0\nDegree: 1\nThe solution is: -1.5\n"},
			{"5 = 2*2 + 7 * x", "Reduced form: -7 * X^1 + 1 * X^0 = 0\nDegree: 1\nThe solution is: 0.14285714285714285\n"},
			{"-1 + x + 2*1 = 2 - 1 + x", "Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n"},
			{"1*1 + x = -1*1 + x", "Reduced form: 2 * X^0 = 0\nDegree: 0\nThere is no solution because the equation is inconsistent\n"}
		};
		testInputs(inputs);
	}

	@Test
	public void testQuadraticEquationSolver() {
		String[][] inputs;

		inputs = new String[][] {
			{"x ^ 2 + 0 = 0", "Reduced form: 1 * X^2 = 0\nDegree: 2\nDiscriminant: 0.0\nThe solution is: 0.0\n"},
			{"x2 + 0 = 0", "Reduced form: 1 * X^2 = 0\nDegree: 2\nDiscriminant: 0.0\nThe solution is: 0.0\n"},
			{"5 * 10 * 0.1 * X^0 + 13 * 1.0 * X^1 + 3 * X^2 = 1 * X^0 + 1 * X^1", "Reduced form: 3 * X^2 + 12 * X^1 + 4 * X^0 = 0\nDegree: 2\nDiscriminant: 96.0\nThe two solutions are:\n-3.632993161855452\n-0.3670068381445481\n"},
			{"x^2 - 15 * X + 56 = 0", "Reduced form: 1 * X^2 - 15 * X^1 + 56 * X^0 = 0\nDegree: 2\nDiscriminant: 1.0\nThe two solutions are:\n7.0\n8.0\n"},
			{"x2 - 15 * X1 + 56 = 0", "Reduced form: 1 * X^2 - 15 * X^1 + 56 * X^0 = 0\nDegree: 2\nDiscriminant: 1.0\nThe two solutions are:\n7.0\n8.0\n"},
			{"+2 * X^2 + 7 * X + 4", "Reduced form: 2 * X^2 + 7 * X^1 + 4 * X^0 = 0\nDegree: 2\nDiscriminant: 17.0\nThe two solutions are:\n-2.7807764064044154\n-0.7192235935955849\n"},
			{"5.0 * -2 * -0.5 * X^0 + 3 * X^1 + 3 * X^2 = 1 * X^0 + 0 * X^1", "Reduced form: 3 * X^2 + 3 * X^1 + 4 * X^0 = 0\nDegree: 2\nDiscriminant: -39.0\nThe two solutions are:\n-0.5 - 1.0408329997330663i\n-0.5 + 1.0408329997330663i\n"},
			{"5.0 * -2 * -0.5 * X0 + 3 * X1 + 3 * X2 = 1 * X0 + 0 * X1", "Reduced form: 3 * X^2 + 3 * X^1 + 4 * X^0 = 0\nDegree: 2\nDiscriminant: -39.0\nThe two solutions are:\n-0.5 - 1.0408329997330663i\n-0.5 + 1.0408329997330663i\n"}
		};
		testInputs(inputs);
	}

	@Test
	public void testCubicEquationSolver() {
		String[][] inputs;

		inputs = new String[][] {
			{"2*x3 - 4*x2 - 22*x + 24", "Reduced form: 2 * X^3 - 4 * X^2 - 22 * X^1 + 24 * X^0 = 0\nDegree: 3\nThe solutions are:\n3.9999999999999996\n-2.999999999999999\n0.9999999999999996\n"},
			{"3*x3 - 10*x2 + 14*x + 27", "Reduced form: 3 * X^3 - 10 * X^2 + 14 * X^1 + 27 * X^0 = 0\nDegree: 3\nThe solutions are:\n-0.9999999999999933\n2.1666666666666634 + 2.0749832663314605i\n2.1666666666666634 - 2.0749832663314605i\n"},
			{"x3 + 6*x2 + 12*x + 8", "Reduced form: 1 * X^3 + 6 * X^2 + 12 * X^1 + 8 * X^0 = 0\nDegree: 3\nThe solution is: -2.0\n"},
			{"1 * X^3 + 2 * X^2 + 1 * X^1 - 4 * X^0 = 0", "Reduced form: 1 * X^3 + 2 * X^2 + 1 * X^1 - 4 * X^0 = 0\nDegree: 3\nThe solutions are:\n1.000000000000003\n-1.5000000000000016 + 1.3228756555322925i\n-1.5000000000000016 - 1.3228756555322925i\n"},
		};
		testInputs(inputs);
	}

	@Test
	public void testGreaterThanCubicEquation() {
		String[][] inputs;

		inputs = new String[][] {
			{"x ^ 4 = -1.1", "Reduced form: 1 * X^4 + 1.1 * X^0 = 0\nDegree: 4\nThe degree is strictly greater than 3, I can't solve\n"},
			{"x ^ 99999999", "Reduced form: 1 * X^99999999 = 0\nDegree: 99999999\nThe degree is strictly greater than 3, I can't solve\n"}
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
