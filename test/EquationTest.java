import java.util.*;
import org.junit.*;
import org.junit.Assert.*;

public class EquationTest {

	@Test
	public void testToString() {
		Equation equation;

		equation = new Equation();
		Assert.assertEquals(equation.toString(), "");
		equation.add(new Variable(0, 2));
		Assert.assertEquals(equation.toString(), "2 * X^0 = 0");
		equation.add(new Variable(0, 2));
		Assert.assertEquals(equation.toString(), "4 * X^0 = 0");
		equation.add(new Variable(1, 5));
		equation.add(new Variable(1, -1));
		equation.add(new Variable(2, -9.3));
		Assert.assertEquals(equation.toString(), "4 * X^0 + 4 * X^1 - 9.3 * X^2 = 0");
		equation.add(new Variable(2, 9.3));
		Assert.assertEquals(equation.toString(), "4 * X^0 + 4 * X^1 = 0");
		equation.add(new Variable(1, -4));
		Assert.assertEquals(equation.toString(), "4 * X^0 = 0");
		equation.add(new Variable(0, -4));
		Assert.assertEquals(equation.toString(), "");
	}

	@Test
	public void testGetVariables() {
		List<Variable> variables;
		Equation equation;

		equation = new Equation();
		variables = equation.getVariables();
		Assert.assertTrue(variables.size() == 0);
		equation.add(new Variable(1, 2));
		Assert.assertTrue(variables.size() == 1);
		equation.add(new Variable(1, 0));
		Assert.assertTrue(variables.size() == 1);
		equation.add(new Variable(2, 0));
		Assert.assertTrue(variables.size() == 2);
	}

	@Test
	public void testAdd() {
		List<Variable> variables;
		Equation equation;

		equation = new Equation();
		Assert.assertTrue(equation.getVariables().size() == 0);
		equation.add(new Variable(1, 2));
		variables = equation.getVariables();
		Assert.assertTrue(variables.get(0).getDegree() == 1 && variables.get(0).getCoefficient() == 2);
		Assert.assertTrue(variables.size() == 1);
		equation.add(new Variable(1, -1));
		Assert.assertTrue(variables.get(0).getDegree() == 1 && variables.get(0).getCoefficient() == 1);
		Assert.assertTrue(variables.size() == 1);
		equation.add(new Variable(2, 0));
		Assert.assertTrue(variables.size() == 2);
		Assert.assertTrue(variables.get(1).getDegree() == 2 && variables.get(1).getCoefficient() == 0);
	}

	@Test
	public void testGetDegree() {
		Equation equation;

		equation = new Equation();
		Assert.assertTrue(equation.getDegree() == 0);
		equation.add(new Variable(1, 2));
		Assert.assertTrue(equation.getDegree() == 1);
		equation.add(new Variable(1, 1));
		Assert.assertTrue(equation.getDegree() == 1);
		equation.add(new Variable(2, 1));
		Assert.assertTrue(equation.getDegree() == 2);
		equation.add(new Variable(3, 1));
		Assert.assertTrue(equation.getDegree() == 3);
		equation.add(new Variable(3, -1));
		Assert.assertTrue(equation.getDegree() == 2);
	}

}