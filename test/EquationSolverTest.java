import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
		solver.solve(parser.parse(""));
		Assert.assertEquals("Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n", out.toString());
		out.reset();
		solver.solve(parser.parse("1"));
		Assert.assertEquals("Reduced form: 1 * X^0 = 0\nDegree: 0\nThere is no solution because the equation is inconsistent\n", out.toString());
		out.reset();
		solver.solve(parser.parse("1 + x"));
		Assert.assertEquals("Reduced form: 1 * X^0 + 1 * X^1 = 0\nDegree: 1\nThe solutions is:\n-1.0\n", out.toString());
		out.reset();
		solver.solve(parser.parse("1 + x = 1 + x"));
		Assert.assertEquals("Reduced form: 0 = 0\nDegree: 0\nEvery value for x is a solution\n", out.toString());
		out.reset();
		solver.solve(parser.parse("1 + x = -1 + x"));
		Assert.assertEquals("Reduced form: 2 * X^0 = 0\nDegree: 0\nThere is no solution because the equation is inconsistent\n", out.toString());
	}

}
